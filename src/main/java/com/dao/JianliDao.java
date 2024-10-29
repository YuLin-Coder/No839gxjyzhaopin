package com.dao;

import com.entity.JianliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianliView;

/**
 * 简历 Dao 接口
 *
 * @author 
 */
public interface JianliDao extends BaseMapper<JianliEntity> {

   List<JianliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
