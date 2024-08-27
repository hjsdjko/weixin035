package com.cl.dao;

import com.cl.entity.DiscussgonggaozixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussgonggaozixunView;


/**
 * 公告资讯评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-06 19:19:17
 */
public interface DiscussgonggaozixunDao extends BaseMapper<DiscussgonggaozixunEntity> {
	
	List<DiscussgonggaozixunView> selectListView(@Param("ew") Wrapper<DiscussgonggaozixunEntity> wrapper);

	List<DiscussgonggaozixunView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgonggaozixunEntity> wrapper);
	
	DiscussgonggaozixunView selectView(@Param("ew") Wrapper<DiscussgonggaozixunEntity> wrapper);
	

}
