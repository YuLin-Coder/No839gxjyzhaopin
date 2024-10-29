package com.dao;

import com.entity.ZhaopinToudiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaopinToudiView;

/**
 * 简历投递 Dao 接口
 *
 * @author 
 */
public interface ZhaopinToudiDao extends BaseMapper<ZhaopinToudiEntity> {

   List<ZhaopinToudiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
