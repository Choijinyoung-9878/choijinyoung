package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class EmailConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.confirmEmail(memail);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("eMailConfirmResult", "중복된 Email 입니다." );
		} else {
			request.setAttribute("eMailConfirmResult", "사용가능한 Email 입니다");
		}
	}

}
