package com.entity.model;

import com.entity.FudaoyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 辅导员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FudaoyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 辅导员姓名
     */
    private String fudaoyuanName;


    /**
     * 照片
     */
    private String fudaoyuanPhoto;


    /**
     * 辅导员手机号
     */
    private String fudaoyuanPhone;


    /**
     * 辅导员身份证号
     */
    private String fudaoyuanIdNumber;


    /**
     * 邮箱
     */
    private String fudaoyuanEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 假删
     */
    private Integer fudaoyuanDelete;


    /**
     * 创建时间
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

    }
