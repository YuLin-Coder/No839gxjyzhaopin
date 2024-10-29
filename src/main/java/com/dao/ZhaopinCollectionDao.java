package com.dao;

import com.entity.ZhaopinCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaopinCollectionView;

/**
 * 职位收藏 Dao 接口
 *
 * @author 
 */
public interface ZhaopinCollectionDao extends BaseMapper<ZhaopinCollectionEntity> {

   List<ZhaopinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
