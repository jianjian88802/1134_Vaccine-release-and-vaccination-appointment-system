package com.entity.model;

import com.entity.YiyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 医院信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YiyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 医院名称
     */
    private String yiyuanName;


    /**
     * 医院类型
     */
    private Integer yiyuanTypes;


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
	 * 获取：医院名称
	 */
    public String getYiyuanName() {
        return yiyuanName;
    }


    /**
	 * 设置：医院名称
	 */
    public void setYiyuanName(String yiyuanName) {
        this.yiyuanName = yiyuanName;
    }
    /**
	 * 获取：医院类型
	 */
    public Integer getYiyuanTypes() {
        return yiyuanTypes;
    }


    /**
	 * 设置：医院类型
	 */
    public void setYiyuanTypes(Integer yiyuanTypes) {
        this.yiyuanTypes = yiyuanTypes;
    }
    /**
	 * 获取：医院图片
	 */
    public String getYiyuanPhoto() {
        return yiyuanPhoto;
    }


    /**
	 * 设置：医院图片
	 */
    public void setYiyuanPhoto(String yiyuanPhoto) {
        this.yiyuanPhoto = yiyuanPhoto;
    }
    /**
	 * 获取：医院地址
	 */
    public String getYiyuanAddress() {
        return yiyuanAddress;
    }


    /**
	 * 设置：医院地址
	 */
    public void setYiyuanAddress(String yiyuanAddress) {
        this.yiyuanAddress = yiyuanAddress;
    }
    /**
	 * 获取：医院详情
	 */
    public String getYiyuanContent() {
        return yiyuanContent;
    }


    /**
	 * 设置：医院详情
	 */
    public void setYiyuanContent(String yiyuanContent) {
        this.yiyuanContent = yiyuanContent;
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
