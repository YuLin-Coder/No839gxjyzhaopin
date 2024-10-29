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
 * 辅导员
 *
 * @author 
 * @email
 */
@TableName("fudaoyuan")
public class FudaoyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FudaoyuanEntity() {

	}

	public FudaoyuanEntity(T t) {
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
     * 辅导员姓名
     */
    @ColumnInfo(comment="辅导员姓名",type="varchar(200)")
    @TableField(value = "fudaoyuan_name")

    private String fudaoyuanName;


    /**
     * 照片
     */
    @ColumnInfo(comment="照片",type="varchar(255)")
    @TableField(value = "fudaoyuan_photo")

    private String fudaoyuanPhoto;


    /**
     * 辅导员手机号
     */
    @ColumnInfo(comment="辅导员手机号",type="varchar(200)")
    @TableField(value = "fudaoyuan_phone")

    private String fudaoyuanPhone;


    /**
     * 辅导员身份证号
     */
    @ColumnInfo(comment="辅导员身份证号",type="varchar(200)")
    @TableField(value = "fudaoyuan_id_number")

    private String fudaoyuanIdNumber;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "fudaoyuan_email")

    private String fudaoyuanEmail;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 假删
     */
    @ColumnInfo(comment="假删",type="int(11)")
    @TableField(value = "fudaoyuan_delete")

    private Integer fudaoyuanDelete;


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
	 * 获取：辅导员姓名
	 */
    public String getFudaoyuanName() {
        return fudaoyuanName;
    }
    /**
	 * 设置：辅导员姓名
	 */

    public void setFudaoyuanName(String fudaoyuanName) {
        this.fudaoyuanName = fudaoyuanName;
    }
    /**
	 * 获取：照片
	 */
    public String getFudaoyuanPhoto() {
        return fudaoyuanPhoto;
    }
    /**
	 * 设置：照片
	 */

    public void setFudaoyuanPhoto(String fudaoyuanPhoto) {
        this.fudaoyuanPhoto = fudaoyuanPhoto;
    }
    /**
	 * 获取：辅导员手机号
	 */
    public String getFudaoyuanPhone() {
        return fudaoyuanPhone;
    }
    /**
	 * 设置：辅导员手机号
	 */

    public void setFudaoyuanPhone(String fudaoyuanPhone) {
        this.fudaoyuanPhone = fudaoyuanPhone;
    }
    /**
	 * 获取：辅导员身份证号
	 */
    public String getFudaoyuanIdNumber() {
        return fudaoyuanIdNumber;
    }
    /**
	 * 设置：辅导员身份证号
	 */

    public void setFudaoyuanIdNumber(String fudaoyuanIdNumber) {
        this.fudaoyuanIdNumber = fudaoyuanIdNumber;
    }
    /**
	 * 获取：邮箱
	 */
    public String getFudaoyuanEmail() {
        return fudaoyuanEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setFudaoyuanEmail(String fudaoyuanEmail) {
        this.fudaoyuanEmail = fudaoyuanEmail;
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
	 * 获取：假删
	 */
    public Integer getFudaoyuanDelete() {
        return fudaoyuanDelete;
    }
    /**
	 * 设置：假删
	 */

    public void setFudaoyuanDelete(Integer fudaoyuanDelete) {
        this.fudaoyuanDelete = fudaoyuanDelete;
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
        return "Fudaoyuan{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", fudaoyuanName=" + fudaoyuanName +
            ", fudaoyuanPhoto=" + fudaoyuanPhoto +
            ", fudaoyuanPhone=" + fudaoyuanPhone +
            ", fudaoyuanIdNumber=" + fudaoyuanIdNumber +
            ", fudaoyuanEmail=" + fudaoyuanEmail +
            ", sexTypes=" + sexTypes +
            ", fudaoyuanDelete=" + fudaoyuanDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
