package dao;

import entity.User;

public interface UserDao {
	/**
	 * 
	 * 根据用户名和密码查询用户
	 */
	 User getUser(String username,String password) throws Exception;
	 
	 /**
	      * 检验用户是否存在
	  */
	 boolean getUserOne(String username) throws Exception;
}
