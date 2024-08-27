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

import com.cl.entity.DongwuzhongleiEntity;
import com.cl.entity.view.DongwuzhongleiView;

import com.cl.service.DongwuzhongleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 动物种类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
@RestController
@RequestMapping("/dongwuzhonglei")
public class DongwuzhongleiController {
    @Autowired
    private DongwuzhongleiService dongwuzhongleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DongwuzhongleiEntity dongwuzhonglei,
		HttpServletRequest request){
        EntityWrapper<DongwuzhongleiEntity> ew = new EntityWrapper<DongwuzhongleiEntity>();

		PageUtils page = dongwuzhongleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwuzhonglei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DongwuzhongleiEntity dongwuzhonglei, 
		HttpServletRequest request){
        EntityWrapper<DongwuzhongleiEntity> ew = new EntityWrapper<DongwuzhongleiEntity>();

		PageUtils page = dongwuzhongleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwuzhonglei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DongwuzhongleiEntity dongwuzhonglei){
       	EntityWrapper<DongwuzhongleiEntity> ew = new EntityWrapper<DongwuzhongleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dongwuzhonglei, "dongwuzhonglei")); 
        return R.ok().put("data", dongwuzhongleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DongwuzhongleiEntity dongwuzhonglei){
        EntityWrapper< DongwuzhongleiEntity> ew = new EntityWrapper< DongwuzhongleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dongwuzhonglei, "dongwuzhonglei")); 
		DongwuzhongleiView dongwuzhongleiView =  dongwuzhongleiService.selectView(ew);
		return R.ok("查询动物种类成功").put("data", dongwuzhongleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DongwuzhongleiEntity dongwuzhonglei = dongwuzhongleiService.selectById(id);
		dongwuzhonglei = dongwuzhongleiService.selectView(new EntityWrapper<DongwuzhongleiEntity>().eq("id", id));
        return R.ok().put("data", dongwuzhonglei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DongwuzhongleiEntity dongwuzhonglei = dongwuzhongleiService.selectById(id);
		dongwuzhonglei = dongwuzhongleiService.selectView(new EntityWrapper<DongwuzhongleiEntity>().eq("id", id));
        return R.ok().put("data", dongwuzhonglei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DongwuzhongleiEntity dongwuzhonglei, HttpServletRequest request){
    	dongwuzhonglei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwuzhonglei);
        dongwuzhongleiService.insert(dongwuzhonglei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DongwuzhongleiEntity dongwuzhonglei, HttpServletRequest request){
    	dongwuzhonglei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwuzhonglei);
        dongwuzhongleiService.insert(dongwuzhonglei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DongwuzhongleiEntity dongwuzhonglei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dongwuzhonglei);
        dongwuzhongleiService.updateById(dongwuzhonglei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dongwuzhongleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
