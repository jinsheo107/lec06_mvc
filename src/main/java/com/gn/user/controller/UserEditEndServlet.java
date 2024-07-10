package com.gn.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		System.out.println(pw + ", " + name);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
