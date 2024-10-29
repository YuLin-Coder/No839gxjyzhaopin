package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.QiyeEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 企业
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("qiye")
public class QiyeView extends QiyeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 企业类型的值
	*/
	@ColumnInfo(comment="企业类型的字典表值",type="varchar(200)")
	private String qiyeValue;




	public QiyeView() {

	}

	public QiyeView(QiyeEntity qiyeEntity) {
		try {
			BeanUtils.copyProperties(this, qiyeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "QiyeView{" +
			", qiyeValue=" + qiyeValue +
			"} " + super.toString();
	}
}
