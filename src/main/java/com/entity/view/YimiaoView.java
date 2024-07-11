package com.entity.view;

import com.entity.YimiaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 疫苗信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yimiao")
public class YimiaoView extends YimiaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 疫苗类型的值
		*/
		private String yimiaoValue;



		//级联表 yiyuan
			/**
			* 医院名称
			*/
			private String yiyuanName;
			/**
			* 医院类型
			*/
			private Integer yiyuanTypes;
				/**
				* 医院类型的值
				*/
				private String yiyuanValue;
			/**
			* 医院图片
			*/
			private String yiyuanPhoto;
			/**
			* 医院地址
			*/
			private String yiyuanAddress;
			/**
			* 医院详情
			*/
			private String yiyuanContent;

	public YimiaoView() {

	}

	public YimiaoView(YimiaoEntity yimiaoEntity) {
		try {
			BeanUtils.copyProperties(this, yimiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 疫苗类型的值
			*/
			public String getYimiaoValue() {
				return yimiaoValue;
			}
			/**
			* 设置： 疫苗类型的值
			*/
			public void setYimiaoValue(String yimiaoValue) {
				this.yimiaoValue = yimiaoValue;
			}














				//级联表的get和set yiyuan
					/**
					* 获取： 医院名称
					*/
					public String getYiyuanName() {
						return yiyuanName;
					}
					/**
					* 设置： 医院名称
					*/
					public void setYiyuanName(String yiyuanName) {
						this.yiyuanName = yiyuanName;
					}
					/**
					* 获取： 医院类型
					*/
					public Integer getYiyuanTypes() {
						return yiyuanTypes;
					}
					/**
					* 设置： 医院类型
					*/
					public void setYiyuanTypes(Integer yiyuanTypes) {
						this.yiyuanTypes = yiyuanTypes;
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
					/**
					* 获取： 医院图片
					*/
					public String getYiyuanPhoto() {
						return yiyuanPhoto;
					}
					/**
					* 设置： 医院图片
					*/
					public void setYiyuanPhoto(String yiyuanPhoto) {
						this.yiyuanPhoto = yiyuanPhoto;
					}
					/**
					* 获取： 医院地址
					*/
					public String getYiyuanAddress() {
						return yiyuanAddress;
					}
					/**
					* 设置： 医院地址
					*/
					public void setYiyuanAddress(String yiyuanAddress) {
						this.yiyuanAddress = yiyuanAddress;
					}
					/**
					* 获取： 医院详情
					*/
					public String getYiyuanContent() {
						return yiyuanContent;
					}
					/**
					* 设置： 医院详情
					*/
					public void setYiyuanContent(String yiyuanContent) {
						this.yiyuanContent = yiyuanContent;
					}






}
