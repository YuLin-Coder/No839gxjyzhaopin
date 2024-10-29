package com.dao;

import com.entity.JiuyezhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiuyezhishiView;

/**
 * 就业知识 Dao 接口
 *
 * @author 
 */
public interface JiuyezhishiDao extends BaseMapper<JiuyezhishiEntity> {

   List<JiuyezhishiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
