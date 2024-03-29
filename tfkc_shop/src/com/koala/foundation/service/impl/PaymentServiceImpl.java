package com.koala.foundation.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koala.core.dao.IGenericDAO;
import com.koala.core.query.GenericPageList;
import com.koala.core.query.PageObject;
import com.koala.core.query.support.IPageList;
import com.koala.core.query.support.IQueryObject;
import com.koala.foundation.domain.Payment;
import com.koala.foundation.service.IPaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
	@Resource(name = "paymentDAO")
	private IGenericDAO<Payment> paymentDao;

	public boolean save(Payment payment) {
		/**
		 * init other field here
		 */
		try {
			this.paymentDao.save(payment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Payment getObjById(Long id) {
		Payment payment = this.paymentDao.get(id);
		if (payment != null) {
			return payment;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.paymentDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> paymentIds) {
		// TODO Auto-generated method stub
		for (Serializable id : paymentIds) {
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
		GenericPageList pList = new GenericPageList(Payment.class, construct,query,
				params, this.paymentDao);
		if (properties != null) {
			PageObject pageObj = properties.getPageObj();
			if (pageObj != null)
				pList.doList(
						pageObj.getCurrentPage() == null ? 0 : pageObj
								.getCurrentPage(),
						pageObj.getPageSize() == null ? 0 : pageObj
								.getPageSize());
		} else
			pList.doList(0, -1);
		return pList;
	}

	public boolean update(Payment payment) {
		try {
			this.paymentDao.update(payment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Payment> query(String query, Map params, int begin, int max) {
		return this.paymentDao.query(query, params, begin, max);

	}

	@Override
	public Payment getObjByProperty(String construct, String propertyName,
			String value) {
		// TODO Auto-generated method stub
		return this.paymentDao.getBy(construct, propertyName, value);
	}
}
