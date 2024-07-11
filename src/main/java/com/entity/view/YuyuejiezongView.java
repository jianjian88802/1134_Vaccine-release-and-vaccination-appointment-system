package com.entity.view;

import com.entity.YuyuejiezongEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 预约接种
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yuyuejiezong")
public class YuyuejiezongView extends YuyuejiezongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 预约审核的值
		*/
		private String yuyuejiezongYesnoValue;



		//级联表 yimiao
			/**
			* 疫苗标题
			*/
			private String yimiaoName;
			/**
			* 疫苗类型
			*/
			private Integer yimiaoTypes;
				/**
				* 疫苗类型的值
				*/
				private String yimiaoValue;
			/**
			* 疫苗图片
			*/
			private String yimiaoPhoto;
			/**
			* 点击次数
			*/
			private Integer yimiaoClicknum;
			/**
			* 疫苗详情
			*/
			private String yimiaoContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public YuyuejiezongView() {

	}

	public YuyuejiezongView(YuyuejiezongEntity yuyuejiezongEntity) {
		try {
			BeanUtils.copyProperties(this, yuyuejiezongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 预约审核的值
			*/
			public String getYuyuejiezongYesnoValue() {
				return yuyuejiezongYesnoValue;
			}
			/**
			* 设置： 预约审核的值
			*/
			public void setYuyuejiezongYesnoValue(String yuyuejiezongYesnoValue) {
				this.yuyuejiezongYesnoValue = yuyuejiezongYesnoValue;
			}














				//级联表的get和set yimiao
					/**
					* 获取： 疫苗标题
					*/
					public String getYimiaoName() {
						return yimiaoName;
					}
					/**
					* 设置： 疫苗标题
					*/
					public void setYimiaoName(String yimiaoName) {
						this.yimiaoName = yimiaoName;
					}
					/**
					* 获取： 疫苗类型
					*/
					public Integer getYimiaoTypes() {
						return yimiaoTypes;
					}
					/**
					* 设置： 疫苗类型
					*/
					public void setYimiaoTypes(Integer yimiaoTypes) {
						this.yimiaoTypes = yimiaoTypes;
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
					/**
					* 获取： 疫苗图片
					*/
					public String getYimiaoPhoto() {
						return yimiaoPhoto;
					}
					/**
					* 设置： 疫苗图片
					*/
					public void setYimiaoPhoto(String yimiaoPhoto) {
						this.yimiaoPhoto = yimiaoPhoto;
					}

					/**
					* 获取： 点击次数
					*/
					public Integer getYimiaoClicknum() {
						return yimiaoClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setYimiaoClicknum(Integer yimiaoClicknum) {
						this.yimiaoClicknum = yimiaoClicknum;
					}
					/**
					* 获取： 疫苗详情
					*/
					public String getYimiaoContent() {
						return yimiaoContent;
					}
					/**
					* 设置： 疫苗详情
					*/
					public void setYimiaoContent(String yimiaoContent) {
						this.yimiaoContent = yimiaoContent;
					}








				//级联表的get和set yonghu
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
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
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







}
