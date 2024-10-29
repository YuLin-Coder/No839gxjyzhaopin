package com.dao;

import com.entity.ZhaopinLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaopinLiuyanView;

/**
 * 职位留言 Dao 接口
 *
 * @author 
 */
public interface ZhaopinLiuyanDao extends BaseMapper<ZhaopinLiuyanEntity> {

   List<ZhaopinLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
