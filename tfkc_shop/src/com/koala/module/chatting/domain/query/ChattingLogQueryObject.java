package com.koala.module.chatting.domain.query;
import org.springframework.web.servlet.ModelAndView;

import com.koala.core.query.QueryObject;

public class ChattingLogQueryObject extends QueryObject {
	public ChattingLogQueryObject(String currentPage, ModelAndView mv,
			String orderBy, String orderType) {
		super(currentPage, mv, orderBy, orderType);
		// TODO Auto-generated constructor stub
	}
	public ChattingLogQueryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
}
