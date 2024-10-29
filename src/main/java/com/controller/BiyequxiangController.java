
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
 * 毕业去向
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/biyequxiang")
public class BiyequxiangController {
    private static final Logger logger = LoggerFactory.getLogger(BiyequxiangController.class);

    private static final String TABLE_NAME = "biyequxiang";

    @Autowired
    private BiyequxiangService biyequxiangService;


    @Autowired
    private TokenService tokenService;

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
        CommonUtil.checkMap(params);
        PageUtils page = biyequxiangService.queryPage(params);

        //字典表数据转换
        List<BiyequxiangView> list =(List<BiyequxiangView>)page.getList();
        for(BiyequxiangView c:list){
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
        BiyequxiangEntity biyequxiang = biyequxiangService.selectById(id);
        if(biyequxiang !=null){
            //entity转view
            BiyequxiangView view = new BiyequxiangView();
            BeanUtils.copyProperties( biyequxiang , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(biyequxiang.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody BiyequxiangEntity biyequxiang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,biyequxiang:{}",this.getClass().getName(),biyequxiang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            biyequxiang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BiyequxiangEntity> queryWrapper = new EntityWrapper<BiyequxiangEntity>()
            .eq("yonghu_id", biyequxiang.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BiyequxiangEntity biyequxiangEntity = biyequxiangService.selectOne(queryWrapper);
        if(biyequxiangEntity==null){
            biyequxiang.setInsertTime(new Date());
            biyequxiang.setCreateTime(new Date());
            biyequxiangService.insert(biyequxiang);
            return R.ok();
        }else {
            return R.error(511,"一个用户只能有一个毕业去向");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BiyequxiangEntity biyequxiang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,biyequxiang:{}",this.getClass().getName(),biyequxiang.toString());
        BiyequxiangEntity oldBiyequxiangEntity = biyequxiangService.selectById(biyequxiang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            biyequxiang.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(biyequxiang.getBiyequxiangFile()) || "null".equals(biyequxiang.getBiyequxiangFile())){
                biyequxiang.setBiyequxiangFile(null);
        }

            biyequxiangService.updateById(biyequxiang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<BiyequxiangEntity> oldBiyequxiangList =biyequxiangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        biyequxiangService.deleteBatchIds(Arrays.asList(ids));

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
            List<BiyequxiangEntity> biyequxiangList = new ArrayList<>();//上传的东西
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
                            BiyequxiangEntity biyequxiangEntity = new BiyequxiangEntity();
//                            biyequxiangEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            biyequxiangEntity.setBiyequxiangUuidNumber(data.get(0));                    //毕业去向编号 要改的
//                            biyequxiangEntity.setBiyequxiangTypes(Integer.valueOf(data.get(0)));   //毕业去向类型 要改的
//                            biyequxiangEntity.setBiyequxiangFile(data.get(0));                    //附件 要改的
//                            biyequxiangEntity.setGongsiName(data.get(0));                    //公司名称 要改的
//                            biyequxiangEntity.setGongsiAddress(data.get(0));                    //公司位置 要改的
//                            biyequxiangEntity.setBiyequxiangXinzi(Integer.valueOf(data.get(0)));   //薪资 要改的
//                            biyequxiangEntity.setBiyequxiangTime(sdf.parse(data.get(0)));          //去往时间 要改的
//                            biyequxiangEntity.setBiyequxiangContent("");//详情和图片
//                            biyequxiangEntity.setInsertTime(date);//时间
//                            biyequxiangEntity.setCreateTime(date);//时间
                            biyequxiangList.add(biyequxiangEntity);


                            //把要查询是否重复的字段放入map中
                                //毕业去向编号
                                if(seachFields.containsKey("biyequxiangUuidNumber")){
                                    List<String> biyequxiangUuidNumber = seachFields.get("biyequxiangUuidNumber");
                                    biyequxiangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> biyequxiangUuidNumber = new ArrayList<>();
                                    biyequxiangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("biyequxiangUuidNumber",biyequxiangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //毕业去向编号
                        List<BiyequxiangEntity> biyequxiangEntities_biyequxiangUuidNumber = biyequxiangService.selectList(new EntityWrapper<BiyequxiangEntity>().in("biyequxiang_uuid_number", seachFields.get("biyequxiangUuidNumber")));
                        if(biyequxiangEntities_biyequxiangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BiyequxiangEntity s:biyequxiangEntities_biyequxiangUuidNumber){
                                repeatFields.add(s.getBiyequxiangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [毕业去向编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        biyequxiangService.insertBatch(biyequxiangList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = biyequxiangService.queryPage(params);

        //字典表数据转换
        List<BiyequxiangView> list =(List<BiyequxiangView>)page.getList();
        for(BiyequxiangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BiyequxiangEntity biyequxiang = biyequxiangService.selectById(id);
            if(biyequxiang !=null){


                //entity转view
                BiyequxiangView view = new BiyequxiangView();
                BeanUtils.copyProperties( biyequxiang , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(biyequxiang.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody BiyequxiangEntity biyequxiang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,biyequxiang:{}",this.getClass().getName(),biyequxiang.toString());
        Wrapper<BiyequxiangEntity> queryWrapper = new EntityWrapper<BiyequxiangEntity>()
            .eq("yonghu_id", biyequxiang.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BiyequxiangEntity biyequxiangEntity = biyequxiangService.selectOne(queryWrapper);
        if(biyequxiangEntity==null){
            biyequxiang.setInsertTime(new Date());
            biyequxiang.setCreateTime(new Date());
        biyequxiangService.insert(biyequxiang);

            return R.ok();
        }else {
            return R.error(511,"一个用户只能有一条毕业去向");
        }
    }

}

