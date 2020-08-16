package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听Session生命周期相关的事件
 *
 */
@WebListener
public class MySessonListener implements HttpSessionListener {

	/**
     * 当监听Session对象被创建，则会执行该方法
     */
    public void sessionCreated(HttpSessionEvent se)  { 
        //获取ServletContext.5
    	ServletContext sc = se.getSession().getServletContext();
    	
    	//在ServletContext中绑定一个人数, 通过 count  
    	//尝试从ServletContext中获取count
    	Object count = sc.getAttribute("count");
    	if(count == null) {
    		//第一个用户上线
    		sc.setAttribute("count", 1);
    	}else {
    		sc.setAttribute("count",(Integer)count+1);
    	}
    }

	/**
     * 当监听到Session对象被销毁，则会执行该方法
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        
    }
	
}
