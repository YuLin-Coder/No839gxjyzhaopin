package com.entity.vo;

import com.entity.BiyequxiangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 毕业去向
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("biyequxiang")
public class BiyequxiangVO implements Serializable {
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
     * 毕业去向编号
     */

    @TableField(value = "biyequxiang_uuid_number")
    private String biyequxiangUuidNumber;


    /**
     * 毕业去向类型
     */

    @TableField(value = "biyequxiang_types")
    private Integer biyequxiangTypes;


    /**
     * 附件
     */

    @TableField(value = "biyequxiang_file")
    private String biyequxiangFile;


    /**
     * 公司名称
     */

    @TableField(value = "gongsi_name")
    private String gongsiName;


    /**
     * 公司位置
     */

    @TableField(value = "gongsi_address")
    private String gongsiAddress;


    /**
     * 薪资
     */

    @TableField(value = "biyequxiang_xinzi")
    private Integer biyequxiangXinzi;


    /**
     * 去往时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "biyequxiang_time")
    private Date biyequxiangTime;


    /**
     * 详细信息
     */

    @TableField(value = "biyequxiang_content")
    private String biyequxiangContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：毕业去向编号
	 */
    public String getBiyequxiangUuidNumber() {
        return biyequxiangUuidNumber;
    }


    /**
	 * 获取：毕业去向编号
	 */

    public void setBiyequxiangUuidNumber(String biyequxiangUuidNumber) {
        this.biyequxiangUuidNumber = biyequxiangUuidNumber;
    }
    /**
	 * 设置：毕业去向类型
	 */
    public Integer getBiyequxiangTypes() {
        return biyequxiangTypes;
    }


    /**
	 * 获取：毕业去向类型
	 */

    public void setBiyequxiangTypes(Integer biyequxiangTypes) {
        this.biyequxiangTypes = biyequxiangTypes;
    }
    /**
	 * 设置：附件
	 */
    public String getBiyequxiangFile() {
        return biyequxiangFile;
    }


    /**
	 * 获取：附件
	 */

    public void setBiyequxiangFile(String biyequxiangFile) {
        this.biyequxiangFile = biyequxiangFile;
    }
    /**
	 * 设置：公司名称
	 */
    public String getGongsiName() {
        return gongsiName;
    }


    /**
	 * 获取：公司名称
	 */

    public void setGongsiName(String gongsiName) {
        this.gongsiName = gongsiName;
    }
    /**
	 * 设置：公司位置
	 */
    public String getGongsiAddress() {
        return gongsiAddress;
    }


    /**
	 * 获取：公司位置
	 */

    public void setGongsiAddress(String gongsiAddress) {
        this.gongsiAddress = gongsiAddress;
    }
    /**
	 * 设置：薪资
	 */
    public Integer getBiyequxiangXinzi() {
        return biyequxiangXinzi;
    }


    /**
	 * 获取：薪资
	 */

    public void setBiyequxiangXinzi(Integer biyequxiangXinzi) {
        this.biyequxiangXinzi = biyequxiangXinzi;
    }
    /**
	 * 设置：去往时间
	 */
    public Date getBiyequxiangTime() {
        return biyequxiangTime;
    }


    /**
	 * 获取：去往时间
	 */

    public void setBiyequxiangTime(Date biyequxiangTime) {
        this.biyequxiangTime = biyequxiangTime;
    }
    /**
	 * 设置：详细信息
	 */
    public String getBiyequxiangContent() {
        return biyequxiangContent;
    }


    /**
	 * 获取：详细信息
	 */

    public void setBiyequxiangContent(String biyequxiangContent) {
        this.biyequxiangContent = biyequxiangContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
