package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 预约接种
 *
 * @author 
 * @email
 */
@TableName("yuyuejiezong")
public class YuyuejiezongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuyuejiezongEntity() {

	}

	public YuyuejiezongEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 疫苗
     */
    @TableField(value = "yimiao_id")

    private Integer yimiaoId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "yuyuejiezong_time")

    private Date yuyuejiezongTime;


    /**
     * 预约备注
     */
    @TableField(value = "yuyuejiezong_text")

    private String yuyuejiezongText;


    /**
     * 预约审核
     */
    @TableField(value = "yuyuejiezong_yesno_types")

    private Integer yuyuejiezongYesnoTypes;


    /**
     * 审核原因
     */
    @TableField(value = "yuyuejiezong_yesno_text")

    private String yuyuejiezongYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：疫苗
	 */
    public Integer getYimiaoId() {
        return yimiaoId;
    }


    /**
	 * 获取：疫苗
	 */

    public void setYimiaoId(Integer yimiaoId) {
        this.yimiaoId = yimiaoId;
    }
    /**
	 * 设置：预约日期
	 */
    public Date getYuyuejiezongTime() {
        return yuyuejiezongTime;
    }


    /**
	 * 获取：预约日期
	 */

    public void setYuyuejiezongTime(Date yuyuejiezongTime) {
        this.yuyuejiezongTime = yuyuejiezongTime;
    }
    /**
	 * 设置：预约备注
	 */
    public String getYuyuejiezongText() {
        return yuyuejiezongText;
    }


    /**
	 * 获取：预约备注
	 */

    public void setYuyuejiezongText(String yuyuejiezongText) {
        this.yuyuejiezongText = yuyuejiezongText;
    }
    /**
	 * 设置：预约审核
	 */
    public Integer getYuyuejiezongYesnoTypes() {
        return yuyuejiezongYesnoTypes;
    }


    /**
	 * 获取：预约审核
	 */

    public void setYuyuejiezongYesnoTypes(Integer yuyuejiezongYesnoTypes) {
        this.yuyuejiezongYesnoTypes = yuyuejiezongYesnoTypes;
    }
    /**
	 * 设置：审核原因
	 */
    public String getYuyuejiezongYesnoText() {
        return yuyuejiezongYesnoText;
    }


    /**
	 * 获取：审核原因
	 */

    public void setYuyuejiezongYesnoText(String yuyuejiezongYesnoText) {
        this.yuyuejiezongYesnoText = yuyuejiezongYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yuyuejiezong{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", yimiaoId=" + yimiaoId +
            ", yuyuejiezongTime=" + yuyuejiezongTime +
            ", yuyuejiezongText=" + yuyuejiezongText +
            ", yuyuejiezongYesnoTypes=" + yuyuejiezongYesnoTypes +
            ", yuyuejiezongYesnoText=" + yuyuejiezongYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
