package com.koala.foundation.service.impl;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import com.koala.core.query.PageObject;
import com.koala.core.query.support.IPageList;
import com.koala.core.query.support.IQueryObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.koala.core.dao.IGenericDAO;
import com.koala.core.query.GenericPageList;
import com.koala.foundation.domain.OrderFormLog;
import com.koala.foundation.service.IOrderFormLogService;

@Service
@Transactional
public class OrderFormLogServiceImpl implements IOrderFormLogService{
	@Resource(name = "orderFormLogDAO")
	private IGenericDAO<OrderFormLog> orderFormLogDao;
	
	public boolean save(OrderFormLog orderFormLog) {
		/**
		 * init other field here
		 */
		try {
			this.orderFormLogDao.save(orderFormLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public OrderFormLog getObjById(Long id) {
		OrderFormLog orderFormLog = this.orderFormLogDao.get(id);
		if (orderFormLog != null) {
			return orderFormLog;
		}
		return null;
	}
	
	public boolean delete(Long id) {
		try {
			this.orderFormLogDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean batchDelete(List<Serializable> orderFormLogIds) {
		// TODO Auto-generated method stub
		for (Serializable id : orderFormLogIds) {
			delete((Long) id);
		}
		return true;
	}
	
	public IPageList list(IQueryObject properties) {
		if (properties == null) {
			return null;
		}
		String query = properties.getQuery();
		String construct = properties.getConstruct();
		Map params = properties.getParameters();
		GenericPageList pList = new GenericPageList(OrderFormLog.class,construct, query,
				params, this.orderFormLogDao);
		if (properties != null) {
			PageObject pageObj = properties.getPageObj();
			if (pageObj != null)
				pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
						.getCurrentPage(), pageObj.getPageSize() == null ? 0
						: pageObj.getPageSize());
		} else
			pList.doList(0, -1);
		return pList;
	}
	
	public boolean update(OrderFormLog orderFormLog) {
		try {
			this.orderFormLogDao.update( orderFormLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	public List<OrderFormLog> query(String query, Map params, int begin, int max){
		return this.orderFormLogDao.query(query, params, begin, max);
		
	}
}
