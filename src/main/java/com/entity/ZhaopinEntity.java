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
 * 职位招聘
 *
 * @author 
 * @email
 */
@TableName("zhaopin")
public class ZhaopinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhaopinEntity() {

	}

	public ZhaopinEntity(T t) {
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
     * 企业
     */
    @ColumnInfo(comment="企业",type="int(11)")
    @TableField(value = "qiye_id")

    private Integer qiyeId;


    /**
     * 招聘信息名称
     */
    @ColumnInfo(comment="招聘信息名称",type="varchar(200)")
    @TableField(value = "zhaopin_name")

    private String zhaopinName;


    /**
     * 招聘信息照片
     */
    @ColumnInfo(comment="招聘信息照片",type="varchar(200)")
    @TableField(value = "zhaopin_photo")

    private String zhaopinPhoto;


    /**
     * 薪资待遇
     */
    @ColumnInfo(comment="薪资待遇",type="varchar(200)")
    @TableField(value = "zhaopin_daiyu")

    private String zhaopinDaiyu;


    /**
     * 上班地点
     */
    @ColumnInfo(comment="上班地点",type="varchar(200)")
    @TableField(value = "zhaopin_address")

    private String zhaopinAddress;


    /**
     * 联系人
     */
    @ColumnInfo(comment="联系人",type="varchar(200)")
    @TableField(value = "lianxiren_name")

    private String lianxirenName;


    /**
     * 招聘电话
     */
    @ColumnInfo(comment="招聘电话",type="varchar(200)")
    @TableField(value = "zhaopin_phone")

    private String zhaopinPhone;


    /**
     * 招聘岗位
     */
    @ColumnInfo(comment="招聘岗位",type="int(11)")
    @TableField(value = "zhaopin_types")

    private Integer zhaopinTypes;


    /**
     * 招聘类型
     */
    @ColumnInfo(comment="招聘类型",type="int(11)")
    @TableField(value = "leixing_types")

    private Integer leixingTypes;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 招聘人数
     */
    @ColumnInfo(comment="招聘人数",type="int(11)")
    @TableField(value = "zhaopin_renshu_number")

    private Integer zhaopinRenshuNumber;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 招聘信息详情
     */
    @ColumnInfo(comment="招聘信息详情",type="text")
    @TableField(value = "zhaopin_content")

    private String zhaopinContent;


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
	 * 获取：企业
	 */
    public Integer getQiyeId() {
        return qiyeId;
    }
    /**
	 * 设置：企业
	 */

    public void setQiyeId(Integer qiyeId) {
        this.qiyeId = qiyeId;
    }
    /**
	 * 获取：招聘信息名称
	 */
    public String getZhaopinName() {
        return zhaopinName;
    }
    /**
	 * 设置：招聘信息名称
	 */

    public void setZhaopinName(String zhaopinName) {
        this.zhaopinName = zhaopinName;
    }
    /**
	 * 获取：招聘信息照片
	 */
    public String getZhaopinPhoto() {
        return zhaopinPhoto;
    }
    /**
	 * 设置：招聘信息照片
	 */

    public void setZhaopinPhoto(String zhaopinPhoto) {
        this.zhaopinPhoto = zhaopinPhoto;
    }
    /**
	 * 获取：薪资待遇
	 */
    public String getZhaopinDaiyu() {
        return zhaopinDaiyu;
    }
    /**
	 * 设置：薪资待遇
	 */

    public void setZhaopinDaiyu(String zhaopinDaiyu) {
        this.zhaopinDaiyu = zhaopinDaiyu;
    }
    /**
	 * 获取：上班地点
	 */
    public String getZhaopinAddress() {
        return zhaopinAddress;
    }
    /**
	 * 设置：上班地点
	 */

    public void setZhaopinAddress(String zhaopinAddress) {
        this.zhaopinAddress = zhaopinAddress;
    }
    /**
	 * 获取：联系人
	 */
    public String getLianxirenName() {
        return lianxirenName;
    }
    /**
	 * 设置：联系人
	 */

    public void setLianxirenName(String lianxirenName) {
        this.lianxirenName = lianxirenName;
    }
    /**
	 * 获取：招聘电话
	 */
    public String getZhaopinPhone() {
        return zhaopinPhone;
    }
    /**
	 * 设置：招聘电话
	 */

    public void setZhaopinPhone(String zhaopinPhone) {
        this.zhaopinPhone = zhaopinPhone;
    }
    /**
	 * 获取：招聘岗位
	 */
    public Integer getZhaopinTypes() {
        return zhaopinTypes;
    }
    /**
	 * 设置：招聘岗位
	 */

    public void setZhaopinTypes(Integer zhaopinTypes) {
        this.zhaopinTypes = zhaopinTypes;
    }
    /**
	 * 获取：招聘类型
	 */
    public Integer getLeixingTypes() {
        return leixingTypes;
    }
    /**
	 * 设置：招聘类型
	 */

    public void setLeixingTypes(Integer leixingTypes) {
        this.leixingTypes = leixingTypes;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：招聘人数
	 */
    public Integer getZhaopinRenshuNumber() {
        return zhaopinRenshuNumber;
    }
    /**
	 * 设置：招聘人数
	 */

    public void setZhaopinRenshuNumber(Integer zhaopinRenshuNumber) {
        this.zhaopinRenshuNumber = zhaopinRenshuNumber;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：招聘信息详情
	 */
    public String getZhaopinContent() {
        return zhaopinContent;
    }
    /**
	 * 设置：招聘信息详情
	 */

    public void setZhaopinContent(String zhaopinContent) {
        this.zhaopinContent = zhaopinContent;
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
        return "Zhaopin{" +
            ", id=" + id +
            ", qiyeId=" + qiyeId +
            ", zhaopinName=" + zhaopinName +
            ", zhaopinPhoto=" + zhaopinPhoto +
            ", zhaopinDaiyu=" + zhaopinDaiyu +
            ", zhaopinAddress=" + zhaopinAddress +
            ", lianxirenName=" + lianxirenName +
            ", zhaopinPhone=" + zhaopinPhone +
            ", zhaopinTypes=" + zhaopinTypes +
            ", leixingTypes=" + leixingTypes +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", zhaopinRenshuNumber=" + zhaopinRenshuNumber +
            ", shangxiaTypes=" + shangxiaTypes +
            ", zhaopinContent=" + zhaopinContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
