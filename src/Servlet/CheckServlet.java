package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserServiceDao;
import Service.UserServiceDaoImpl;

/**
 * Servlet implementation class CheckName
 */
//@WebServlet(name = "CheckServlet", urlPatterns = "/CheckName")
public class CheckServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String value = request.getParameter("nickName");
			System.out.println(value);
			UserServiceDao us = new UserServiceDaoImpl();
			String s = null;
			try {
				boolean flag = us.checkName(value);
				if(flag) {
					 s = "true";
				}else {
					s = "false";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			PrintWriter pt = response.getWriter();
			pt.write(s);
			pt.close();
	}

}
