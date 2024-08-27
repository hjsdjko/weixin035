package com.cl.dao;

import com.cl.entity.GonggaozixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GonggaozixunView;


/**
 * 公告资讯
 * 
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface GonggaozixunDao extends BaseMapper<GonggaozixunEntity> {
	
	List<GonggaozixunView> selectListView(@Param("ew") Wrapper<GonggaozixunEntity> wrapper);

	List<GonggaozixunView> selectListView(Pagination page,@Param("ew") Wrapper<GonggaozixunEntity> wrapper);
	
	GonggaozixunView selectView(@Param("ew") Wrapper<GonggaozixunEntity> wrapper);
	

}
