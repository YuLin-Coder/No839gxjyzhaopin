package com.dao;

import com.entity.BiyequxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BiyequxiangView;

/**
 * 毕业去向 Dao 接口
 *
 * @author 
 */
public interface BiyequxiangDao extends BaseMapper<BiyequxiangEntity> {

   List<BiyequxiangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
