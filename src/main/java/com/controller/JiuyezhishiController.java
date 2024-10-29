
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
 * 就业知识
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiuyezhishi")
public class JiuyezhishiController {
    private static final Logger logger = LoggerFactory.getLogger(JiuyezhishiController.class);

    private static final String TABLE_NAME = "jiuyezhishi";

    @Autowired
    private JiuyezhishiService jiuyezhishiService;


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
    private JiuyezhishiCollectionService jiuyezhishiCollectionService;//就业知识收藏
    @Autowired
    private JiuyezhishiLiuyanService jiuyezhishiLiuyanService;//就业知识留言
    @Autowired
    private QiyeService qiyeService;//企业
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhaopinService zhaopinService;//职位招聘
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
        params.put("jiuyezhishiDeleteStart",1);params.put("jiuyezhishiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiuyezhishiService.queryPage(params);

        //字典表数据转换
        List<JiuyezhishiView> list =(List<JiuyezhishiView>)page.getList();
        for(JiuyezhishiView c:list){
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
        JiuyezhishiEntity jiuyezhishi = jiuyezhishiService.selectById(id);
        if(jiuyezhishi !=null){
            //entity转view
            JiuyezhishiView view = new JiuyezhishiView();
            BeanUtils.copyProperties( jiuyezhishi , view );//把实体数据重构到view中
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
    public R save(@RequestBody JiuyezhishiEntity jiuyezhishi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiuyezhishi:{}",this.getClass().getName(),jiuyezhishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiuyezhishiEntity> queryWrapper = new EntityWrapper<JiuyezhishiEntity>()
            .eq("jiuyezhishi_name", jiuyezhishi.getJiuyezhishiName())
            .eq("jiuyezhishi_video", jiuyezhishi.getJiuyezhishiVideo())
            .eq("zan_number", jiuyezhishi.getZanNumber())
            .eq("cai_number", jiuyezhishi.getCaiNumber())
            .eq("jiuyezhishi_types", jiuyezhishi.getJiuyezhishiTypes())
            .eq("shangxia_types", jiuyezhishi.getShangxiaTypes())
            .eq("jiuyezhishi_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiuyezhishiEntity jiuyezhishiEntity = jiuyezhishiService.selectOne(queryWrapper);
        if(jiuyezhishiEntity==null){
            jiuyezhishi.setJiuyezhishiClicknum(1);
            jiuyezhishi.setShangxiaTypes(1);
            jiuyezhishi.setJiuyezhishiDelete(1);
            jiuyezhishi.setInsertTime(new Date());
            jiuyezhishi.setCreateTime(new Date());
            jiuyezhishiService.insert(jiuyezhishi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiuyezhishiEntity jiuyezhishi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiuyezhishi:{}",this.getClass().getName(),jiuyezhishi.toString());
        JiuyezhishiEntity oldJiuyezhishiEntity = jiuyezhishiService.selectById(jiuyezhishi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jiuyezhishi.getJiuyezhishiPhoto()) || "null".equals(jiuyezhishi.getJiuyezhishiPhoto())){
                jiuyezhishi.setJiuyezhishiPhoto(null);
        }
        if("".equals(jiuyezhishi.getJiuyezhishiFile()) || "null".equals(jiuyezhishi.getJiuyezhishiFile())){
                jiuyezhishi.setJiuyezhishiFile(null);
        }
        if("".equals(jiuyezhishi.getJiuyezhishiVideo()) || "null".equals(jiuyezhishi.getJiuyezhishiVideo())){
                jiuyezhishi.setJiuyezhishiVideo(null);
        }

            jiuyezhishiService.updateById(jiuyezhishi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiuyezhishiEntity> oldJiuyezhishiList =jiuyezhishiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiuyezhishiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiuyezhishiEntity jiuyezhishiEntity = new JiuyezhishiEntity();
            jiuyezhishiEntity.setId(id);
            jiuyezhishiEntity.setJiuyezhishiDelete(2);
            list.add(jiuyezhishiEntity);
        }
        if(list != null && list.size() >0){
            jiuyezhishiService.updateBatchById(list);
        }

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
            List<JiuyezhishiEntity> jiuyezhishiList = new ArrayList<>();//上传的东西
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
                            JiuyezhishiEntity jiuyezhishiEntity = new JiuyezhishiEntity();
//                            jiuyezhishiEntity.setJiuyezhishiName(data.get(0));                    //就业知识名称 要改的
//                            jiuyezhishiEntity.setJiuyezhishiUuidNumber(data.get(0));                    //就业知识编号 要改的
//                            jiuyezhishiEntity.setJiuyezhishiPhoto("");//详情和图片
//                            jiuyezhishiEntity.setJiuyezhishiFile(data.get(0));                    //附件 要改的
//                            jiuyezhishiEntity.setJiuyezhishiVideo(data.get(0));                    //就业知识视频 要改的
//                            jiuyezhishiEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            jiuyezhishiEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            jiuyezhishiEntity.setJiuyezhishiTypes(Integer.valueOf(data.get(0)));   //就业知识类型 要改的
//                            jiuyezhishiEntity.setJiuyezhishiClicknum(Integer.valueOf(data.get(0)));   //就业知识热度 要改的
//                            jiuyezhishiEntity.setJiuyezhishiContent("");//详情和图片
//                            jiuyezhishiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            jiuyezhishiEntity.setJiuyezhishiDelete(1);//逻辑删除字段
//                            jiuyezhishiEntity.setInsertTime(date);//时间
//                            jiuyezhishiEntity.setCreateTime(date);//时间
                            jiuyezhishiList.add(jiuyezhishiEntity);


                            //把要查询是否重复的字段放入map中
                                //就业知识编号
                                if(seachFields.containsKey("jiuyezhishiUuidNumber")){
                                    List<String> jiuyezhishiUuidNumber = seachFields.get("jiuyezhishiUuidNumber");
                                    jiuyezhishiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiuyezhishiUuidNumber = new ArrayList<>();
                                    jiuyezhishiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiuyezhishiUuidNumber",jiuyezhishiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //就业知识编号
                        List<JiuyezhishiEntity> jiuyezhishiEntities_jiuyezhishiUuidNumber = jiuyezhishiService.selectList(new EntityWrapper<JiuyezhishiEntity>().in("jiuyezhishi_uuid_number", seachFields.get("jiuyezhishiUuidNumber")).eq("jiuyezhishi_delete", 1));
                        if(jiuyezhishiEntities_jiuyezhishiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiuyezhishiEntity s:jiuyezhishiEntities_jiuyezhishiUuidNumber){
                                repeatFields.add(s.getJiuyezhishiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [就业知识编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiuyezhishiService.insertBatch(jiuyezhishiList);
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
        List<JiuyezhishiView> returnJiuyezhishiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = jiuyezhishiCollectionService.queryPage(params1);
        List<JiuyezhishiCollectionView> collectionViewsList =(List<JiuyezhishiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(JiuyezhishiCollectionView collectionView:collectionViewsList){
            Integer jiuyezhishiTypes = collectionView.getJiuyezhishiTypes();
            if(typeMap.containsKey(jiuyezhishiTypes)){
                typeMap.put(jiuyezhishiTypes,typeMap.get(jiuyezhishiTypes)+1);
            }else{
                typeMap.put(jiuyezhishiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("jiuyezhishiTypes",type);
            PageUtils pageUtils1 = jiuyezhishiService.queryPage(params2);
            List<JiuyezhishiView> jiuyezhishiViewList =(List<JiuyezhishiView>)pageUtils1.getList();
            returnJiuyezhishiViewList.addAll(jiuyezhishiViewList);
            if(returnJiuyezhishiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = jiuyezhishiService.queryPage(params);
        if(returnJiuyezhishiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnJiuyezhishiViewList.size();//要添加的数量
            List<JiuyezhishiView> jiuyezhishiViewList =(List<JiuyezhishiView>)page.getList();
            for(JiuyezhishiView jiuyezhishiView:jiuyezhishiViewList){
                Boolean addFlag = true;
                for(JiuyezhishiView returnJiuyezhishiView:returnJiuyezhishiViewList){
                    if(returnJiuyezhishiView.getId().intValue() ==jiuyezhishiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnJiuyezhishiViewList.add(jiuyezhishiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnJiuyezhishiViewList = returnJiuyezhishiViewList.subList(0, limit);
        }

        for(JiuyezhishiView c:returnJiuyezhishiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnJiuyezhishiViewList);
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
        PageUtils page = jiuyezhishiService.queryPage(params);

        //字典表数据转换
        List<JiuyezhishiView> list =(List<JiuyezhishiView>)page.getList();
        for(JiuyezhishiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiuyezhishiEntity jiuyezhishi = jiuyezhishiService.selectById(id);
            if(jiuyezhishi !=null){

                //点击数量加1
                jiuyezhishi.setJiuyezhishiClicknum(jiuyezhishi.getJiuyezhishiClicknum()+1);
                jiuyezhishiService.updateById(jiuyezhishi);

                //entity转view
                JiuyezhishiView view = new JiuyezhishiView();
                BeanUtils.copyProperties( jiuyezhishi , view );//把实体数据重构到view中

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
    public R add(@RequestBody JiuyezhishiEntity jiuyezhishi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiuyezhishi:{}",this.getClass().getName(),jiuyezhishi.toString());
        Wrapper<JiuyezhishiEntity> queryWrapper = new EntityWrapper<JiuyezhishiEntity>()
            .eq("jiuyezhishi_name", jiuyezhishi.getJiuyezhishiName())
            .eq("jiuyezhishi_uuid_number", jiuyezhishi.getJiuyezhishiUuidNumber())
            .eq("jiuyezhishi_video", jiuyezhishi.getJiuyezhishiVideo())
            .eq("zan_number", jiuyezhishi.getZanNumber())
            .eq("cai_number", jiuyezhishi.getCaiNumber())
            .eq("jiuyezhishi_types", jiuyezhishi.getJiuyezhishiTypes())
            .eq("jiuyezhishi_clicknum", jiuyezhishi.getJiuyezhishiClicknum())
            .eq("shangxia_types", jiuyezhishi.getShangxiaTypes())
            .eq("jiuyezhishi_delete", jiuyezhishi.getJiuyezhishiDelete())
//            .notIn("jiuyezhishi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiuyezhishiEntity jiuyezhishiEntity = jiuyezhishiService.selectOne(queryWrapper);
        if(jiuyezhishiEntity==null){
                jiuyezhishi.setZanNumber(1);
                jiuyezhishi.setCaiNumber(1);
            jiuyezhishi.setJiuyezhishiClicknum(1);
            jiuyezhishi.setJiuyezhishiDelete(1);
            jiuyezhishi.setInsertTime(new Date());
            jiuyezhishi.setCreateTime(new Date());
        jiuyezhishiService.insert(jiuyezhishi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

