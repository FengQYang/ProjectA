package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ����Session����������ص��¼�
 *
 */
@WebListener
public class MySessonListener implements HttpSessionListener {

	/**
     * ������Session���󱻴��������ִ�и÷���
     */
    public void sessionCreated(HttpSessionEvent se)  { 
        //��ȡServletContext.5
    	ServletContext sc = se.getSession().getServletContext();
    	
    	//��ServletContext�а�һ������, ͨ�� count  
    	//���Դ�ServletContext�л�ȡcount
    	Object count = sc.getAttribute("count");
    	if(count == null) {
    		//��һ���û�����
    		sc.setAttribute("count", 1);
    	}else {
    		sc.setAttribute("count",(Integer)count+1);
    	}
    }

	/**
     * ��������Session�������٣����ִ�и÷���
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        
    }
	
}
