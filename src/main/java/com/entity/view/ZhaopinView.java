package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhaopinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 职位招聘
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhaopin")
public class ZhaopinView extends ZhaopinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 招聘岗位的值
	*/
	@ColumnInfo(comment="招聘岗位的字典表值",type="varchar(200)")
	private String zhaopinValue;
	/**
	* 招聘类型的值
	*/
	@ColumnInfo(comment="招聘类型的字典表值",type="varchar(200)")
	private String leixingValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;

	//级联表 企业
		/**
		* 企业名称
		*/

		@ColumnInfo(comment="企业名称",type="varchar(200)")
		private String qiyeName;
		/**
		* 企业类型
		*/
		@ColumnInfo(comment="企业类型",type="int(11)")
		private Integer qiyeTypes;
			/**
			* 企业类型的值
			*/
			@ColumnInfo(comment="企业类型的字典表值",type="varchar(200)")
			private String qiyeValue;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String qiyePhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String qiyeEmail;
		/**
		* 企业logo
		*/

		@ColumnInfo(comment="企业logo",type="varchar(200)")
		private String qiyePhoto;
		/**
		* 企业成立时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="企业成立时间",type="timestamp")
		private Date qiyeChenglishijianTime;
		/**
		* 企业介绍
		*/

		@ColumnInfo(comment="企业介绍",type="text")
		private String qiyeContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer qiyeDelete;



	public ZhaopinView() {

	}

	public ZhaopinView(ZhaopinEntity zhaopinEntity) {
		try {
			BeanUtils.copyProperties(this, zhaopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 招聘岗位的值
	*/
	public String getZhaopinValue() {
		return zhaopinValue;
	}
	/**
	* 设置： 招聘岗位的值
	*/
	public void setZhaopinValue(String zhaopinValue) {
		this.zhaopinValue = zhaopinValue;
	}
	//当前表的
	/**
	* 获取： 招聘类型的值
	*/
	public String getLeixingValue() {
		return leixingValue;
	}
	/**
	* 设置： 招聘类型的值
	*/
	public void setLeixingValue(String leixingValue) {
		this.leixingValue = leixingValue;
	}
	//当前表的
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


	//级联表的get和set 企业

		/**
		* 获取： 企业名称
		*/
		public String getQiyeName() {
			return qiyeName;
		}
		/**
		* 设置： 企业名称
		*/
		public void setQiyeName(String qiyeName) {
			this.qiyeName = qiyeName;
		}
		/**
		* 获取： 企业类型
		*/
		public Integer getQiyeTypes() {
			return qiyeTypes;
		}
		/**
		* 设置： 企业类型
		*/
		public void setQiyeTypes(Integer qiyeTypes) {
			this.qiyeTypes = qiyeTypes;
		}


			/**
			* 获取： 企业类型的值
			*/
			public String getQiyeValue() {
				return qiyeValue;
			}
			/**
			* 设置： 企业类型的值
			*/
			public void setQiyeValue(String qiyeValue) {
				this.qiyeValue = qiyeValue;
			}

		/**
		* 获取： 联系方式
		*/
		public String getQiyePhone() {
			return qiyePhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setQiyePhone(String qiyePhone) {
			this.qiyePhone = qiyePhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getQiyeEmail() {
			return qiyeEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setQiyeEmail(String qiyeEmail) {
			this.qiyeEmail = qiyeEmail;
		}

		/**
		* 获取： 企业logo
		*/
		public String getQiyePhoto() {
			return qiyePhoto;
		}
		/**
		* 设置： 企业logo
		*/
		public void setQiyePhoto(String qiyePhoto) {
			this.qiyePhoto = qiyePhoto;
		}

		/**
		* 获取： 企业成立时间
		*/
		public Date getQiyeChenglishijianTime() {
			return qiyeChenglishijianTime;
		}
		/**
		* 设置： 企业成立时间
		*/
		public void setQiyeChenglishijianTime(Date qiyeChenglishijianTime) {
			this.qiyeChenglishijianTime = qiyeChenglishijianTime;
		}

		/**
		* 获取： 企业介绍
		*/
		public String getQiyeContent() {
			return qiyeContent;
		}
		/**
		* 设置： 企业介绍
		*/
		public void setQiyeContent(String qiyeContent) {
			this.qiyeContent = qiyeContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getQiyeDelete() {
			return qiyeDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setQiyeDelete(Integer qiyeDelete) {
			this.qiyeDelete = qiyeDelete;
		}


	@Override
	public String toString() {
		return "ZhaopinView{" +
			", zhaopinValue=" + zhaopinValue +
			", leixingValue=" + leixingValue +
			", shangxiaValue=" + shangxiaValue +
			", qiyeName=" + qiyeName +
			", qiyePhone=" + qiyePhone +
			", qiyeEmail=" + qiyeEmail +
			", qiyePhoto=" + qiyePhoto +
			", qiyeChenglishijianTime=" + DateUtil.convertString(qiyeChenglishijianTime,"yyyy-MM-dd") +
			", qiyeContent=" + qiyeContent +
			", qiyeDelete=" + qiyeDelete +
			"} " + super.toString();
	}
}
