package com.cl.dao;

import com.cl.entity.DiscussliulangdongwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussliulangdongwuView;


/**
 * 流浪动物评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface DiscussliulangdongwuDao extends BaseMapper<DiscussliulangdongwuEntity> {
	
	List<DiscussliulangdongwuView> selectListView(@Param("ew") Wrapper<DiscussliulangdongwuEntity> wrapper);

	List<DiscussliulangdongwuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussliulangdongwuEntity> wrapper);
	
	DiscussliulangdongwuView selectView(@Param("ew") Wrapper<DiscussliulangdongwuEntity> wrapper);
	

}
