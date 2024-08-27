package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 流浪动物
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-06 19:19:16
 */
@TableName("liulangdongwu")
public class LiulangdongwuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LiulangdongwuEntity() {
		
	}
	
	public LiulangdongwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 动物名称
	 */
					
	private String dongwumingcheng;
	
	/**
	 * 照片
	 */
					
	private String zhaopian;
	
	/**
	 * 动物种类
	 */
					
	private String dongwuzhonglei;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 年龄
	 */
					
	private String nianling;
	
	/**
	 * 精神状态
	 */
					
	private String jingshenzhuangtai;
	
	/**
	 * 身体状况
	 */
					
	private String shentizhuangkuang;
	
	/**
	 * 是否健康
	 */
					
	private String shifoujiankang;
	
	/**
	 * 发现地点
	 */
					
	private String faxiandidian;
	
	/**
	 * 发现时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date faxianshijian;
	
	/**
	 * 动物详情
	 */
					
	private String dongwuxiangqing;
	
	/**
	 * 领养状态
	 */
					
	private String lingyangzhuangtai;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 用户id
	 */
					
	private Long userid;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：动物名称
	 */
	public void setDongwumingcheng(String dongwumingcheng) {
		this.dongwumingcheng = dongwumingcheng;
	}
	/**
	 * 获取：动物名称
	 */
	public String getDongwumingcheng() {
		return dongwumingcheng;
	}
	/**
	 * 设置：照片
	 */
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	/**
	 * 获取：照片
	 */
	public String getZhaopian() {
		return zhaopian;
	}
	/**
	 * 设置：动物种类
	 */
	public void setDongwuzhonglei(String dongwuzhonglei) {
		this.dongwuzhonglei = dongwuzhonglei;
	}
	/**
	 * 获取：动物种类
	 */
	public String getDongwuzhonglei() {
		return dongwuzhonglei;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
	/**
	 * 设置：精神状态
	 */
	public void setJingshenzhuangtai(String jingshenzhuangtai) {
		this.jingshenzhuangtai = jingshenzhuangtai;
	}
	/**
	 * 获取：精神状态
	 */
	public String getJingshenzhuangtai() {
		return jingshenzhuangtai;
	}
	/**
	 * 设置：身体状况
	 */
	public void setShentizhuangkuang(String shentizhuangkuang) {
		this.shentizhuangkuang = shentizhuangkuang;
	}
	/**
	 * 获取：身体状况
	 */
	public String getShentizhuangkuang() {
		return shentizhuangkuang;
	}
	/**
	 * 设置：是否健康
	 */
	public void setShifoujiankang(String shifoujiankang) {
		this.shifoujiankang = shifoujiankang;
	}
	/**
	 * 获取：是否健康
	 */
	public String getShifoujiankang() {
		return shifoujiankang;
	}
	/**
	 * 设置：发现地点
	 */
	public void setFaxiandidian(String faxiandidian) {
		this.faxiandidian = faxiandidian;
	}
	/**
	 * 获取：发现地点
	 */
	public String getFaxiandidian() {
		return faxiandidian;
	}
	/**
	 * 设置：发现时间
	 */
	public void setFaxianshijian(Date faxianshijian) {
		this.faxianshijian = faxianshijian;
	}
	/**
	 * 获取：发现时间
	 */
	public Date getFaxianshijian() {
		return faxianshijian;
	}
	/**
	 * 设置：动物详情
	 */
	public void setDongwuxiangqing(String dongwuxiangqing) {
		this.dongwuxiangqing = dongwuxiangqing;
	}
	/**
	 * 获取：动物详情
	 */
	public String getDongwuxiangqing() {
		return dongwuxiangqing;
	}
	/**
	 * 设置：领养状态
	 */
	public void setLingyangzhuangtai(String lingyangzhuangtai) {
		this.lingyangzhuangtai = lingyangzhuangtai;
	}
	/**
	 * 获取：领养状态
	 */
	public String getLingyangzhuangtai() {
		return lingyangzhuangtai;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}

}
