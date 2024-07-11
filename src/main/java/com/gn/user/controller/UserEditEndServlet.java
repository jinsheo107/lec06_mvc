package com.gn.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gn.user.service.UserService;
import com.gn.user.vo.User;

@WebServlet(name = "userEditEnd", urlPatterns = "/user/editEnd")
public class UserEditEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserEditEndServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pw = request.getParameter("user_pw");
		String name = request.getParameter("user_name");
		
		HttpSession session = request.getSession(false);
		
		int user_no = -1;
		
		if(session != null) {
			User u = (User)session.getAttribute("user");
			request.setAttribute("user", u);
			user_no = u.getUser_no();
		}
		
		int result = new UserService().editUser(pw, name, user_no);
		
		if(result > 0) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
