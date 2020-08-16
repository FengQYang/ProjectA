package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//登录校验
		HttpServletRequest request =  (HttpServletRequest)req;
		HttpServletResponse	response =(HttpServletResponse)resp;
		String methodName = request.getParameter("method");
		String uri = request.getRequestURI();
		System.out.println(uri);
		//System.out.println("URL:" + request.getRequestURL());
		if(uri.contains("Login")||uri.contains("Register") || (methodName != null  && methodName.equals("Login"))) {
			//和登录,注册相关的资源，直接放行
			chain.doFilter(request, response);
		}else {
			//和登录无关的资源
			Object user = request.getSession().getAttribute("username");
			if(user == null) {
				//不在登录状态,跳转到Login.jsp
				response.sendRedirect("/ProjectA/Login.jsp");
			}else {
				//在登录状态，直接放行
				chain.doFilter(request, response);
			}
		}
	}

}
