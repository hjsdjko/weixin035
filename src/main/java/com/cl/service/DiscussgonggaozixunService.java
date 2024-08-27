package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussgonggaozixunEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussgonggaozixunView;


/**
 * 公告资讯评论表
 *
 * @author 
 * @email 
 * @date 2024-04-06 19:19:17
 */
public interface DiscussgonggaozixunService extends IService<DiscussgonggaozixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgonggaozixunView> selectListView(Wrapper<DiscussgonggaozixunEntity> wrapper);
   	
   	DiscussgonggaozixunView selectView(@Param("ew") Wrapper<DiscussgonggaozixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgonggaozixunEntity> wrapper);
   	

}

