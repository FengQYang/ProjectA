package Servlet;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserServiceDao;
import Service.UserServiceDaoImpl;
import entity.User;
import utils.Messg;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet  extends BaseServlet{
	
	/**
	 * 用户登录
	 */
	public String Login(HttpServletRequest req,HttpServletResponse resp) throws Exception {
		String username = req.getParameter("nickName");
		String password = req.getParameter("nickPassword");
		System.out.println(username + "---" + password);
		
		UserServiceDao userServiceDao =  new UserServiceDaoImpl();
		User user = userServiceDao.selectOne(username, password);
		System.out.println(user);
		
		if(user == null) {
			//req.getRequestDispatcher("/Login.jsp").forward(req, resp);
			return Messg.FORWORD + "/Login.jsp";
		}else {
			req.getSession().setAttribute("username", user);
			//req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return Messg.REDIRECT + "/ProjectA/index.jsp";
		} 
		
	} 
	
	/**
	 * 检验用户是否存在
	 */
	public void CheckUser(HttpServletRequest request,HttpServletResponse response) {
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
			PrintWriter pt = response.getWriter();
			pt.write(s);
			pt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
