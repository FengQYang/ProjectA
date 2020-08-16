package Servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Messg;

@WebServlet(name = "BaseServlet",urlPatterns = "/base")
public class BaseServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String methodName = req.getParameter("method");
		try {
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			Object Stringvalue = method.invoke(this, req,resp);
			if(Stringvalue != null && Stringvalue instanceof String) {
					String str = (String) Stringvalue;
					if(str.startsWith(Messg.REDIRECT)) {
						String path = str.substring(8);
						resp.sendRedirect(path);
					}else {
						String path = str.substring(7);
						req.getRequestDispatcher(path).forward(req, resp);
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
