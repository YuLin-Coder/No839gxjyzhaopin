package com.entity.vo;

import com.entity.FudaoyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 辅导员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fudaoyuan")
public class FudaoyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 辅导员姓名
     */

    @TableField(value = "fudaoyuan_name")
    private String fudaoyuanName;


    /**
     * 照片
     */

    @TableField(value = "fudaoyuan_photo")
    private String fudaoyuanPhoto;


    /**
     * 辅导员手机号
     */

    @TableField(value = "fudaoyuan_phone")
    private String fudaoyuanPhone;


    /**
     * 辅导员身份证号
     */

    @TableField(value = "fudaoyuan_id_number")
    private String fudaoyuanIdNumber;


    /**
     * 邮箱
     */

    @TableField(value = "fudaoyuan_email")
    private String fudaoyuanEmail;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 假删
     */

    @TableField(value = "fudaoyuan_delete")
    private Integer fudaoyuanDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：辅导员姓名
	 */
    public String getFudaoyuanName() {
        return fudaoyuanName;
    }


    /**
	 * 获取：辅导员姓名
	 */

    public void setFudaoyuanName(String fudaoyuanName) {
        this.fudaoyuanName = fudaoyuanName;
    }
    /**
	 * 设置：照片
	 */
    public String getFudaoyuanPhoto() {
        return fudaoyuanPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setFudaoyuanPhoto(String fudaoyuanPhoto) {
        this.fudaoyuanPhoto = fudaoyuanPhoto;
    }
    /**
	 * 设置：辅导员手机号
	 */
    public String getFudaoyuanPhone() {
        return fudaoyuanPhone;
    }


    /**
	 * 获取：辅导员手机号
	 */

    public void setFudaoyuanPhone(String fudaoyuanPhone) {
        this.fudaoyuanPhone = fudaoyuanPhone;
    }
    /**
	 * 设置：辅导员身份证号
	 */
    public String getFudaoyuanIdNumber() {
        return fudaoyuanIdNumber;
    }


    /**
	 * 获取：辅导员身份证号
	 */

    public void setFudaoyuanIdNumber(String fudaoyuanIdNumber) {
        this.fudaoyuanIdNumber = fudaoyuanIdNumber;
    }
    /**
	 * 设置：邮箱
	 */
    public String getFudaoyuanEmail() {
        return fudaoyuanEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setFudaoyuanEmail(String fudaoyuanEmail) {
        this.fudaoyuanEmail = fudaoyuanEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：假删
	 */
    public Integer getFudaoyuanDelete() {
        return fudaoyuanDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setFudaoyuanDelete(Integer fudaoyuanDelete) {
        this.fudaoyuanDelete = fudaoyuanDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
