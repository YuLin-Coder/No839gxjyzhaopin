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
 * 毕业去向
 *
 * @author 
 * @email
 */
@TableName("biyequxiang")
public class BiyequxiangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BiyequxiangEntity() {

	}

	public BiyequxiangEntity(T t) {
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
     * 毕业去向编号
     */
    @ColumnInfo(comment="毕业去向编号",type="varchar(200)")
    @TableField(value = "biyequxiang_uuid_number")

    private String biyequxiangUuidNumber;


    /**
     * 毕业去向类型
     */
    @ColumnInfo(comment="毕业去向类型",type="int(11)")
    @TableField(value = "biyequxiang_types")

    private Integer biyequxiangTypes;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "biyequxiang_file")

    private String biyequxiangFile;


    /**
     * 公司名称
     */
    @ColumnInfo(comment="公司名称",type="varchar(200)")
    @TableField(value = "gongsi_name")

    private String gongsiName;


    /**
     * 公司位置
     */
    @ColumnInfo(comment="公司位置",type="varchar(200)")
    @TableField(value = "gongsi_address")

    private String gongsiAddress;


    /**
     * 薪资
     */
    @ColumnInfo(comment="薪资",type="int(11)")
    @TableField(value = "biyequxiang_xinzi")

    private Integer biyequxiangXinzi;


    /**
     * 去往时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="去往时间",type="timestamp")
    @TableField(value = "biyequxiang_time")

    private Date biyequxiangTime;


    /**
     * 详细信息
     */
    @ColumnInfo(comment="详细信息",type="longtext")
    @TableField(value = "biyequxiang_content")

    private String biyequxiangContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：毕业去向编号
	 */
    public String getBiyequxiangUuidNumber() {
        return biyequxiangUuidNumber;
    }
    /**
	 * 设置：毕业去向编号
	 */

    public void setBiyequxiangUuidNumber(String biyequxiangUuidNumber) {
        this.biyequxiangUuidNumber = biyequxiangUuidNumber;
    }
    /**
	 * 获取：毕业去向类型
	 */
    public Integer getBiyequxiangTypes() {
        return biyequxiangTypes;
    }
    /**
	 * 设置：毕业去向类型
	 */

    public void setBiyequxiangTypes(Integer biyequxiangTypes) {
        this.biyequxiangTypes = biyequxiangTypes;
    }
    /**
	 * 获取：附件
	 */
    public String getBiyequxiangFile() {
        return biyequxiangFile;
    }
    /**
	 * 设置：附件
	 */

    public void setBiyequxiangFile(String biyequxiangFile) {
        this.biyequxiangFile = biyequxiangFile;
    }
    /**
	 * 获取：公司名称
	 */
    public String getGongsiName() {
        return gongsiName;
    }
    /**
	 * 设置：公司名称
	 */

    public void setGongsiName(String gongsiName) {
        this.gongsiName = gongsiName;
    }
    /**
	 * 获取：公司位置
	 */
    public String getGongsiAddress() {
        return gongsiAddress;
    }
    /**
	 * 设置：公司位置
	 */

    public void setGongsiAddress(String gongsiAddress) {
        this.gongsiAddress = gongsiAddress;
    }
    /**
	 * 获取：薪资
	 */
    public Integer getBiyequxiangXinzi() {
        return biyequxiangXinzi;
    }
    /**
	 * 设置：薪资
	 */

    public void setBiyequxiangXinzi(Integer biyequxiangXinzi) {
        this.biyequxiangXinzi = biyequxiangXinzi;
    }
    /**
	 * 获取：去往时间
	 */
    public Date getBiyequxiangTime() {
        return biyequxiangTime;
    }
    /**
	 * 设置：去往时间
	 */

    public void setBiyequxiangTime(Date biyequxiangTime) {
        this.biyequxiangTime = biyequxiangTime;
    }
    /**
	 * 获取：详细信息
	 */
    public String getBiyequxiangContent() {
        return biyequxiangContent;
    }
    /**
	 * 设置：详细信息
	 */

    public void setBiyequxiangContent(String biyequxiangContent) {
        this.biyequxiangContent = biyequxiangContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Biyequxiang{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", biyequxiangUuidNumber=" + biyequxiangUuidNumber +
            ", biyequxiangTypes=" + biyequxiangTypes +
            ", biyequxiangFile=" + biyequxiangFile +
            ", gongsiName=" + gongsiName +
            ", gongsiAddress=" + gongsiAddress +
            ", biyequxiangXinzi=" + biyequxiangXinzi +
            ", biyequxiangTime=" + DateUtil.convertString(biyequxiangTime,"yyyy-MM-dd") +
            ", biyequxiangContent=" + biyequxiangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
