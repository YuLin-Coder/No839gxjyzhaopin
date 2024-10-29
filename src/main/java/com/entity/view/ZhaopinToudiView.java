package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZhaopinToudiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 简历投递
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zhaopin_toudi")
public class ZhaopinToudiView extends ZhaopinToudiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 审核状态的值
	*/
	@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
	private String zhaopinToudiYesnoValue;

	//级联表 简历
					 
		/**
		* 简历 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer jianliYonghuId;
		/**
		* 简历唯一编号
		*/

		@ColumnInfo(comment="简历唯一编号",type="varchar(200)")
		private String jianliUuidNumber;
		/**
		* 简历标题
		*/

		@ColumnInfo(comment="简历标题",type="varchar(200)")
		private String jianliName;
		/**
		* 姓名
		*/

		@ColumnInfo(comment="姓名",type="varchar(200)")
		private String jianliXingming;
		/**
		* 求职意向
		*/
		@ColumnInfo(comment="求职意向",type="int(11)")
		private Integer jianliTypes;
			/**
			* 求职意向的值
			*/
			@ColumnInfo(comment="求职意向的字典表值",type="varchar(200)")
			private String jianliValue;
		/**
		* 期望工资
		*/

		@ColumnInfo(comment="期望工资",type="varchar(200)")
		private String jianliXinzi;
		/**
		* 学历
		*/

		@ColumnInfo(comment="学历",type="varchar(200)")
		private String jianliXueli;
		/**
		* 工作经历
		*/

		@ColumnInfo(comment="工作经历",type="varchar(200)")
		private String jianliJingli;
		/**
		* 性别
		*/
		@ColumnInfo(comment="性别",type="int(11)")
		private Integer sexTypes;
			/**
			* 性别的值
			*/
			@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
			private String sexValue;
		/**
		* 简历文件
		*/

		@ColumnInfo(comment="简历文件",type="varchar(200)")
		private String jianliFile;
		/**
		* 手机号
		*/

		@ColumnInfo(comment="手机号",type="varchar(200)")
		private String jianliPhone;
		/**
		* 照片
		*/

		@ColumnInfo(comment="照片",type="varchar(200)")
		private String jianliPhoto;
		/**
		* 现在位置
		*/

		@ColumnInfo(comment="现在位置",type="varchar(200)")
		private String jianliAddress;
		/**
		* 教育经历
		*/

		@ColumnInfo(comment="教育经历",type="text")
		private String jiaoyuText;
		/**
		* 实习或工作经历
		*/

		@ColumnInfo(comment="实习或工作经历",type="text")
		private String shixiText;
		/**
		* 个人介绍
		*/

		@ColumnInfo(comment="个人介绍",type="text")
		private String gerenText;
	//级联表 职位招聘
					 
		/**
		* 职位招聘 的 企业
		*/
		@ColumnInfo(comment="企业",type="int(11)")
		private Integer zhaopinQiyeId;
		/**
		* 招聘信息名称
		*/

		@ColumnInfo(comment="招聘信息名称",type="varchar(200)")
		private String zhaopinName;
		/**
		* 招聘信息照片
		*/

		@ColumnInfo(comment="招聘信息照片",type="varchar(200)")
		private String zhaopinPhoto;
		/**
		* 薪资待遇
		*/

		@ColumnInfo(comment="薪资待遇",type="varchar(200)")
		private String zhaopinDaiyu;
		/**
		* 上班地点
		*/

		@ColumnInfo(comment="上班地点",type="varchar(200)")
		private String zhaopinAddress;
		/**
		* 联系人
		*/

		@ColumnInfo(comment="联系人",type="varchar(200)")
		private String lianxirenName;
		/**
		* 招聘电话
		*/

		@ColumnInfo(comment="招聘电话",type="varchar(200)")
		private String zhaopinPhone;
		/**
		* 招聘岗位
		*/
		@ColumnInfo(comment="招聘岗位",type="int(11)")
		private Integer zhaopinTypes;
			/**
			* 招聘岗位的值
			*/
			@ColumnInfo(comment="招聘岗位的字典表值",type="varchar(200)")
			private String zhaopinValue;
		/**
		* 招聘类型
		*/
		@ColumnInfo(comment="招聘类型",type="int(11)")
		private Integer leixingTypes;
			/**
			* 招聘类型的值
			*/
			@ColumnInfo(comment="招聘类型的字典表值",type="varchar(200)")
			private String leixingValue;
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
		* 招聘人数
		*/

		@ColumnInfo(comment="招聘人数",type="int(11)")
		private Integer zhaopinRenshuNumber;
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
		* 招聘信息详情
		*/

		@ColumnInfo(comment="招聘信息详情",type="text")
		private String zhaopinContent;



	public ZhaopinToudiView() {

	}

	public ZhaopinToudiView(ZhaopinToudiEntity zhaopinToudiEntity) {
		try {
			BeanUtils.copyProperties(this, zhaopinToudiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 审核状态的值
	*/
	public String getZhaopinToudiYesnoValue() {
		return zhaopinToudiYesnoValue;
	}
	/**
	* 设置： 审核状态的值
	*/
	public void setZhaopinToudiYesnoValue(String zhaopinToudiYesnoValue) {
		this.zhaopinToudiYesnoValue = zhaopinToudiYesnoValue;
	}


	//级联表的get和set 简历
		/**
		* 获取：简历 的 用户
		*/
		public Integer getJianliYonghuId() {
			return jianliYonghuId;
		}
		/**
		* 设置：简历 的 用户
		*/
		public void setJianliYonghuId(Integer jianliYonghuId) {
			this.jianliYonghuId = jianliYonghuId;
		}

		/**
		* 获取： 简历唯一编号
		*/
		public String getJianliUuidNumber() {
			return jianliUuidNumber;
		}
		/**
		* 设置： 简历唯一编号
		*/
		public void setJianliUuidNumber(String jianliUuidNumber) {
			this.jianliUuidNumber = jianliUuidNumber;
		}

		/**
		* 获取： 简历标题
		*/
		public String getJianliName() {
			return jianliName;
		}
		/**
		* 设置： 简历标题
		*/
		public void setJianliName(String jianliName) {
			this.jianliName = jianliName;
		}

		/**
		* 获取： 姓名
		*/
		public String getJianliXingming() {
			return jianliXingming;
		}
		/**
		* 设置： 姓名
		*/
		public void setJianliXingming(String jianliXingming) {
			this.jianliXingming = jianliXingming;
		}
		/**
		* 获取： 求职意向
		*/
		public Integer getJianliTypes() {
			return jianliTypes;
		}
		/**
		* 设置： 求职意向
		*/
		public void setJianliTypes(Integer jianliTypes) {
			this.jianliTypes = jianliTypes;
		}


			/**
			* 获取： 求职意向的值
			*/
			public String getJianliValue() {
				return jianliValue;
			}
			/**
			* 设置： 求职意向的值
			*/
			public void setJianliValue(String jianliValue) {
				this.jianliValue = jianliValue;
			}

		/**
		* 获取： 期望工资
		*/
		public String getJianliXinzi() {
			return jianliXinzi;
		}
		/**
		* 设置： 期望工资
		*/
		public void setJianliXinzi(String jianliXinzi) {
			this.jianliXinzi = jianliXinzi;
		}

		/**
		* 获取： 学历
		*/
		public String getJianliXueli() {
			return jianliXueli;
		}
		/**
		* 设置： 学历
		*/
		public void setJianliXueli(String jianliXueli) {
			this.jianliXueli = jianliXueli;
		}

		/**
		* 获取： 工作经历
		*/
		public String getJianliJingli() {
			return jianliJingli;
		}
		/**
		* 设置： 工作经历
		*/
		public void setJianliJingli(String jianliJingli) {
			this.jianliJingli = jianliJingli;
		}
		/**
		* 获取： 性别
		*/
		public Integer getSexTypes() {
			return sexTypes;
		}
		/**
		* 设置： 性别
		*/
		public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
		}


			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}

		/**
		* 获取： 简历文件
		*/
		public String getJianliFile() {
			return jianliFile;
		}
		/**
		* 设置： 简历文件
		*/
		public void setJianliFile(String jianliFile) {
			this.jianliFile = jianliFile;
		}

		/**
		* 获取： 手机号
		*/
		public String getJianliPhone() {
			return jianliPhone;
		}
		/**
		* 设置： 手机号
		*/
		public void setJianliPhone(String jianliPhone) {
			this.jianliPhone = jianliPhone;
		}

		/**
		* 获取： 照片
		*/
		public String getJianliPhoto() {
			return jianliPhoto;
		}
		/**
		* 设置： 照片
		*/
		public void setJianliPhoto(String jianliPhoto) {
			this.jianliPhoto = jianliPhoto;
		}

		/**
		* 获取： 现在位置
		*/
		public String getJianliAddress() {
			return jianliAddress;
		}
		/**
		* 设置： 现在位置
		*/
		public void setJianliAddress(String jianliAddress) {
			this.jianliAddress = jianliAddress;
		}

		/**
		* 获取： 教育经历
		*/
		public String getJiaoyuText() {
			return jiaoyuText;
		}
		/**
		* 设置： 教育经历
		*/
		public void setJiaoyuText(String jiaoyuText) {
			this.jiaoyuText = jiaoyuText;
		}

		/**
		* 获取： 实习或工作经历
		*/
		public String getShixiText() {
			return shixiText;
		}
		/**
		* 设置： 实习或工作经历
		*/
		public void setShixiText(String shixiText) {
			this.shixiText = shixiText;
		}

		/**
		* 获取： 个人介绍
		*/
		public String getGerenText() {
			return gerenText;
		}
		/**
		* 设置： 个人介绍
		*/
		public void setGerenText(String gerenText) {
			this.gerenText = gerenText;
		}
	//级联表的get和set 职位招聘
		/**
		* 获取：职位招聘 的 企业
		*/
		public Integer getZhaopinQiyeId() {
			return zhaopinQiyeId;
		}
		/**
		* 设置：职位招聘 的 企业
		*/
		public void setZhaopinQiyeId(Integer zhaopinQiyeId) {
			this.zhaopinQiyeId = zhaopinQiyeId;
		}

		/**
		* 获取： 招聘信息名称
		*/
		public String getZhaopinName() {
			return zhaopinName;
		}
		/**
		* 设置： 招聘信息名称
		*/
		public void setZhaopinName(String zhaopinName) {
			this.zhaopinName = zhaopinName;
		}

		/**
		* 获取： 招聘信息照片
		*/
		public String getZhaopinPhoto() {
			return zhaopinPhoto;
		}
		/**
		* 设置： 招聘信息照片
		*/
		public void setZhaopinPhoto(String zhaopinPhoto) {
			this.zhaopinPhoto = zhaopinPhoto;
		}

		/**
		* 获取： 薪资待遇
		*/
		public String getZhaopinDaiyu() {
			return zhaopinDaiyu;
		}
		/**
		* 设置： 薪资待遇
		*/
		public void setZhaopinDaiyu(String zhaopinDaiyu) {
			this.zhaopinDaiyu = zhaopinDaiyu;
		}

		/**
		* 获取： 上班地点
		*/
		public String getZhaopinAddress() {
			return zhaopinAddress;
		}
		/**
		* 设置： 上班地点
		*/
		public void setZhaopinAddress(String zhaopinAddress) {
			this.zhaopinAddress = zhaopinAddress;
		}

		/**
		* 获取： 联系人
		*/
		public String getLianxirenName() {
			return lianxirenName;
		}
		/**
		* 设置： 联系人
		*/
		public void setLianxirenName(String lianxirenName) {
			this.lianxirenName = lianxirenName;
		}

		/**
		* 获取： 招聘电话
		*/
		public String getZhaopinPhone() {
			return zhaopinPhone;
		}
		/**
		* 设置： 招聘电话
		*/
		public void setZhaopinPhone(String zhaopinPhone) {
			this.zhaopinPhone = zhaopinPhone;
		}
		/**
		* 获取： 招聘岗位
		*/
		public Integer getZhaopinTypes() {
			return zhaopinTypes;
		}
		/**
		* 设置： 招聘岗位
		*/
		public void setZhaopinTypes(Integer zhaopinTypes) {
			this.zhaopinTypes = zhaopinTypes;
		}


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
		/**
		* 获取： 招聘类型
		*/
		public Integer getLeixingTypes() {
			return leixingTypes;
		}
		/**
		* 设置： 招聘类型
		*/
		public void setLeixingTypes(Integer leixingTypes) {
			this.leixingTypes = leixingTypes;
		}


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
		* 获取： 招聘人数
		*/
		public Integer getZhaopinRenshuNumber() {
			return zhaopinRenshuNumber;
		}
		/**
		* 设置： 招聘人数
		*/
		public void setZhaopinRenshuNumber(Integer zhaopinRenshuNumber) {
			this.zhaopinRenshuNumber = zhaopinRenshuNumber;
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
		* 获取： 招聘信息详情
		*/
		public String getZhaopinContent() {
			return zhaopinContent;
		}
		/**
		* 设置： 招聘信息详情
		*/
		public void setZhaopinContent(String zhaopinContent) {
			this.zhaopinContent = zhaopinContent;
		}


	@Override
	public String toString() {
		return "ZhaopinToudiView{" +
			", zhaopinToudiYesnoValue=" + zhaopinToudiYesnoValue +
			", jianliUuidNumber=" + jianliUuidNumber +
			", jianliName=" + jianliName +
			", jianliXingming=" + jianliXingming +
			", jianliXinzi=" + jianliXinzi +
			", jianliXueli=" + jianliXueli +
			", jianliJingli=" + jianliJingli +
			", jianliFile=" + jianliFile +
			", jianliPhone=" + jianliPhone +
			", jianliPhoto=" + jianliPhoto +
			", jianliAddress=" + jianliAddress +
			", jiaoyuText=" + jiaoyuText +
			", shixiText=" + shixiText +
			", gerenText=" + gerenText +
			", zhaopinName=" + zhaopinName +
			", zhaopinPhoto=" + zhaopinPhoto +
			", zhaopinDaiyu=" + zhaopinDaiyu +
			", zhaopinAddress=" + zhaopinAddress +
			", lianxirenName=" + lianxirenName +
			", zhaopinPhone=" + zhaopinPhone +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", zhaopinRenshuNumber=" + zhaopinRenshuNumber +
			", zhaopinContent=" + zhaopinContent +
			"} " + super.toString();
	}
}
