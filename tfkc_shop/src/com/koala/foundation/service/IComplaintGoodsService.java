﻿package com.koala.foundation.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.koala.core.query.support.IPageList;
import com.koala.core.query.support.IQueryObject;

import com.koala.foundation.domain.ComplaintGoods;

public interface IComplaintGoodsService {
	/**
	 * 保存一个ComplaintGoods，如果保存成功返回true，否则返回false
	 * 
	 * @param instance
	 * @return 是否保存成功
	 */
	boolean save(ComplaintGoods instance);
	
	/**
	 * 根据一个ID得到ComplaintGoods
	 * 
	 * @param id
	 * @return
	 */
	ComplaintGoods getObjById(Long id);
	
	/**
	 * 删除一个ComplaintGoods
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Long id);
	
	/**
	 * 批量删除ComplaintGoods
	 * 
	 * @param ids
	 * @return
	 */
	boolean batchDelete(List<Serializable> ids);
	
	/**
	 * 通过一个查询对象得到ComplaintGoods
	 * 
	 * @param properties
	 * @return
	 */
	IPageList list(IQueryObject properties);
	
	/**
	 * 更新一个ComplaintGoods
	 * 
	 * @param id
	 *            需要更新的ComplaintGoods的id
	 * @param dir
	 *            需要更新的ComplaintGoods
	 */
	boolean update(ComplaintGoods instance);
	/**
	 * 
	 * @param query
	 * @param params
	 * @param begin
	 * @param max
	 * @return
	 */
	List<ComplaintGoods> query(String query, Map params, int begin, int max);
}
