package com.koala.foundation.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.koala.core.constant.Globals;
import com.koala.core.domain.IdEntity;

/**
 * 
 * <p>
 * Title: GoodsSpecProperty.java
 * </p>
 * 
 * <p>
 * Description: 商品规格属性管理类，用来描述商品属性信息
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 沈阳网之商科技有限公司 www.koala.com
 * </p>
 * 
 * @author erikzhang
 * 
 * @date 2014-4-25
 * 
 * 
 * @version koala_b2b2c v2.0 2015版
 */
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = Globals.DEFAULT_TABLE_SUFFIX + "goodsspecproperty")
public class GoodsSpecProperty extends IdEntity {
	private int sequence;
	@Column(columnDefinition = "LongText")
	private String value;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Accessory specImage;
	@ManyToOne(fetch = FetchType.LAZY)
	private GoodsSpecification spec;
	@ManyToMany(mappedBy = "goods_specs")
	private List<Goods> goods_list = new ArrayList<Goods>();// 规格中所在商品
	@ManyToMany(mappedBy = "gsps")
	private List<GoodsCart> cart_list = new ArrayList<GoodsCart>();// 规格中所在商品购物车

	public GoodsSpecProperty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoodsSpecProperty(Long id, Date addTime) {
		super(id, addTime);
		// TODO Auto-generated constructor stub
	}

	public GoodsSpecProperty(Long id) {
		super.setId(id);
		// TODO Auto-generated constructor stub
	}

	public List<GoodsCart> getCart_list() {
		return cart_list;
	}

	public void setCart_list(List<GoodsCart> cart_list) {
		this.cart_list = cart_list;
	}

	public List<Goods> getGoods_list() {
		return goods_list;
	}

	public void setGoods_list(List<Goods> goods_list) {
		this.goods_list = goods_list;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Accessory getSpecImage() {
		return specImage;
	}

	public void setSpecImage(Accessory specImage) {
		this.specImage = specImage;
	}

	public GoodsSpecification getSpec() {
		return spec;
	}

	public void setSpec(GoodsSpecification spec) {
		this.spec = spec;
	}

}
