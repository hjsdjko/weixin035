package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DiscussgonggaozixunEntity;
import com.cl.entity.view.DiscussgonggaozixunView;

import com.cl.service.DiscussgonggaozixunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 公告资讯评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 19:19:17
 */
@RestController
@RequestMapping("/discussgonggaozixun")
public class DiscussgonggaozixunController {
    @Autowired
    private DiscussgonggaozixunService discussgonggaozixunService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussgonggaozixunEntity discussgonggaozixun,
		HttpServletRequest request){
        EntityWrapper<DiscussgonggaozixunEntity> ew = new EntityWrapper<DiscussgonggaozixunEntity>();

		PageUtils page = discussgonggaozixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgonggaozixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussgonggaozixunEntity discussgonggaozixun, 
		HttpServletRequest request){
        EntityWrapper<DiscussgonggaozixunEntity> ew = new EntityWrapper<DiscussgonggaozixunEntity>();

		PageUtils page = discussgonggaozixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgonggaozixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussgonggaozixunEntity discussgonggaozixun){
       	EntityWrapper<DiscussgonggaozixunEntity> ew = new EntityWrapper<DiscussgonggaozixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussgonggaozixun, "discussgonggaozixun")); 
        return R.ok().put("data", discussgonggaozixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussgonggaozixunEntity discussgonggaozixun){
        EntityWrapper< DiscussgonggaozixunEntity> ew = new EntityWrapper< DiscussgonggaozixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussgonggaozixun, "discussgonggaozixun")); 
		DiscussgonggaozixunView discussgonggaozixunView =  discussgonggaozixunService.selectView(ew);
		return R.ok("查询公告资讯评论表成功").put("data", discussgonggaozixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussgonggaozixunEntity discussgonggaozixun = discussgonggaozixunService.selectById(id);
		discussgonggaozixun = discussgonggaozixunService.selectView(new EntityWrapper<DiscussgonggaozixunEntity>().eq("id", id));
        return R.ok().put("data", discussgonggaozixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussgonggaozixunEntity discussgonggaozixun = discussgonggaozixunService.selectById(id);
		discussgonggaozixun = discussgonggaozixunService.selectView(new EntityWrapper<DiscussgonggaozixunEntity>().eq("id", id));
        return R.ok().put("data", discussgonggaozixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussgonggaozixunEntity discussgonggaozixun, HttpServletRequest request){
    	discussgonggaozixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussgonggaozixun);
        discussgonggaozixunService.insert(discussgonggaozixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussgonggaozixunEntity discussgonggaozixun, HttpServletRequest request){
    	discussgonggaozixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussgonggaozixun);
        discussgonggaozixunService.insert(discussgonggaozixun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussgonggaozixunEntity discussgonggaozixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussgonggaozixun);
        discussgonggaozixunService.updateById(discussgonggaozixun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussgonggaozixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussgonggaozixunEntity discussgonggaozixun, HttpServletRequest request,String pre){
        EntityWrapper<DiscussgonggaozixunEntity> ew = new EntityWrapper<DiscussgonggaozixunEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussgonggaozixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgonggaozixun), params), params));
        return R.ok().put("data", page);
    }








}
