package com.koala.foundation.domain.query;

import org.springframework.web.servlet.ModelAndView;

import com.koala.core.query.QueryObject;

public class RoleQueryObject extends QueryObject {

	public RoleQueryObject(String currentPage, ModelAndView mv, String orderBy,
			String orderType) {
		super(currentPage, mv, orderBy, orderType);
		// TODO Auto-generated constructor stub
	}

	public RoleQueryObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleQueryObject(String construct, String currentPage,
			ModelAndView mv, String orderBy, String orderType) {
		super(construct, currentPage, mv, orderBy, orderType);
		// TODO Auto-generated constructor stub
	}


}
