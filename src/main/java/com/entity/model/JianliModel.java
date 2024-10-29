package com.entity.model;

import com.entity.JianliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 简历
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 简历唯一编号
     */
    private String jianliUuidNumber;


    /**
     * 简历标题
     */
    private String jianliName;


    /**
     * 姓名
     */
    private String jianliXingming;


    /**
     * 求职意向
     */
    private Integer jianliTypes;


    /**
     * 期望工资
     */
    private String jianliXinzi;


    /**
     * 学历
     */
    private String jianliXueli;


    /**
     * 工作经历
     */
    private String jianliJingli;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 简历文件
     */
    private String jianliFile;


    /**
     * 手机号
     */
    private String jianliPhone;


    /**
     * 照片
     */
    private String jianliPhoto;


    /**
     * 现在位置
     */
    private String jianliAddress;


    /**
     * 教育经历
     */
    private String jiaoyuText;


    /**
     * 实习或工作经历
     */
    private String shixiText;


    /**
     * 个人介绍
     */
    private String gerenText;


    /**
     * 创建时间  show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：简历唯一编号
	 */
    public String getJianliUuidNumber() {
        return jianliUuidNumber;
    }


    /**
	 * 设置：简历唯一编号
	 */
    public void setJianliUuidNumber(String jianliUuidNumber) {
        this.jianliUuidNumber = jianliUuidNumber;
    }
    /**
	 * 获取：简历标题
	 */
    public String getJianliName() {
        return jianliName;
    }


    /**
	 * 设置：简历标题
	 */
    public void setJianliName(String jianliName) {
        this.jianliName = jianliName;
    }
    /**
	 * 获取：姓名
	 */
    public String getJianliXingming() {
        return jianliXingming;
    }


    /**
	 * 设置：姓名
	 */
    public void setJianliXingming(String jianliXingming) {
        this.jianliXingming = jianliXingming;
    }
    /**
	 * 获取：求职意向
	 */
    public Integer getJianliTypes() {
        return jianliTypes;
    }


    /**
	 * 设置：求职意向
	 */
    public void setJianliTypes(Integer jianliTypes) {
        this.jianliTypes = jianliTypes;
    }
    /**
	 * 获取：期望工资
	 */
    public String getJianliXinzi() {
        return jianliXinzi;
    }


    /**
	 * 设置：期望工资
	 */
    public void setJianliXinzi(String jianliXinzi) {
        this.jianliXinzi = jianliXinzi;
    }
    /**
	 * 获取：学历
	 */
    public String getJianliXueli() {
        return jianliXueli;
    }


    /**
	 * 设置：学历
	 */
    public void setJianliXueli(String jianliXueli) {
        this.jianliXueli = jianliXueli;
    }
    /**
	 * 获取：工作经历
	 */
    public String getJianliJingli() {
        return jianliJingli;
    }


    /**
	 * 设置：工作经历
	 */
    public void setJianliJingli(String jianliJingli) {
        this.jianliJingli = jianliJingli;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：简历文件
	 */
    public String getJianliFile() {
        return jianliFile;
    }


    /**
	 * 设置：简历文件
	 */
    public void setJianliFile(String jianliFile) {
        this.jianliFile = jianliFile;
    }
    /**
	 * 获取：手机号
	 */
    public String getJianliPhone() {
        return jianliPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setJianliPhone(String jianliPhone) {
        this.jianliPhone = jianliPhone;
    }
    /**
	 * 获取：照片
	 */
    public String getJianliPhoto() {
        return jianliPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setJianliPhoto(String jianliPhoto) {
        this.jianliPhoto = jianliPhoto;
    }
    /**
	 * 获取：现在位置
	 */
    public String getJianliAddress() {
        return jianliAddress;
    }


    /**
	 * 设置：现在位置
	 */
    public void setJianliAddress(String jianliAddress) {
        this.jianliAddress = jianliAddress;
    }
    /**
	 * 获取：教育经历
	 */
    public String getJiaoyuText() {
        return jiaoyuText;
    }


    /**
	 * 设置：教育经历
	 */
    public void setJiaoyuText(String jiaoyuText) {
        this.jiaoyuText = jiaoyuText;
    }
    /**
	 * 获取：实习或工作经历
	 */
    public String getShixiText() {
        return shixiText;
    }


    /**
	 * 设置：实习或工作经历
	 */
    public void setShixiText(String shixiText) {
        this.shixiText = shixiText;
    }
    /**
	 * 获取：个人介绍
	 */
    public String getGerenText() {
        return gerenText;
    }


    /**
	 * 设置：个人介绍
	 */
    public void setGerenText(String gerenText) {
        this.gerenText = gerenText;
    }
    /**
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
