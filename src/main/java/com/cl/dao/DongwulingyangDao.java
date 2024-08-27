package com.cl.dao;

import com.cl.entity.DongwulingyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongwulingyangView;


/**
 * 动物领养
 * 
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface DongwulingyangDao extends BaseMapper<DongwulingyangEntity> {
	
	List<DongwulingyangView> selectListView(@Param("ew") Wrapper<DongwulingyangEntity> wrapper);

	List<DongwulingyangView> selectListView(Pagination page,@Param("ew") Wrapper<DongwulingyangEntity> wrapper);
	
	DongwulingyangView selectView(@Param("ew") Wrapper<DongwulingyangEntity> wrapper);
	

}
