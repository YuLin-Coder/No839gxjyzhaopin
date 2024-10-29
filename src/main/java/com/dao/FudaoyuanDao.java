package com.dao;

import com.entity.FudaoyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FudaoyuanView;

/**
 * 辅导员 Dao 接口
 *
 * @author 
 */
public interface FudaoyuanDao extends BaseMapper<FudaoyuanEntity> {

   List<FudaoyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
