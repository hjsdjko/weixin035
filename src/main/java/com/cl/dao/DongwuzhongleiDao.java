package com.cl.dao;

import com.cl.entity.DongwuzhongleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongwuzhongleiView;


/**
 * 动物种类
 * 
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface DongwuzhongleiDao extends BaseMapper<DongwuzhongleiEntity> {
	
	List<DongwuzhongleiView> selectListView(@Param("ew") Wrapper<DongwuzhongleiEntity> wrapper);

	List<DongwuzhongleiView> selectListView(Pagination page,@Param("ew") Wrapper<DongwuzhongleiEntity> wrapper);
	
	DongwuzhongleiView selectView(@Param("ew") Wrapper<DongwuzhongleiEntity> wrapper);
	

}
