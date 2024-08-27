package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.GonggaozixunDao;
import com.cl.entity.GonggaozixunEntity;
import com.cl.service.GonggaozixunService;
import com.cl.entity.view.GonggaozixunView;

@Service("gonggaozixunService")
public class GonggaozixunServiceImpl extends ServiceImpl<GonggaozixunDao, GonggaozixunEntity> implements GonggaozixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GonggaozixunEntity> page = this.selectPage(
                new Query<GonggaozixunEntity>(params).getPage(),
                new EntityWrapper<GonggaozixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GonggaozixunEntity> wrapper) {
		  Page<GonggaozixunView> page =new Query<GonggaozixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GonggaozixunView> selectListView(Wrapper<GonggaozixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GonggaozixunView selectView(Wrapper<GonggaozixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
