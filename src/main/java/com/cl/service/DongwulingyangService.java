package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DongwulingyangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongwulingyangView;


/**
 * 动物领养
 *
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface DongwulingyangService extends IService<DongwulingyangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongwulingyangView> selectListView(Wrapper<DongwulingyangEntity> wrapper);
   	
   	DongwulingyangView selectView(@Param("ew") Wrapper<DongwulingyangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongwulingyangEntity> wrapper);
   	

}

