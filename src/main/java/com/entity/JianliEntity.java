package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 简历
 *
 * @author 
 * @email
 */
@TableName("jianli")
public class JianliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianliEntity() {

	}

	public JianliEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 简历唯一编号
     */
    @ColumnInfo(comment="简历唯一编号",type="varchar(200)")
    @TableField(value = "jianli_uuid_number")

    private String jianliUuidNumber;


    /**
     * 简历标题
     */
    @ColumnInfo(comment="简历标题",type="varchar(200)")
    @TableField(value = "jianli_name")

    private String jianliName;


    /**
     * 姓名
     */
    @ColumnInfo(comment="姓名",type="varchar(200)")
    @TableField(value = "jianli_xingming")

    private String jianliXingming;


    /**
     * 求职意向
     */
    @ColumnInfo(comment="求职意向",type="int(11)")
    @TableField(value = "jianli_types")

    private Integer jianliTypes;


    /**
     * 期望工资
     */
    @ColumnInfo(comment="期望工资",type="varchar(200)")
    @TableField(value = "jianli_xinzi")

    private String jianliXinzi;


    /**
     * 学历
     */
    @ColumnInfo(comment="学历",type="varchar(200)")
    @TableField(value = "jianli_xueli")

    private String jianliXueli;


    /**
     * 工作经历
     */
    @ColumnInfo(comment="工作经历",type="varchar(200)")
    @TableField(value = "jianli_jingli")

    private String jianliJingli;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 简历文件
     */
    @ColumnInfo(comment="简历文件",type="varchar(200)")
    @TableField(value = "jianli_file")

    private String jianliFile;


    /**
     * 手机号
     */
    @ColumnInfo(comment="手机号",type="varchar(200)")
    @TableField(value = "jianli_phone")

    private String jianliPhone;


    /**
     * 照片
     */
    @ColumnInfo(comment="照片",type="varchar(200)")
    @TableField(value = "jianli_photo")

    private String jianliPhoto;


    /**
     * 现在位置
     */
    @ColumnInfo(comment="现在位置",type="varchar(200)")
    @TableField(value = "jianli_address")

    private String jianliAddress;


    /**
     * 教育经历
     */
    @ColumnInfo(comment="教育经历",type="text")
    @TableField(value = "jiaoyu_text")

    private String jiaoyuText;


    /**
     * 实习或工作经历
     */
    @ColumnInfo(comment="实习或工作经历",type="text")
    @TableField(value = "shixi_text")

    private String shixiText;


    /**
     * 个人介绍
     */
    @ColumnInfo(comment="个人介绍",type="text")
    @TableField(value = "geren_text")

    private String gerenText;


    /**
     * 创建时间   listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jianli{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", jianliUuidNumber=" + jianliUuidNumber +
            ", jianliName=" + jianliName +
            ", jianliXingming=" + jianliXingming +
            ", jianliTypes=" + jianliTypes +
            ", jianliXinzi=" + jianliXinzi +
            ", jianliXueli=" + jianliXueli +
            ", jianliJingli=" + jianliJingli +
            ", sexTypes=" + sexTypes +
            ", jianliFile=" + jianliFile +
            ", jianliPhone=" + jianliPhone +
            ", jianliPhoto=" + jianliPhoto +
            ", jianliAddress=" + jianliAddress +
            ", jiaoyuText=" + jiaoyuText +
            ", shixiText=" + shixiText +
            ", gerenText=" + gerenText +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
