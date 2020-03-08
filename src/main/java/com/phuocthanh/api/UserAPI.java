package com.phuocthanh.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phuocthanh.service.IUserService;
import com.phuocthanh.service.impl.UserService;

@WebServlet("/user")
public class UserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private IUserService userService=new UserService();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper obj=new ObjectMapper();
		String action=request.getParameter("action");
		String roleCode=request.getParameter("roleCode");
		if(action!=null&&action.equals("LOAD_STAFF")&&roleCode!=null) {
			obj.writeValue(response.getOutputStream(), userService.findStaffs(roleCode));
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
