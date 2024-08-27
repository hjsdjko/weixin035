package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GonggaozixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GonggaozixunView;


/**
 * 公告资讯
 *
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
public interface GonggaozixunService extends IService<GonggaozixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GonggaozixunView> selectListView(Wrapper<GonggaozixunEntity> wrapper);
   	
   	GonggaozixunView selectView(@Param("ew") Wrapper<GonggaozixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GonggaozixunEntity> wrapper);
   	

}

