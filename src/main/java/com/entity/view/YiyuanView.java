package com.entity.view;

import com.entity.YiyuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 医院信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yiyuan")
public class YiyuanView extends YiyuanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 医院类型的值
		*/
		private String yiyuanValue;



	public YiyuanView() {

	}

	public YiyuanView(YiyuanEntity yiyuanEntity) {
		try {
			BeanUtils.copyProperties(this, yiyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 医院类型的值
			*/
			public String getYiyuanValue() {
				return yiyuanValue;
			}
			/**
			* 设置： 医院类型的值
			*/
			public void setYiyuanValue(String yiyuanValue) {
				this.yiyuanValue = yiyuanValue;
			}











}
