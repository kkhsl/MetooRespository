package com.koala.foundation.domain.query;
import org.springframework.web.servlet.ModelAndView;

import com.koala.core.query.QueryObject;

public class SubjectQueryObject extends QueryObject {
	public SubjectQueryObject(String currentPage, ModelAndView mv,
			String orderBy, String orderType) {
		super(currentPage, mv, orderBy, orderType);
		// TODO Auto-generated constructor stub
	}
	public SubjectQueryObject(String construct, String currentPage,
			ModelAndView mv, String orderBy, String orderType) {
		super(construct, currentPage, mv, orderBy, orderType);
		// TODO Auto-generated constructor stub
	}
	public SubjectQueryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
}
