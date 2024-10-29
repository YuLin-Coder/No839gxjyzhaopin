package com.dao;

import com.entity.JiuyezhishiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiuyezhishiCollectionView;

/**
 * 就业知识收藏 Dao 接口
 *
 * @author 
 */
public interface JiuyezhishiCollectionDao extends BaseMapper<JiuyezhishiCollectionEntity> {

   List<JiuyezhishiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
