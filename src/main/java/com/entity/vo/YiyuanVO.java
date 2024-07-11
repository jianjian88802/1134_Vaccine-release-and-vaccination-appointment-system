package com.entity.vo;

import com.entity.YiyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 医院信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yiyuan")
public class YiyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 医院名称
     */

    @TableField(value = "yiyuan_name")
    private String yiyuanName;


    /**
     * 医院类型
     */

    @TableField(value = "yiyuan_types")
    private Integer yiyuanTypes;


    /**
     * 医院图片
     */

    @TableField(value = "yiyuan_photo")
    private String yiyuanPhoto;


    /**
     * 医院地址
     */

    @TableField(value = "yiyuan_address")
    private String yiyuanAddress;


    /**
     * 医院详情
     */

    @TableField(value = "yiyuan_content")
    private String yiyuanContent;


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
	 * 设置：医院名称
	 */
    public String getYiyuanName() {
        return yiyuanName;
    }


    /**
	 * 获取：医院名称
	 */

    public void setYiyuanName(String yiyuanName) {
        this.yiyuanName = yiyuanName;
    }
    /**
	 * 设置：医院类型
	 */
    public Integer getYiyuanTypes() {
        return yiyuanTypes;
    }


    /**
	 * 获取：医院类型
	 */

    public void setYiyuanTypes(Integer yiyuanTypes) {
        this.yiyuanTypes = yiyuanTypes;
    }
    /**
	 * 设置：医院图片
	 */
    public String getYiyuanPhoto() {
        return yiyuanPhoto;
    }


    /**
	 * 获取：医院图片
	 */

    public void setYiyuanPhoto(String yiyuanPhoto) {
        this.yiyuanPhoto = yiyuanPhoto;
    }
    /**
	 * 设置：医院地址
	 */
    public String getYiyuanAddress() {
        return yiyuanAddress;
    }


    /**
	 * 获取：医院地址
	 */

    public void setYiyuanAddress(String yiyuanAddress) {
        this.yiyuanAddress = yiyuanAddress;
    }
    /**
	 * 设置：医院详情
	 */
    public String getYiyuanContent() {
        return yiyuanContent;
    }


    /**
	 * 获取：医院详情
	 */

    public void setYiyuanContent(String yiyuanContent) {
        this.yiyuanContent = yiyuanContent;
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
