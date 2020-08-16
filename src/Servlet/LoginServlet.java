package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserServiceDao;
import Service.UserServiceDaoImpl;
import entity.User;
import utils.JDBCutils;

/**
 * 处理请求的Servlet
 * @author 78520
 *
 */
public class LoginServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String username = req.getParameter("nickName");
			String password = req.getParameter("nickPassword");
			System.out.println(username + "---" + password);
			
			UserServiceDao userServiceDao =  new UserServiceDaoImpl();
			try {
				User user = userServiceDao.selectOne(username, password);
				System.out.println(user);
				if(user == null) {
					req.getRequestDispatcher("/Login.jsp").forward(req, resp);
				}else {
					req.getSession().setAttribute("name", user);
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
