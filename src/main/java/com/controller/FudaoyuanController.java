
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
 * 辅导员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fudaoyuan")
public class FudaoyuanController {
    private static final Logger logger = LoggerFactory.getLogger(FudaoyuanController.class);

    private static final String TABLE_NAME = "fudaoyuan";

    @Autowired
    private FudaoyuanService fudaoyuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BiyequxiangService biyequxiangService;//毕业去向
    @Autowired
    private ChatService chatService;//就业咨询
    @Autowired
    private DictionaryService dictionaryService;//字典表
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
        params.put("fudaoyuanDeleteStart",1);params.put("fudaoyuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = fudaoyuanService.queryPage(params);

        //字典表数据转换
        List<FudaoyuanView> list =(List<FudaoyuanView>)page.getList();
        for(FudaoyuanView c:list){
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
        FudaoyuanEntity fudaoyuan = fudaoyuanService.selectById(id);
        if(fudaoyuan !=null){
            //entity转view
            FudaoyuanView view = new FudaoyuanView();
            BeanUtils.copyProperties( fudaoyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody FudaoyuanEntity fudaoyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fudaoyuan:{}",this.getClass().getName(),fudaoyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<FudaoyuanEntity> queryWrapper = new EntityWrapper<FudaoyuanEntity>()
            .eq("username", fudaoyuan.getUsername())
            .or()
            .eq("fudaoyuan_phone", fudaoyuan.getFudaoyuanPhone())
            .or()
            .eq("fudaoyuan_id_number", fudaoyuan.getFudaoyuanIdNumber())
            .eq("fudaoyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FudaoyuanEntity fudaoyuanEntity = fudaoyuanService.selectOne(queryWrapper);
        if(fudaoyuanEntity==null){
            fudaoyuan.setFudaoyuanDelete(1);
            fudaoyuan.setCreateTime(new Date());
            fudaoyuan.setPassword("123456");
            fudaoyuanService.insert(fudaoyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者辅导员手机号或者辅导员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FudaoyuanEntity fudaoyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fudaoyuan:{}",this.getClass().getName(),fudaoyuan.toString());
        FudaoyuanEntity oldFudaoyuanEntity = fudaoyuanService.selectById(fudaoyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(fudaoyuan.getFudaoyuanPhoto()) || "null".equals(fudaoyuan.getFudaoyuanPhoto())){
                fudaoyuan.setFudaoyuanPhoto(null);
        }

            fudaoyuanService.updateById(fudaoyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FudaoyuanEntity> oldFudaoyuanList =fudaoyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<FudaoyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FudaoyuanEntity fudaoyuanEntity = new FudaoyuanEntity();
            fudaoyuanEntity.setId(id);
            fudaoyuanEntity.setFudaoyuanDelete(2);
            list.add(fudaoyuanEntity);
        }
        if(list != null && list.size() >0){
            fudaoyuanService.updateBatchById(list);
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
            List<FudaoyuanEntity> fudaoyuanList = new ArrayList<>();//上传的东西
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
                            FudaoyuanEntity fudaoyuanEntity = new FudaoyuanEntity();
//                            fudaoyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            fudaoyuanEntity.setPassword("123456");//密码
//                            fudaoyuanEntity.setFudaoyuanName(data.get(0));                    //辅导员姓名 要改的
//                            fudaoyuanEntity.setFudaoyuanPhoto("");//详情和图片
//                            fudaoyuanEntity.setFudaoyuanPhone(data.get(0));                    //辅导员手机号 要改的
//                            fudaoyuanEntity.setFudaoyuanIdNumber(data.get(0));                    //辅导员身份证号 要改的
//                            fudaoyuanEntity.setFudaoyuanEmail(data.get(0));                    //邮箱 要改的
//                            fudaoyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            fudaoyuanEntity.setFudaoyuanDelete(1);//逻辑删除字段
//                            fudaoyuanEntity.setCreateTime(date);//时间
                            fudaoyuanList.add(fudaoyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //辅导员手机号
                                if(seachFields.containsKey("fudaoyuanPhone")){
                                    List<String> fudaoyuanPhone = seachFields.get("fudaoyuanPhone");
                                    fudaoyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> fudaoyuanPhone = new ArrayList<>();
                                    fudaoyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("fudaoyuanPhone",fudaoyuanPhone);
                                }
                                //辅导员身份证号
                                if(seachFields.containsKey("fudaoyuanIdNumber")){
                                    List<String> fudaoyuanIdNumber = seachFields.get("fudaoyuanIdNumber");
                                    fudaoyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> fudaoyuanIdNumber = new ArrayList<>();
                                    fudaoyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("fudaoyuanIdNumber",fudaoyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<FudaoyuanEntity> fudaoyuanEntities_username = fudaoyuanService.selectList(new EntityWrapper<FudaoyuanEntity>().in("username", seachFields.get("username")).eq("fudaoyuan_delete", 1));
                        if(fudaoyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FudaoyuanEntity s:fudaoyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //辅导员手机号
                        List<FudaoyuanEntity> fudaoyuanEntities_fudaoyuanPhone = fudaoyuanService.selectList(new EntityWrapper<FudaoyuanEntity>().in("fudaoyuan_phone", seachFields.get("fudaoyuanPhone")).eq("fudaoyuan_delete", 1));
                        if(fudaoyuanEntities_fudaoyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FudaoyuanEntity s:fudaoyuanEntities_fudaoyuanPhone){
                                repeatFields.add(s.getFudaoyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [辅导员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //辅导员身份证号
                        List<FudaoyuanEntity> fudaoyuanEntities_fudaoyuanIdNumber = fudaoyuanService.selectList(new EntityWrapper<FudaoyuanEntity>().in("fudaoyuan_id_number", seachFields.get("fudaoyuanIdNumber")).eq("fudaoyuan_delete", 1));
                        if(fudaoyuanEntities_fudaoyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FudaoyuanEntity s:fudaoyuanEntities_fudaoyuanIdNumber){
                                repeatFields.add(s.getFudaoyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [辅导员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fudaoyuanService.insertBatch(fudaoyuanList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        FudaoyuanEntity fudaoyuan = fudaoyuanService.selectOne(new EntityWrapper<FudaoyuanEntity>().eq("username", username));
        if(fudaoyuan==null || !fudaoyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(fudaoyuan.getFudaoyuanDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(fudaoyuan.getId(),username, "fudaoyuan", "辅导员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","辅导员");
        r.put("username",fudaoyuan.getFudaoyuanName());
        r.put("tableName","fudaoyuan");
        r.put("userId",fudaoyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody FudaoyuanEntity fudaoyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<FudaoyuanEntity> queryWrapper = new EntityWrapper<FudaoyuanEntity>()
            .eq("username", fudaoyuan.getUsername())
            .or()
            .eq("fudaoyuan_phone", fudaoyuan.getFudaoyuanPhone())
            .or()
            .eq("fudaoyuan_id_number", fudaoyuan.getFudaoyuanIdNumber())
            .andNew()
            .eq("fudaoyuan_delete", 1)
            ;
        FudaoyuanEntity fudaoyuanEntity = fudaoyuanService.selectOne(queryWrapper);
        if(fudaoyuanEntity != null)
            return R.error("账户或者辅导员手机号或者辅导员身份证号已经被使用");
        fudaoyuan.setFudaoyuanDelete(1);
        fudaoyuan.setCreateTime(new Date());
        fudaoyuanService.insert(fudaoyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        FudaoyuanEntity fudaoyuan = fudaoyuanService.selectById(id);
        fudaoyuan.setPassword("123456");
        fudaoyuanService.updateById(fudaoyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        FudaoyuanEntity fudaoyuan = fudaoyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(fudaoyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(fudaoyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        fudaoyuan.setPassword(newPassword);
		fudaoyuanService.updateById(fudaoyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        FudaoyuanEntity fudaoyuan = fudaoyuanService.selectOne(new EntityWrapper<FudaoyuanEntity>().eq("username", username));
        if(fudaoyuan!=null){
            fudaoyuan.setPassword("123456");
            fudaoyuanService.updateById(fudaoyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrFudaoyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        FudaoyuanEntity fudaoyuan = fudaoyuanService.selectById(id);
        if(fudaoyuan !=null){
            //entity转view
            FudaoyuanView view = new FudaoyuanView();
            BeanUtils.copyProperties( fudaoyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = fudaoyuanService.queryPage(params);

        //字典表数据转换
        List<FudaoyuanView> list =(List<FudaoyuanView>)page.getList();
        for(FudaoyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FudaoyuanEntity fudaoyuan = fudaoyuanService.selectById(id);
            if(fudaoyuan !=null){


                //entity转view
                FudaoyuanView view = new FudaoyuanView();
                BeanUtils.copyProperties( fudaoyuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody FudaoyuanEntity fudaoyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fudaoyuan:{}",this.getClass().getName(),fudaoyuan.toString());
        Wrapper<FudaoyuanEntity> queryWrapper = new EntityWrapper<FudaoyuanEntity>()
            .eq("username", fudaoyuan.getUsername())
            .or()
            .eq("fudaoyuan_phone", fudaoyuan.getFudaoyuanPhone())
            .or()
            .eq("fudaoyuan_id_number", fudaoyuan.getFudaoyuanIdNumber())
            .andNew()
            .eq("fudaoyuan_delete", 1)
//            .notIn("fudaoyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FudaoyuanEntity fudaoyuanEntity = fudaoyuanService.selectOne(queryWrapper);
        if(fudaoyuanEntity==null){
            fudaoyuan.setFudaoyuanDelete(1);
            fudaoyuan.setCreateTime(new Date());
            fudaoyuan.setPassword("123456");
        fudaoyuanService.insert(fudaoyuan);

            return R.ok();
        }else {
            return R.error(511,"账户或者辅导员手机号或者辅导员身份证号已经被使用");
        }
    }

}

