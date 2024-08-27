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


import com.cl.dao.DiscussliulangdongwuDao;
import com.cl.entity.DiscussliulangdongwuEntity;
import com.cl.service.DiscussliulangdongwuService;
import com.cl.entity.view.DiscussliulangdongwuView;

@Service("discussliulangdongwuService")
public class DiscussliulangdongwuServiceImpl extends ServiceImpl<DiscussliulangdongwuDao, DiscussliulangdongwuEntity> implements DiscussliulangdongwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussliulangdongwuEntity> page = this.selectPage(
                new Query<DiscussliulangdongwuEntity>(params).getPage(),
                new EntityWrapper<DiscussliulangdongwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussliulangdongwuEntity> wrapper) {
		  Page<DiscussliulangdongwuView> page =new Query<DiscussliulangdongwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussliulangdongwuView> selectListView(Wrapper<DiscussliulangdongwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussliulangdongwuView selectView(Wrapper<DiscussliulangdongwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
