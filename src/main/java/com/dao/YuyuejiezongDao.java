package com.dao;

import com.entity.YuyuejiezongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyuejiezongView;

/**
 * 预约接种 Dao 接口
 *
 * @author 
 */
public interface YuyuejiezongDao extends BaseMapper<YuyuejiezongEntity> {

   List<YuyuejiezongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
