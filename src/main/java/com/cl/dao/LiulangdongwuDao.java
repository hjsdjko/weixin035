package com.cl.dao;

import com.cl.entity.LiulangdongwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LiulangdongwuView;


/**
 * 流浪动物
 * 
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface LiulangdongwuDao extends BaseMapper<LiulangdongwuEntity> {
	
	List<LiulangdongwuView> selectListView(@Param("ew") Wrapper<LiulangdongwuEntity> wrapper);

	List<LiulangdongwuView> selectListView(Pagination page,@Param("ew") Wrapper<LiulangdongwuEntity> wrapper);
	
	LiulangdongwuView selectView(@Param("ew") Wrapper<LiulangdongwuEntity> wrapper);
	

}
