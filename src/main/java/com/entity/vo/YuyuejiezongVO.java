package com.entity.vo;

import com.entity.YuyuejiezongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预约接种
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuyuejiezong")
public class YuyuejiezongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
     * 创建时间 show1 show2 photoShow
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
