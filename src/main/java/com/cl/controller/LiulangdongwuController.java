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

import com.cl.entity.LiulangdongwuEntity;
import com.cl.entity.view.LiulangdongwuView;

import com.cl.service.LiulangdongwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 流浪动物
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
@RestController
@RequestMapping("/liulangdongwu")
public class LiulangdongwuController {
    @Autowired
    private LiulangdongwuService liulangdongwuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LiulangdongwuEntity liulangdongwu,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		liulangdongwu.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<LiulangdongwuEntity> ew = new EntityWrapper<LiulangdongwuEntity>();

		PageUtils page = liulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liulangdongwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LiulangdongwuEntity liulangdongwu, 
		HttpServletRequest request){
        EntityWrapper<LiulangdongwuEntity> ew = new EntityWrapper<LiulangdongwuEntity>();

		PageUtils page = liulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liulangdongwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LiulangdongwuEntity liulangdongwu){
       	EntityWrapper<LiulangdongwuEntity> ew = new EntityWrapper<LiulangdongwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( liulangdongwu, "liulangdongwu")); 
        return R.ok().put("data", liulangdongwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LiulangdongwuEntity liulangdongwu){
        EntityWrapper< LiulangdongwuEntity> ew = new EntityWrapper< LiulangdongwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( liulangdongwu, "liulangdongwu")); 
		LiulangdongwuView liulangdongwuView =  liulangdongwuService.selectView(ew);
		return R.ok("查询流浪动物成功").put("data", liulangdongwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(id);
		liulangdongwu.setClicktime(new Date());
		liulangdongwuService.updateById(liulangdongwu);
		liulangdongwu = liulangdongwuService.selectView(new EntityWrapper<LiulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", liulangdongwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(id);
		liulangdongwu.setClicktime(new Date());
		liulangdongwuService.updateById(liulangdongwu);
		liulangdongwu = liulangdongwuService.selectView(new EntityWrapper<LiulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", liulangdongwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LiulangdongwuEntity liulangdongwu, HttpServletRequest request){
    	liulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liulangdongwu);
    	liulangdongwu.setUserid((Long)request.getSession().getAttribute("userId"));
        liulangdongwuService.insert(liulangdongwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LiulangdongwuEntity liulangdongwu, HttpServletRequest request){
    	liulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liulangdongwu);
        liulangdongwuService.insert(liulangdongwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LiulangdongwuEntity liulangdongwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(liulangdongwu);
        liulangdongwuService.updateById(liulangdongwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        liulangdongwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,LiulangdongwuEntity liulangdongwu, HttpServletRequest request,String pre){
        EntityWrapper<LiulangdongwuEntity> ew = new EntityWrapper<LiulangdongwuEntity>();
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
		PageUtils page = liulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liulangdongwu), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,LiulangdongwuEntity liulangdongwu, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "dongwumingcheng";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "liulangdongwu").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<LiulangdongwuEntity> liulangdongwuList = new ArrayList<LiulangdongwuEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                liulangdongwuList.addAll(liulangdongwuService.selectList(new EntityWrapper<LiulangdongwuEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<LiulangdongwuEntity> ew = new EntityWrapper<LiulangdongwuEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = liulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liulangdongwu), params), params));
        List<LiulangdongwuEntity> pageList = (List<LiulangdongwuEntity>)page.getList();
        if(liulangdongwuList.size()<limit) {
            int toAddNum = (limit-liulangdongwuList.size())<=pageList.size()?(limit-liulangdongwuList.size()):pageList.size();
            for(LiulangdongwuEntity o1 : pageList) {
                boolean addFlag = true;
                for(LiulangdongwuEntity o2 : liulangdongwuList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    liulangdongwuList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(liulangdongwuList.size()>limit) {
            liulangdongwuList = liulangdongwuList.subList(0, limit);
        }
        page.setList(liulangdongwuList);
        return R.ok().put("data", page);
    }







}
