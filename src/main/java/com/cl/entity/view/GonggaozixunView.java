package com.cl.entity.view;

import com.cl.entity.GonggaozixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 公告资讯
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
@TableName("gonggaozixun")
public class GonggaozixunView  extends GonggaozixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GonggaozixunView(){
	}
 
 	public GonggaozixunView(GonggaozixunEntity gonggaozixunEntity){
 	try {
			BeanUtils.copyProperties(this, gonggaozixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
