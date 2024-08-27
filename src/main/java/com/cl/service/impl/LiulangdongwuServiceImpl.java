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


import com.cl.dao.LiulangdongwuDao;
import com.cl.entity.LiulangdongwuEntity;
import com.cl.service.LiulangdongwuService;
import com.cl.entity.view.LiulangdongwuView;

@Service("liulangdongwuService")
public class LiulangdongwuServiceImpl extends ServiceImpl<LiulangdongwuDao, LiulangdongwuEntity> implements LiulangdongwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiulangdongwuEntity> page = this.selectPage(
                new Query<LiulangdongwuEntity>(params).getPage(),
                new EntityWrapper<LiulangdongwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiulangdongwuEntity> wrapper) {
		  Page<LiulangdongwuView> page =new Query<LiulangdongwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LiulangdongwuView> selectListView(Wrapper<LiulangdongwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiulangdongwuView selectView(Wrapper<LiulangdongwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
