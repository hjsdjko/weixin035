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


import com.cl.dao.DongwulingyangDao;
import com.cl.entity.DongwulingyangEntity;
import com.cl.service.DongwulingyangService;
import com.cl.entity.view.DongwulingyangView;

@Service("dongwulingyangService")
public class DongwulingyangServiceImpl extends ServiceImpl<DongwulingyangDao, DongwulingyangEntity> implements DongwulingyangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DongwulingyangEntity> page = this.selectPage(
                new Query<DongwulingyangEntity>(params).getPage(),
                new EntityWrapper<DongwulingyangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DongwulingyangEntity> wrapper) {
		  Page<DongwulingyangView> page =new Query<DongwulingyangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DongwulingyangView> selectListView(Wrapper<DongwulingyangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DongwulingyangView selectView(Wrapper<DongwulingyangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
