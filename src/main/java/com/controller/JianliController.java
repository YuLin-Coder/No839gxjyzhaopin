
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
 * 简历
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jianli")
public class JianliController {
    private static final Logger logger = LoggerFactory.getLogger(JianliController.class);

    private static final String TABLE_NAME = "jianli";

    @Autowired
    private JianliService jianliService;


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
        PageUtils page = jianliService.queryPage(params);

        //字典表数据转换
        List<JianliView> list =(List<JianliView>)page.getList();
        for(JianliView c:list){
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
        JianliEntity jianli = jianliService.selectById(id);
        if(jianli !=null){
            //entity转view
            JianliView view = new JianliView();
            BeanUtils.copyProperties( jianli , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jianli.getYonghuId());
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
    public R save(@RequestBody JianliEntity jianli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jianli:{}",this.getClass().getName(),jianli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jianli.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JianliEntity> queryWrapper = new EntityWrapper<JianliEntity>()
            .eq("yonghu_id", jianli.getYonghuId())
            .eq("jianli_name", jianli.getJianliName())
            .eq("jianli_xingming", jianli.getJianliXingming())
            .eq("jianli_types", jianli.getJianliTypes())
            .eq("jianli_xinzi", jianli.getJianliXinzi())
            .eq("jianli_xueli", jianli.getJianliXueli())
            .eq("jianli_jingli", jianli.getJianliJingli())
            .eq("sex_types", jianli.getSexTypes())
            .eq("jianli_phone", jianli.getJianliPhone())
            .eq("jianli_address", jianli.getJianliAddress())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianliEntity jianliEntity = jianliService.selectOne(queryWrapper);
        if(jianliEntity==null){
            jianli.setCreateTime(new Date());
            jianliService.insert(jianli);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianliEntity jianli, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jianli:{}",this.getClass().getName(),jianli.toString());
        JianliEntity oldJianliEntity = jianliService.selectById(jianli.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jianli.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jianli.getJianliFile()) || "null".equals(jianli.getJianliFile())){
                jianli.setJianliFile(null);
        }
        if("".equals(jianli.getJianliPhoto()) || "null".equals(jianli.getJianliPhoto())){
                jianli.setJianliPhoto(null);
        }

            jianliService.updateById(jianli);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JianliEntity> oldJianliList =jianliService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jianliService.deleteBatchIds(Arrays.asList(ids));

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
            List<JianliEntity> jianliList = new ArrayList<>();//上传的东西
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
                            JianliEntity jianliEntity = new JianliEntity();
//                            jianliEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jianliEntity.setJianliUuidNumber(data.get(0));                    //简历唯一编号 要改的
//                            jianliEntity.setJianliName(data.get(0));                    //简历标题 要改的
//                            jianliEntity.setJianliXingming(data.get(0));                    //姓名 要改的
//                            jianliEntity.setJianliTypes(Integer.valueOf(data.get(0)));   //求职意向 要改的
//                            jianliEntity.setJianliXinzi(data.get(0));                    //期望工资 要改的
//                            jianliEntity.setJianliXueli(data.get(0));                    //学历 要改的
//                            jianliEntity.setJianliJingli(data.get(0));                    //工作经历 要改的
//                            jianliEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            jianliEntity.setJianliFile(data.get(0));                    //简历文件 要改的
//                            jianliEntity.setJianliPhone(data.get(0));                    //手机号 要改的
//                            jianliEntity.setJianliPhoto("");//详情和图片
//                            jianliEntity.setJianliAddress(data.get(0));                    //现在位置 要改的
//                            jianliEntity.setJiaoyuText(data.get(0));                    //教育经历 要改的
//                            jianliEntity.setShixiText(data.get(0));                    //实习或工作经历 要改的
//                            jianliEntity.setGerenText(data.get(0));                    //个人介绍 要改的
//                            jianliEntity.setCreateTime(date);//时间
                            jianliList.add(jianliEntity);


                            //把要查询是否重复的字段放入map中
                                //简历唯一编号
                                if(seachFields.containsKey("jianliUuidNumber")){
                                    List<String> jianliUuidNumber = seachFields.get("jianliUuidNumber");
                                    jianliUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jianliUuidNumber = new ArrayList<>();
                                    jianliUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jianliUuidNumber",jianliUuidNumber);
                                }
                                //手机号
                                if(seachFields.containsKey("jianliPhone")){
                                    List<String> jianliPhone = seachFields.get("jianliPhone");
                                    jianliPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jianliPhone = new ArrayList<>();
                                    jianliPhone.add(data.get(0));//要改的
                                    seachFields.put("jianliPhone",jianliPhone);
                                }
                        }

                        //查询是否重复
                         //简历唯一编号
                        List<JianliEntity> jianliEntities_jianliUuidNumber = jianliService.selectList(new EntityWrapper<JianliEntity>().in("jianli_uuid_number", seachFields.get("jianliUuidNumber")));
                        if(jianliEntities_jianliUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JianliEntity s:jianliEntities_jianliUuidNumber){
                                repeatFields.add(s.getJianliUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [简历唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //手机号
                        List<JianliEntity> jianliEntities_jianliPhone = jianliService.selectList(new EntityWrapper<JianliEntity>().in("jianli_phone", seachFields.get("jianliPhone")));
                        if(jianliEntities_jianliPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JianliEntity s:jianliEntities_jianliPhone){
                                repeatFields.add(s.getJianliPhone());
                            }
                            return R.error(511,"数据库的该表中的 [手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jianliService.insertBatch(jianliList);
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
        PageUtils page = jianliService.queryPage(params);

        //字典表数据转换
        List<JianliView> list =(List<JianliView>)page.getList();
        for(JianliView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JianliEntity jianli = jianliService.selectById(id);
            if(jianli !=null){


                //entity转view
                JianliView view = new JianliView();
                BeanUtils.copyProperties( jianli , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jianli.getYonghuId());
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
    public R add(@RequestBody JianliEntity jianli, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jianli:{}",this.getClass().getName(),jianli.toString());
        Wrapper<JianliEntity> queryWrapper = new EntityWrapper<JianliEntity>()
            .eq("yonghu_id", jianli.getYonghuId())
            .eq("jianli_uuid_number", jianli.getJianliUuidNumber())
            .eq("jianli_name", jianli.getJianliName())
            .eq("jianli_xingming", jianli.getJianliXingming())
            .eq("jianli_types", jianli.getJianliTypes())
            .eq("jianli_xinzi", jianli.getJianliXinzi())
            .eq("jianli_xueli", jianli.getJianliXueli())
            .eq("jianli_jingli", jianli.getJianliJingli())
            .eq("sex_types", jianli.getSexTypes())
            .eq("jianli_phone", jianli.getJianliPhone())
            .eq("jianli_address", jianli.getJianliAddress())
            .eq("jiaoyu_text", jianli.getJiaoyuText())
            .eq("shixi_text", jianli.getShixiText())
            .eq("geren_text", jianli.getGerenText())
//            .notIn("jianli_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianliEntity jianliEntity = jianliService.selectOne(queryWrapper);
        if(jianliEntity==null){
            jianli.setCreateTime(new Date());
        jianliService.insert(jianli);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

