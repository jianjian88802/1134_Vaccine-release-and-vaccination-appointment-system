package com.entity.model;

import com.entity.YuyuejiezongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预约接种
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuyuejiezongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 疫苗
     */
    private Integer yimiaoId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyuejiezongTime;


    /**
     * 预约备注
     */
    private String yuyuejiezongText;


    /**
     * 预约审核
     */
    private Integer yuyuejiezongYesnoTypes;


    /**
     * 审核原因
     */
    private String yuyuejiezongYesnoText;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：疫苗
	 */
    public Integer getYimiaoId() {
        return yimiaoId;
    }


    /**
	 * 设置：疫苗
	 */
    public void setYimiaoId(Integer yimiaoId) {
        this.yimiaoId = yimiaoId;
    }
    /**
	 * 获取：预约日期
	 */
    public Date getYuyuejiezongTime() {
        return yuyuejiezongTime;
    }


    /**
	 * 设置：预约日期
	 */
    public void setYuyuejiezongTime(Date yuyuejiezongTime) {
        this.yuyuejiezongTime = yuyuejiezongTime;
    }
    /**
	 * 获取：预约备注
	 */
    public String getYuyuejiezongText() {
        return yuyuejiezongText;
    }


    /**
	 * 设置：预约备注
	 */
    public void setYuyuejiezongText(String yuyuejiezongText) {
        this.yuyuejiezongText = yuyuejiezongText;
    }
    /**
	 * 获取：预约审核
	 */
    public Integer getYuyuejiezongYesnoTypes() {
        return yuyuejiezongYesnoTypes;
    }


    /**
	 * 设置：预约审核
	 */
    public void setYuyuejiezongYesnoTypes(Integer yuyuejiezongYesnoTypes) {
        this.yuyuejiezongYesnoTypes = yuyuejiezongYesnoTypes;
    }
    /**
	 * 获取：审核原因
	 */
    public String getYuyuejiezongYesnoText() {
        return yuyuejiezongYesnoText;
    }


    /**
	 * 设置：审核原因
	 */
    public void setYuyuejiezongYesnoText(String yuyuejiezongYesnoText) {
        this.yuyuejiezongYesnoText = yuyuejiezongYesnoText;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
