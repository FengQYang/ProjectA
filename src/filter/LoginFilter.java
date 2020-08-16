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
		//��¼У��
		HttpServletRequest request =  (HttpServletRequest)req;
		HttpServletResponse	response =(HttpServletResponse)resp;
		String methodName = request.getParameter("method");
		String uri = request.getRequestURI();
		System.out.println(uri);
		//System.out.println("URL:" + request.getRequestURL());
		if(uri.contains("Login")||uri.contains("Register") || (methodName != null  && methodName.equals("Login"))) {
			//�͵�¼,ע����ص���Դ��ֱ�ӷ���
			chain.doFilter(request, response);
		}else {
			//�͵�¼�޹ص���Դ
			Object user = request.getSession().getAttribute("username");
			if(user == null) {
				//���ڵ�¼״̬,��ת��Login.jsp
				response.sendRedirect("/ProjectA/Login.jsp");
			}else {
				//�ڵ�¼״̬��ֱ�ӷ���
				chain.doFilter(request, response);
			}
		}
	}

}
