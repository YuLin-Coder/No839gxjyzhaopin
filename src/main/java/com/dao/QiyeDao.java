package com.dao;

import com.entity.QiyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.QiyeView;

/**
 * 企业 Dao 接口
 *
 * @author 
 */
public interface QiyeDao extends BaseMapper<QiyeEntity> {

   List<QiyeView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
