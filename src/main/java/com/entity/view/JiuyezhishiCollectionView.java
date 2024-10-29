package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiuyezhishiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 就业知识收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiuyezhishi_collection")
public class JiuyezhishiCollectionView extends JiuyezhishiCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jiuyezhishiCollectionValue;

	//级联表 就业知识
		/**
		* 就业知识名称
		*/

		@ColumnInfo(comment="就业知识名称",type="varchar(200)")
		private String jiuyezhishiName;
		/**
		* 就业知识编号
		*/

		@ColumnInfo(comment="就业知识编号",type="varchar(200)")
		private String jiuyezhishiUuidNumber;
		/**
		* 就业知识照片
		*/

		@ColumnInfo(comment="就业知识照片",type="varchar(200)")
		private String jiuyezhishiPhoto;
		/**
		* 附件
		*/

		@ColumnInfo(comment="附件",type="varchar(200)")
		private String jiuyezhishiFile;
		/**
		* 就业知识视频
		*/

		@ColumnInfo(comment="就业知识视频",type="varchar(200)")
		private String jiuyezhishiVideo;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 就业知识类型
		*/
		@ColumnInfo(comment="就业知识类型",type="int(11)")
		private Integer jiuyezhishiTypes;
			/**
			* 就业知识类型的值
			*/
			@ColumnInfo(comment="就业知识类型的字典表值",type="varchar(200)")
			private String jiuyezhishiValue;
		/**
		* 就业知识热度
		*/

		@ColumnInfo(comment="就业知识热度",type="int(11)")
		private Integer jiuyezhishiClicknum;
		/**
		* 就业知识介绍
		*/

		@ColumnInfo(comment="就业知识介绍",type="longtext")
		private String jiuyezhishiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jiuyezhishiDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 头像
		*/

		@ColumnInfo(comment="头像",type="varchar(255)")
		private String yonghuPhoto;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 假删
		*/

		@ColumnInfo(comment="假删",type="int(11)")
		private Integer yonghuDelete;



	public JiuyezhishiCollectionView() {

	}

	public JiuyezhishiCollectionView(JiuyezhishiCollectionEntity jiuyezhishiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jiuyezhishiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJiuyezhishiCollectionValue() {
		return jiuyezhishiCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJiuyezhishiCollectionValue(String jiuyezhishiCollectionValue) {
		this.jiuyezhishiCollectionValue = jiuyezhishiCollectionValue;
	}


	//级联表的get和set 就业知识

		/**
		* 获取： 就业知识名称
		*/
		public String getJiuyezhishiName() {
			return jiuyezhishiName;
		}
		/**
		* 设置： 就业知识名称
		*/
		public void setJiuyezhishiName(String jiuyezhishiName) {
			this.jiuyezhishiName = jiuyezhishiName;
		}

		/**
		* 获取： 就业知识编号
		*/
		public String getJiuyezhishiUuidNumber() {
			return jiuyezhishiUuidNumber;
		}
		/**
		* 设置： 就业知识编号
		*/
		public void setJiuyezhishiUuidNumber(String jiuyezhishiUuidNumber) {
			this.jiuyezhishiUuidNumber = jiuyezhishiUuidNumber;
		}

		/**
		* 获取： 就业知识照片
		*/
		public String getJiuyezhishiPhoto() {
			return jiuyezhishiPhoto;
		}
		/**
		* 设置： 就业知识照片
		*/
		public void setJiuyezhishiPhoto(String jiuyezhishiPhoto) {
			this.jiuyezhishiPhoto = jiuyezhishiPhoto;
		}

		/**
		* 获取： 附件
		*/
		public String getJiuyezhishiFile() {
			return jiuyezhishiFile;
		}
		/**
		* 设置： 附件
		*/
		public void setJiuyezhishiFile(String jiuyezhishiFile) {
			this.jiuyezhishiFile = jiuyezhishiFile;
		}

		/**
		* 获取： 就业知识视频
		*/
		public String getJiuyezhishiVideo() {
			return jiuyezhishiVideo;
		}
		/**
		* 设置： 就业知识视频
		*/
		public void setJiuyezhishiVideo(String jiuyezhishiVideo) {
			this.jiuyezhishiVideo = jiuyezhishiVideo;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 就业知识类型
		*/
		public Integer getJiuyezhishiTypes() {
			return jiuyezhishiTypes;
		}
		/**
		* 设置： 就业知识类型
		*/
		public void setJiuyezhishiTypes(Integer jiuyezhishiTypes) {
			this.jiuyezhishiTypes = jiuyezhishiTypes;
		}


			/**
			* 获取： 就业知识类型的值
			*/
			public String getJiuyezhishiValue() {
				return jiuyezhishiValue;
			}
			/**
			* 设置： 就业知识类型的值
			*/
			public void setJiuyezhishiValue(String jiuyezhishiValue) {
				this.jiuyezhishiValue = jiuyezhishiValue;
			}

		/**
		* 获取： 就业知识热度
		*/
		public Integer getJiuyezhishiClicknum() {
			return jiuyezhishiClicknum;
		}
		/**
		* 设置： 就业知识热度
		*/
		public void setJiuyezhishiClicknum(Integer jiuyezhishiClicknum) {
			this.jiuyezhishiClicknum = jiuyezhishiClicknum;
		}

		/**
		* 获取： 就业知识介绍
		*/
		public String getJiuyezhishiContent() {
			return jiuyezhishiContent;
		}
		/**
		* 设置： 就业知识介绍
		*/
		public void setJiuyezhishiContent(String jiuyezhishiContent) {
			this.jiuyezhishiContent = jiuyezhishiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJiuyezhishiDelete() {
			return jiuyezhishiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJiuyezhishiDelete(Integer jiuyezhishiDelete) {
			this.jiuyezhishiDelete = jiuyezhishiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 假删
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 假删
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "JiuyezhishiCollectionView{" +
			", jiuyezhishiCollectionValue=" + jiuyezhishiCollectionValue +
			", jiuyezhishiName=" + jiuyezhishiName +
			", jiuyezhishiUuidNumber=" + jiuyezhishiUuidNumber +
			", jiuyezhishiPhoto=" + jiuyezhishiPhoto +
			", jiuyezhishiFile=" + jiuyezhishiFile +
			", jiuyezhishiVideo=" + jiuyezhishiVideo +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", jiuyezhishiClicknum=" + jiuyezhishiClicknum +
			", jiuyezhishiContent=" + jiuyezhishiContent +
			", jiuyezhishiDelete=" + jiuyezhishiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
