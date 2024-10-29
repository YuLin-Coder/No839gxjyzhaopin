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
 * 企业
 *
 * @author 
 * @email
 */
@TableName("qiye")
public class QiyeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiyeEntity() {

	}

	public QiyeEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 企业名称
     */
    @ColumnInfo(comment="企业名称",type="varchar(200)")
    @TableField(value = "qiye_name")

    private String qiyeName;


    /**
     * 企业类型
     */
    @ColumnInfo(comment="企业类型",type="int(11)")
    @TableField(value = "qiye_types")

    private Integer qiyeTypes;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "qiye_phone")

    private String qiyePhone;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "qiye_email")

    private String qiyeEmail;


    /**
     * 企业logo
     */
    @ColumnInfo(comment="企业logo",type="varchar(200)")
    @TableField(value = "qiye_photo")

    private String qiyePhoto;


    /**
     * 企业成立时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="企业成立时间",type="timestamp")
    @TableField(value = "qiye_chenglishijian_time")

    private Date qiyeChenglishijianTime;


    /**
     * 企业介绍
     */
    @ColumnInfo(comment="企业介绍",type="text")
    @TableField(value = "qiye_content")

    private String qiyeContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "qiye_delete")

    private Integer qiyeDelete;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：企业名称
	 */
    public String getQiyeName() {
        return qiyeName;
    }
    /**
	 * 设置：企业名称
	 */

    public void setQiyeName(String qiyeName) {
        this.qiyeName = qiyeName;
    }
    /**
	 * 获取：企业类型
	 */
    public Integer getQiyeTypes() {
        return qiyeTypes;
    }
    /**
	 * 设置：企业类型
	 */

    public void setQiyeTypes(Integer qiyeTypes) {
        this.qiyeTypes = qiyeTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getQiyePhone() {
        return qiyePhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setQiyePhone(String qiyePhone) {
        this.qiyePhone = qiyePhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getQiyeEmail() {
        return qiyeEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setQiyeEmail(String qiyeEmail) {
        this.qiyeEmail = qiyeEmail;
    }
    /**
	 * 获取：企业logo
	 */
    public String getQiyePhoto() {
        return qiyePhoto;
    }
    /**
	 * 设置：企业logo
	 */

    public void setQiyePhoto(String qiyePhoto) {
        this.qiyePhoto = qiyePhoto;
    }
    /**
	 * 获取：企业成立时间
	 */
    public Date getQiyeChenglishijianTime() {
        return qiyeChenglishijianTime;
    }
    /**
	 * 设置：企业成立时间
	 */

    public void setQiyeChenglishijianTime(Date qiyeChenglishijianTime) {
        this.qiyeChenglishijianTime = qiyeChenglishijianTime;
    }
    /**
	 * 获取：企业介绍
	 */
    public String getQiyeContent() {
        return qiyeContent;
    }
    /**
	 * 设置：企业介绍
	 */

    public void setQiyeContent(String qiyeContent) {
        this.qiyeContent = qiyeContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getQiyeDelete() {
        return qiyeDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setQiyeDelete(Integer qiyeDelete) {
        this.qiyeDelete = qiyeDelete;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Qiye{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", qiyeName=" + qiyeName +
            ", qiyeTypes=" + qiyeTypes +
            ", qiyePhone=" + qiyePhone +
            ", qiyeEmail=" + qiyeEmail +
            ", qiyePhoto=" + qiyePhoto +
            ", qiyeChenglishijianTime=" + DateUtil.convertString(qiyeChenglishijianTime,"yyyy-MM-dd") +
            ", qiyeContent=" + qiyeContent +
            ", qiyeDelete=" + qiyeDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
