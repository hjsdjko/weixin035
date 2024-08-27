package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LiulangdongwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LiulangdongwuView;


/**
 * 流浪动物
 *
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface LiulangdongwuService extends IService<LiulangdongwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiulangdongwuView> selectListView(Wrapper<LiulangdongwuEntity> wrapper);
   	
   	LiulangdongwuView selectView(@Param("ew") Wrapper<LiulangdongwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiulangdongwuEntity> wrapper);
   	

}

