package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DongwuzhongleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongwuzhongleiView;


/**
 * 动物种类
 *
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface DongwuzhongleiService extends IService<DongwuzhongleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongwuzhongleiView> selectListView(Wrapper<DongwuzhongleiEntity> wrapper);
   	
   	DongwuzhongleiView selectView(@Param("ew") Wrapper<DongwuzhongleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongwuzhongleiEntity> wrapper);
   	

}

