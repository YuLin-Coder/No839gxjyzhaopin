package com.entity.model;

import com.entity.JiuyezhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 就业知识
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiuyezhishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 就业知识名称
     */
    private String jiuyezhishiName;


    /**
     * 就业知识编号
     */
    private String jiuyezhishiUuidNumber;


    /**
     * 就业知识照片
     */
    private String jiuyezhishiPhoto;


    /**
     * 附件
     */
    private String jiuyezhishiFile;


    /**
     * 就业知识视频
     */
    private String jiuyezhishiVideo;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 就业知识类型
     */
    private Integer jiuyezhishiTypes;


    /**
     * 就业知识热度
     */
    private Integer jiuyezhishiClicknum;


    /**
     * 就业知识介绍
     */
    private String jiuyezhishiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer jiuyezhishiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：就业知识名称
	 */
    public String getJiuyezhishiName() {
        return jiuyezhishiName;
    }


    /**
	 * 设置：就业知识名称
	 */
    public void setJiuyezhishiName(String jiuyezhishiName) {
        this.jiuyezhishiName = jiuyezhishiName;
    }
    /**
	 * 获取：就业知识编号
	 */
    public String getJiuyezhishiUuidNumber() {
        return jiuyezhishiUuidNumber;
    }


    /**
	 * 设置：就业知识编号
	 */
    public void setJiuyezhishiUuidNumber(String jiuyezhishiUuidNumber) {
        this.jiuyezhishiUuidNumber = jiuyezhishiUuidNumber;
    }
    /**
	 * 获取：就业知识照片
	 */
    public String getJiuyezhishiPhoto() {
        return jiuyezhishiPhoto;
    }


    /**
	 * 设置：就业知识照片
	 */
    public void setJiuyezhishiPhoto(String jiuyezhishiPhoto) {
        this.jiuyezhishiPhoto = jiuyezhishiPhoto;
    }
    /**
	 * 获取：附件
	 */
    public String getJiuyezhishiFile() {
        return jiuyezhishiFile;
    }


    /**
	 * 设置：附件
	 */
    public void setJiuyezhishiFile(String jiuyezhishiFile) {
        this.jiuyezhishiFile = jiuyezhishiFile;
    }
    /**
	 * 获取：就业知识视频
	 */
    public String getJiuyezhishiVideo() {
        return jiuyezhishiVideo;
    }


    /**
	 * 设置：就业知识视频
	 */
    public void setJiuyezhishiVideo(String jiuyezhishiVideo) {
        this.jiuyezhishiVideo = jiuyezhishiVideo;
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
	 * 获取：就业知识类型
	 */
    public Integer getJiuyezhishiTypes() {
        return jiuyezhishiTypes;
    }


    /**
	 * 设置：就业知识类型
	 */
    public void setJiuyezhishiTypes(Integer jiuyezhishiTypes) {
        this.jiuyezhishiTypes = jiuyezhishiTypes;
    }
    /**
	 * 获取：就业知识热度
	 */
    public Integer getJiuyezhishiClicknum() {
        return jiuyezhishiClicknum;
    }


    /**
	 * 设置：就业知识热度
	 */
    public void setJiuyezhishiClicknum(Integer jiuyezhishiClicknum) {
        this.jiuyezhishiClicknum = jiuyezhishiClicknum;
    }
    /**
	 * 获取：就业知识介绍
	 */
    public String getJiuyezhishiContent() {
        return jiuyezhishiContent;
    }


    /**
	 * 设置：就业知识介绍
	 */
    public void setJiuyezhishiContent(String jiuyezhishiContent) {
        this.jiuyezhishiContent = jiuyezhishiContent;
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
	 * 获取：逻辑删除
	 */
    public Integer getJiuyezhishiDelete() {
        return jiuyezhishiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJiuyezhishiDelete(Integer jiuyezhishiDelete) {
        this.jiuyezhishiDelete = jiuyezhishiDelete;
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
