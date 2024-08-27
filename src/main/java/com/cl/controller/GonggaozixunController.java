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

import com.cl.entity.GonggaozixunEntity;
import com.cl.entity.view.GonggaozixunView;

import com.cl.service.GonggaozixunService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 公告资讯
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
@RestController
@RequestMapping("/gonggaozixun")
public class GonggaozixunController {
    @Autowired
    private GonggaozixunService gonggaozixunService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GonggaozixunEntity gonggaozixun,
		HttpServletRequest request){
        EntityWrapper<GonggaozixunEntity> ew = new EntityWrapper<GonggaozixunEntity>();

		PageUtils page = gonggaozixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggaozixun), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GonggaozixunEntity gonggaozixun, 
		HttpServletRequest request){
        EntityWrapper<GonggaozixunEntity> ew = new EntityWrapper<GonggaozixunEntity>();

		PageUtils page = gonggaozixunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggaozixun), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GonggaozixunEntity gonggaozixun){
       	EntityWrapper<GonggaozixunEntity> ew = new EntityWrapper<GonggaozixunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gonggaozixun, "gonggaozixun")); 
        return R.ok().put("data", gonggaozixunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GonggaozixunEntity gonggaozixun){
        EntityWrapper< GonggaozixunEntity> ew = new EntityWrapper< GonggaozixunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gonggaozixun, "gonggaozixun")); 
		GonggaozixunView gonggaozixunView =  gonggaozixunService.selectView(ew);
		return R.ok("查询公告资讯成功").put("data", gonggaozixunView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GonggaozixunEntity gonggaozixun = gonggaozixunService.selectById(id);
		gonggaozixun = gonggaozixunService.selectView(new EntityWrapper<GonggaozixunEntity>().eq("id", id));
        return R.ok().put("data", gonggaozixun);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GonggaozixunEntity gonggaozixun = gonggaozixunService.selectById(id);
		gonggaozixun = gonggaozixunService.selectView(new EntityWrapper<GonggaozixunEntity>().eq("id", id));
        return R.ok().put("data", gonggaozixun);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GonggaozixunEntity gonggaozixun, HttpServletRequest request){
    	gonggaozixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonggaozixun);
        gonggaozixunService.insert(gonggaozixun);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GonggaozixunEntity gonggaozixun, HttpServletRequest request){
    	gonggaozixun.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gonggaozixun);
        gonggaozixunService.insert(gonggaozixun);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GonggaozixunEntity gonggaozixun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggaozixun);
        gonggaozixunService.updateById(gonggaozixun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gonggaozixunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
