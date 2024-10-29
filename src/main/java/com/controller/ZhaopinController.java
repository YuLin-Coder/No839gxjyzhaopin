
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 职位招聘
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhaopin")
public class ZhaopinController {
    private static final Logger logger = LoggerFactory.getLogger(ZhaopinController.class);

    private static final String TABLE_NAME = "zhaopin";

    @Autowired
    private ZhaopinService zhaopinService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BiyequxiangService biyequxiangService;//毕业去向
    @Autowired
    private ChatService chatService;//就业咨询
    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private FudaoyuanService fudaoyuanService;//辅导员
    @Autowired
    private GonggaoService gonggaoService;//招聘公告
    @Autowired
    private JianliService jianliService;//简历
    @Autowired
    private JiuyezhishiService jiuyezhishiService;//就业知识
    @Autowired
    private JiuyezhishiCollectionService jiuyezhishiCollectionService;//就业知识收藏
    @Autowired
    private JiuyezhishiLiuyanService jiuyezhishiLiuyanService;//就业知识留言
    @Autowired
    private QiyeService qiyeService;//企业
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhaopinCollectionService zhaopinCollectionService;//职位收藏
    @Autowired
    private ZhaopinLiuyanService zhaopinLiuyanService;//职位留言
    @Autowired
    private ZhaopinToudiService zhaopinToudiService;//简历投递
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("辅导员".equals(role))
            params.put("fudaoyuanId",request.getSession().getAttribute("userId"));
        else if("企业".equals(role))
            params.put("qiyeId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = zhaopinService.queryPage(params);

        //字典表数据转换
        List<ZhaopinView> list =(List<ZhaopinView>)page.getList();
        for(ZhaopinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhaopinEntity zhaopin = zhaopinService.selectById(id);
        if(zhaopin !=null){
            //entity转view
            ZhaopinView view = new ZhaopinView();
            BeanUtils.copyProperties( zhaopin , view );//把实体数据重构到view中
            //级联表 企业
            //级联表
            QiyeEntity qiye = qiyeService.selectById(zhaopin.getQiyeId());
            if(qiye != null){
            BeanUtils.copyProperties( qiye , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "qiyeId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setQiyeId(qiye.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaopinEntity zhaopin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhaopin:{}",this.getClass().getName(),zhaopin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("企业".equals(role))
            zhaopin.setQiyeId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhaopinEntity> queryWrapper = new EntityWrapper<ZhaopinEntity>()
            .eq("qiye_id", zhaopin.getQiyeId())
            .eq("zhaopin_name", zhaopin.getZhaopinName())
            .eq("zhaopin_daiyu", zhaopin.getZhaopinDaiyu())
            .eq("zhaopin_address", zhaopin.getZhaopinAddress())
            .eq("lianxiren_name", zhaopin.getLianxirenName())
            .eq("zhaopin_phone", zhaopin.getZhaopinPhone())
            .eq("zhaopin_types", zhaopin.getZhaopinTypes())
            .eq("leixing_types", zhaopin.getLeixingTypes())
            .eq("zan_number", zhaopin.getZanNumber())
            .eq("cai_number", zhaopin.getCaiNumber())
            .eq("zhaopin_renshu_number", zhaopin.getZhaopinRenshuNumber())
            .eq("shangxia_types", zhaopin.getShangxiaTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhaopinEntity zhaopinEntity = zhaopinService.selectOne(queryWrapper);
        if(zhaopinEntity==null){
            zhaopin.setShangxiaTypes(1);
            zhaopin.setCreateTime(new Date());
            zhaopinService.insert(zhaopin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhaopinEntity zhaopin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhaopin:{}",this.getClass().getName(),zhaopin.toString());
        ZhaopinEntity oldZhaopinEntity = zhaopinService.selectById(zhaopin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("企业".equals(role))
//            zhaopin.setQiyeId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(zhaopin.getZhaopinPhoto()) || "null".equals(zhaopin.getZhaopinPhoto())){
                zhaopin.setZhaopinPhoto(null);
        }

            zhaopinService.updateById(zhaopin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhaopinEntity> oldZhaopinList =zhaopinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhaopinService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ZhaopinEntity> zhaopinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhaopinEntity zhaopinEntity = new ZhaopinEntity();
//                            zhaopinEntity.setQiyeId(Integer.valueOf(data.get(0)));   //企业 要改的
//                            zhaopinEntity.setZhaopinName(data.get(0));                    //招聘信息名称 要改的
//                            zhaopinEntity.setZhaopinPhoto("");//详情和图片
//                            zhaopinEntity.setZhaopinDaiyu(data.get(0));                    //薪资待遇 要改的
//                            zhaopinEntity.setZhaopinAddress(data.get(0));                    //上班地点 要改的
//                            zhaopinEntity.setLianxirenName(data.get(0));                    //联系人 要改的
//                            zhaopinEntity.setZhaopinPhone(data.get(0));                    //招聘电话 要改的
//                            zhaopinEntity.setZhaopinTypes(Integer.valueOf(data.get(0)));   //招聘岗位 要改的
//                            zhaopinEntity.setLeixingTypes(Integer.valueOf(data.get(0)));   //招聘类型 要改的
//                            zhaopinEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            zhaopinEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            zhaopinEntity.setZhaopinRenshuNumber(Integer.valueOf(data.get(0)));   //招聘人数 要改的
//                            zhaopinEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            zhaopinEntity.setZhaopinContent("");//详情和图片
//                            zhaopinEntity.setCreateTime(date);//时间
                            zhaopinList.add(zhaopinEntity);


                            //把要查询是否重复的字段放入map中
                                //招聘电话
                                if(seachFields.containsKey("zhaopinPhone")){
                                    List<String> zhaopinPhone = seachFields.get("zhaopinPhone");
                                    zhaopinPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zhaopinPhone = new ArrayList<>();
                                    zhaopinPhone.add(data.get(0));//要改的
                                    seachFields.put("zhaopinPhone",zhaopinPhone);
                                }
                        }

                        //查询是否重复
                         //招聘电话
                        List<ZhaopinEntity> zhaopinEntities_zhaopinPhone = zhaopinService.selectList(new EntityWrapper<ZhaopinEntity>().in("zhaopin_phone", seachFields.get("zhaopinPhone")));
                        if(zhaopinEntities_zhaopinPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhaopinEntity s:zhaopinEntities_zhaopinPhone){
                                repeatFields.add(s.getZhaopinPhone());
                            }
                            return R.error(511,"数据库的该表中的 [招聘电话] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhaopinService.insertBatch(zhaopinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<ZhaopinView> returnZhaopinViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = zhaopinCollectionService.queryPage(params1);
        List<ZhaopinCollectionView> collectionViewsList =(List<ZhaopinCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(ZhaopinCollectionView collectionView:collectionViewsList){
            Integer zhaopinTypes = collectionView.getZhaopinTypes();
            if(typeMap.containsKey(zhaopinTypes)){
                typeMap.put(zhaopinTypes,typeMap.get(zhaopinTypes)+1);
            }else{
                typeMap.put(zhaopinTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("zhaopinTypes",type);
            PageUtils pageUtils1 = zhaopinService.queryPage(params2);
            List<ZhaopinView> zhaopinViewList =(List<ZhaopinView>)pageUtils1.getList();
            returnZhaopinViewList.addAll(zhaopinViewList);
            if(returnZhaopinViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = zhaopinService.queryPage(params);
        if(returnZhaopinViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnZhaopinViewList.size();//要添加的数量
            List<ZhaopinView> zhaopinViewList =(List<ZhaopinView>)page.getList();
            for(ZhaopinView zhaopinView:zhaopinViewList){
                Boolean addFlag = true;
                for(ZhaopinView returnZhaopinView:returnZhaopinViewList){
                    if(returnZhaopinView.getId().intValue() ==zhaopinView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnZhaopinViewList.add(zhaopinView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnZhaopinViewList = returnZhaopinViewList.subList(0, limit);
        }

        for(ZhaopinView c:returnZhaopinViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnZhaopinViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhaopinService.queryPage(params);

        //字典表数据转换
        List<ZhaopinView> list =(List<ZhaopinView>)page.getList();
        for(ZhaopinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhaopinEntity zhaopin = zhaopinService.selectById(id);
            if(zhaopin !=null){


                //entity转view
                ZhaopinView view = new ZhaopinView();
                BeanUtils.copyProperties( zhaopin , view );//把实体数据重构到view中

                //级联表
                    QiyeEntity qiye = qiyeService.selectById(zhaopin.getQiyeId());
                if(qiye != null){
                    BeanUtils.copyProperties( qiye , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setQiyeId(qiye.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaopinEntity zhaopin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhaopin:{}",this.getClass().getName(),zhaopin.toString());
        Wrapper<ZhaopinEntity> queryWrapper = new EntityWrapper<ZhaopinEntity>()
            .eq("qiye_id", zhaopin.getQiyeId())
            .eq("zhaopin_name", zhaopin.getZhaopinName())
            .eq("zhaopin_daiyu", zhaopin.getZhaopinDaiyu())
            .eq("zhaopin_address", zhaopin.getZhaopinAddress())
            .eq("lianxiren_name", zhaopin.getLianxirenName())
            .eq("zhaopin_phone", zhaopin.getZhaopinPhone())
            .eq("zhaopin_types", zhaopin.getZhaopinTypes())
            .eq("leixing_types", zhaopin.getLeixingTypes())
            .eq("zan_number", zhaopin.getZanNumber())
            .eq("cai_number", zhaopin.getCaiNumber())
            .eq("zhaopin_renshu_number", zhaopin.getZhaopinRenshuNumber())
            .eq("shangxia_types", zhaopin.getShangxiaTypes())
//            .notIn("zhaopin_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhaopinEntity zhaopinEntity = zhaopinService.selectOne(queryWrapper);
        if(zhaopinEntity==null){
                zhaopin.setZanNumber(1);
                zhaopin.setCaiNumber(1);
            zhaopin.setCreateTime(new Date());
        zhaopinService.insert(zhaopin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

