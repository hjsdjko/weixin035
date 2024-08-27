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


import com.cl.dao.DiscussgonggaozixunDao;
import com.cl.entity.DiscussgonggaozixunEntity;
import com.cl.service.DiscussgonggaozixunService;
import com.cl.entity.view.DiscussgonggaozixunView;

@Service("discussgonggaozixunService")
public class DiscussgonggaozixunServiceImpl extends ServiceImpl<DiscussgonggaozixunDao, DiscussgonggaozixunEntity> implements DiscussgonggaozixunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgonggaozixunEntity> page = this.selectPage(
                new Query<DiscussgonggaozixunEntity>(params).getPage(),
                new EntityWrapper<DiscussgonggaozixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgonggaozixunEntity> wrapper) {
		  Page<DiscussgonggaozixunView> page =new Query<DiscussgonggaozixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussgonggaozixunView> selectListView(Wrapper<DiscussgonggaozixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgonggaozixunView selectView(Wrapper<DiscussgonggaozixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
