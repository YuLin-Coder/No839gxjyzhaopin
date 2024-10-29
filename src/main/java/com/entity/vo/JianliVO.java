package com.entity.vo;

import com.entity.JianliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 简历
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianli")
public class JianliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 简历唯一编号
     */

    @TableField(value = "jianli_uuid_number")
    private String jianliUuidNumber;


    /**
     * 简历标题
     */

    @TableField(value = "jianli_name")
    private String jianliName;


    /**
     * 姓名
     */

    @TableField(value = "jianli_xingming")
    private String jianliXingming;


    /**
     * 求职意向
     */

    @TableField(value = "jianli_types")
    private Integer jianliTypes;


    /**
     * 期望工资
     */

    @TableField(value = "jianli_xinzi")
    private String jianliXinzi;


    /**
     * 学历
     */

    @TableField(value = "jianli_xueli")
    private String jianliXueli;


    /**
     * 工作经历
     */

    @TableField(value = "jianli_jingli")
    private String jianliJingli;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 简历文件
     */

    @TableField(value = "jianli_file")
    private String jianliFile;


    /**
     * 手机号
     */

    @TableField(value = "jianli_phone")
    private String jianliPhone;


    /**
     * 照片
     */

    @TableField(value = "jianli_photo")
    private String jianliPhoto;


    /**
     * 现在位置
     */

    @TableField(value = "jianli_address")
    private String jianliAddress;


    /**
     * 教育经历
     */

    @TableField(value = "jiaoyu_text")
    private String jiaoyuText;


    /**
     * 实习或工作经历
     */

    @TableField(value = "shixi_text")
    private String shixiText;


    /**
     * 个人介绍
     */

    @TableField(value = "geren_text")
    private String gerenText;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：简历唯一编号
	 */
    public String getJianliUuidNumber() {
        return jianliUuidNumber;
    }


    /**
	 * 获取：简历唯一编号
	 */

    public void setJianliUuidNumber(String jianliUuidNumber) {
        this.jianliUuidNumber = jianliUuidNumber;
    }
    /**
	 * 设置：简历标题
	 */
    public String getJianliName() {
        return jianliName;
    }


    /**
	 * 获取：简历标题
	 */

    public void setJianliName(String jianliName) {
        this.jianliName = jianliName;
    }
    /**
	 * 设置：姓名
	 */
    public String getJianliXingming() {
        return jianliXingming;
    }


    /**
	 * 获取：姓名
	 */

    public void setJianliXingming(String jianliXingming) {
        this.jianliXingming = jianliXingming;
    }
    /**
	 * 设置：求职意向
	 */
    public Integer getJianliTypes() {
        return jianliTypes;
    }


    /**
	 * 获取：求职意向
	 */

    public void setJianliTypes(Integer jianliTypes) {
        this.jianliTypes = jianliTypes;
    }
    /**
	 * 设置：期望工资
	 */
    public String getJianliXinzi() {
        return jianliXinzi;
    }


    /**
	 * 获取：期望工资
	 */

    public void setJianliXinzi(String jianliXinzi) {
        this.jianliXinzi = jianliXinzi;
    }
    /**
	 * 设置：学历
	 */
    public String getJianliXueli() {
        return jianliXueli;
    }


    /**
	 * 获取：学历
	 */

    public void setJianliXueli(String jianliXueli) {
        this.jianliXueli = jianliXueli;
    }
    /**
	 * 设置：工作经历
	 */
    public String getJianliJingli() {
        return jianliJingli;
    }


    /**
	 * 获取：工作经历
	 */

    public void setJianliJingli(String jianliJingli) {
        this.jianliJingli = jianliJingli;
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
	 * 设置：简历文件
	 */
    public String getJianliFile() {
        return jianliFile;
    }


    /**
	 * 获取：简历文件
	 */

    public void setJianliFile(String jianliFile) {
        this.jianliFile = jianliFile;
    }
    /**
	 * 设置：手机号
	 */
    public String getJianliPhone() {
        return jianliPhone;
    }


    /**
	 * 获取：手机号
	 */

    public void setJianliPhone(String jianliPhone) {
        this.jianliPhone = jianliPhone;
    }
    /**
	 * 设置：照片
	 */
    public String getJianliPhoto() {
        return jianliPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setJianliPhoto(String jianliPhoto) {
        this.jianliPhoto = jianliPhoto;
    }
    /**
	 * 设置：现在位置
	 */
    public String getJianliAddress() {
        return jianliAddress;
    }


    /**
	 * 获取：现在位置
	 */

    public void setJianliAddress(String jianliAddress) {
        this.jianliAddress = jianliAddress;
    }
    /**
	 * 设置：教育经历
	 */
    public String getJiaoyuText() {
        return jiaoyuText;
    }


    /**
	 * 获取：教育经历
	 */

    public void setJiaoyuText(String jiaoyuText) {
        this.jiaoyuText = jiaoyuText;
    }
    /**
	 * 设置：实习或工作经历
	 */
    public String getShixiText() {
        return shixiText;
    }


    /**
	 * 获取：实习或工作经历
	 */

    public void setShixiText(String shixiText) {
        this.shixiText = shixiText;
    }
    /**
	 * 设置：个人介绍
	 */
    public String getGerenText() {
        return gerenText;
    }


    /**
	 * 获取：个人介绍
	 */

    public void setGerenText(String gerenText) {
        this.gerenText = gerenText;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
