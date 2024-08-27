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


import com.cl.dao.DongwuzhongleiDao;
import com.cl.entity.DongwuzhongleiEntity;
import com.cl.service.DongwuzhongleiService;
import com.cl.entity.view.DongwuzhongleiView;

@Service("dongwuzhongleiService")
public class DongwuzhongleiServiceImpl extends ServiceImpl<DongwuzhongleiDao, DongwuzhongleiEntity> implements DongwuzhongleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DongwuzhongleiEntity> page = this.selectPage(
                new Query<DongwuzhongleiEntity>(params).getPage(),
                new EntityWrapper<DongwuzhongleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DongwuzhongleiEntity> wrapper) {
		  Page<DongwuzhongleiView> page =new Query<DongwuzhongleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DongwuzhongleiView> selectListView(Wrapper<DongwuzhongleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DongwuzhongleiView selectView(Wrapper<DongwuzhongleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
