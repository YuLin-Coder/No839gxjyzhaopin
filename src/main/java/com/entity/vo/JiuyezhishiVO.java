package com.entity.vo;

import com.entity.JiuyezhishiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 就业知识
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiuyezhishi")
public class JiuyezhishiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 就业知识名称
     */

    @TableField(value = "jiuyezhishi_name")
    private String jiuyezhishiName;


    /**
     * 就业知识编号
     */

    @TableField(value = "jiuyezhishi_uuid_number")
    private String jiuyezhishiUuidNumber;


    /**
     * 就业知识照片
     */

    @TableField(value = "jiuyezhishi_photo")
    private String jiuyezhishiPhoto;


    /**
     * 附件
     */

    @TableField(value = "jiuyezhishi_file")
    private String jiuyezhishiFile;


    /**
     * 就业知识视频
     */

    @TableField(value = "jiuyezhishi_video")
    private String jiuyezhishiVideo;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 就业知识类型
     */

    @TableField(value = "jiuyezhishi_types")
    private Integer jiuyezhishiTypes;


    /**
     * 就业知识热度
     */

    @TableField(value = "jiuyezhishi_clicknum")
    private Integer jiuyezhishiClicknum;


    /**
     * 就业知识介绍
     */

    @TableField(value = "jiuyezhishi_content")
    private String jiuyezhishiContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiuyezhishi_delete")
    private Integer jiuyezhishiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：就业知识名称
	 */
    public String getJiuyezhishiName() {
        return jiuyezhishiName;
    }


    /**
	 * 获取：就业知识名称
	 */

    public void setJiuyezhishiName(String jiuyezhishiName) {
        this.jiuyezhishiName = jiuyezhishiName;
    }
    /**
	 * 设置：就业知识编号
	 */
    public String getJiuyezhishiUuidNumber() {
        return jiuyezhishiUuidNumber;
    }


    /**
	 * 获取：就业知识编号
	 */

    public void setJiuyezhishiUuidNumber(String jiuyezhishiUuidNumber) {
        this.jiuyezhishiUuidNumber = jiuyezhishiUuidNumber;
    }
    /**
	 * 设置：就业知识照片
	 */
    public String getJiuyezhishiPhoto() {
        return jiuyezhishiPhoto;
    }


    /**
	 * 获取：就业知识照片
	 */

    public void setJiuyezhishiPhoto(String jiuyezhishiPhoto) {
        this.jiuyezhishiPhoto = jiuyezhishiPhoto;
    }
    /**
	 * 设置：附件
	 */
    public String getJiuyezhishiFile() {
        return jiuyezhishiFile;
    }


    /**
	 * 获取：附件
	 */

    public void setJiuyezhishiFile(String jiuyezhishiFile) {
        this.jiuyezhishiFile = jiuyezhishiFile;
    }
    /**
	 * 设置：就业知识视频
	 */
    public String getJiuyezhishiVideo() {
        return jiuyezhishiVideo;
    }


    /**
	 * 获取：就业知识视频
	 */

    public void setJiuyezhishiVideo(String jiuyezhishiVideo) {
        this.jiuyezhishiVideo = jiuyezhishiVideo;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：就业知识类型
	 */
    public Integer getJiuyezhishiTypes() {
        return jiuyezhishiTypes;
    }


    /**
	 * 获取：就业知识类型
	 */

    public void setJiuyezhishiTypes(Integer jiuyezhishiTypes) {
        this.jiuyezhishiTypes = jiuyezhishiTypes;
    }
    /**
	 * 设置：就业知识热度
	 */
    public Integer getJiuyezhishiClicknum() {
        return jiuyezhishiClicknum;
    }


    /**
	 * 获取：就业知识热度
	 */

    public void setJiuyezhishiClicknum(Integer jiuyezhishiClicknum) {
        this.jiuyezhishiClicknum = jiuyezhishiClicknum;
    }
    /**
	 * 设置：就业知识介绍
	 */
    public String getJiuyezhishiContent() {
        return jiuyezhishiContent;
    }


    /**
	 * 获取：就业知识介绍
	 */

    public void setJiuyezhishiContent(String jiuyezhishiContent) {
        this.jiuyezhishiContent = jiuyezhishiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiuyezhishiDelete() {
        return jiuyezhishiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiuyezhishiDelete(Integer jiuyezhishiDelete) {
        this.jiuyezhishiDelete = jiuyezhishiDelete;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
