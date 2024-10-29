package com.entity.model;

import com.entity.BiyequxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 毕业去向
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BiyequxiangModel implements Serializable {
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
     * 毕业去向编号
     */
    private String biyequxiangUuidNumber;


    /**
     * 毕业去向类型
     */
    private Integer biyequxiangTypes;


    /**
     * 附件
     */
    private String biyequxiangFile;


    /**
     * 公司名称
     */
    private String gongsiName;


    /**
     * 公司位置
     */
    private String gongsiAddress;


    /**
     * 薪资
     */
    private Integer biyequxiangXinzi;


    /**
     * 去往时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date biyequxiangTime;


    /**
     * 详细信息
     */
    private String biyequxiangContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
