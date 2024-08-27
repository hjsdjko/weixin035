package com.cl.entity.view;

import com.cl.entity.DongwulingyangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 动物领养
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
@TableName("dongwulingyang")
public class DongwulingyangView  extends DongwulingyangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DongwulingyangView(){
	}
 
 	public DongwulingyangView(DongwulingyangEntity dongwulingyangEntity){
 	try {
			BeanUtils.copyProperties(this, dongwulingyangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
