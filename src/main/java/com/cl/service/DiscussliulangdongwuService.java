package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussliulangdongwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussliulangdongwuView;


/**
 * 流浪动物评论表
 *
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface DiscussliulangdongwuService extends IService<DiscussliulangdongwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussliulangdongwuView> selectListView(Wrapper<DiscussliulangdongwuEntity> wrapper);
   	
   	DiscussliulangdongwuView selectView(@Param("ew") Wrapper<DiscussliulangdongwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussliulangdongwuEntity> wrapper);
   	

}

