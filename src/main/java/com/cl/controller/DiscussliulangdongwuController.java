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

import com.cl.entity.DiscussliulangdongwuEntity;
import com.cl.entity.view.DiscussliulangdongwuView;

import com.cl.service.DiscussliulangdongwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 流浪动物评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
@RestController
@RequestMapping("/discussliulangdongwu")
public class DiscussliulangdongwuController {
    @Autowired
    private DiscussliulangdongwuService discussliulangdongwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussliulangdongwuEntity discussliulangdongwu,
		HttpServletRequest request){
        EntityWrapper<DiscussliulangdongwuEntity> ew = new EntityWrapper<DiscussliulangdongwuEntity>();

		PageUtils page = discussliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussliulangdongwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussliulangdongwuEntity discussliulangdongwu, 
		HttpServletRequest request){
        EntityWrapper<DiscussliulangdongwuEntity> ew = new EntityWrapper<DiscussliulangdongwuEntity>();

		PageUtils page = discussliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussliulangdongwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussliulangdongwuEntity discussliulangdongwu){
       	EntityWrapper<DiscussliulangdongwuEntity> ew = new EntityWrapper<DiscussliulangdongwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussliulangdongwu, "discussliulangdongwu")); 
        return R.ok().put("data", discussliulangdongwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussliulangdongwuEntity discussliulangdongwu){
        EntityWrapper< DiscussliulangdongwuEntity> ew = new EntityWrapper< DiscussliulangdongwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussliulangdongwu, "discussliulangdongwu")); 
		DiscussliulangdongwuView discussliulangdongwuView =  discussliulangdongwuService.selectView(ew);
		return R.ok("查询流浪动物评论表成功").put("data", discussliulangdongwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussliulangdongwuEntity discussliulangdongwu = discussliulangdongwuService.selectById(id);
		discussliulangdongwu = discussliulangdongwuService.selectView(new EntityWrapper<DiscussliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", discussliulangdongwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussliulangdongwuEntity discussliulangdongwu = discussliulangdongwuService.selectById(id);
		discussliulangdongwu = discussliulangdongwuService.selectView(new EntityWrapper<DiscussliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", discussliulangdongwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussliulangdongwuEntity discussliulangdongwu, HttpServletRequest request){
    	discussliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussliulangdongwu);
        discussliulangdongwuService.insert(discussliulangdongwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussliulangdongwuEntity discussliulangdongwu, HttpServletRequest request){
    	discussliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussliulangdongwu);
        discussliulangdongwuService.insert(discussliulangdongwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussliulangdongwuEntity discussliulangdongwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussliulangdongwu);
        discussliulangdongwuService.updateById(discussliulangdongwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussliulangdongwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussliulangdongwuEntity discussliulangdongwu, HttpServletRequest request,String pre){
        EntityWrapper<DiscussliulangdongwuEntity> ew = new EntityWrapper<DiscussliulangdongwuEntity>();
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
		PageUtils page = discussliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussliulangdongwu), params), params));
        return R.ok().put("data", page);
    }








}
