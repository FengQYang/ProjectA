package dao;

import entity.User;

public interface UserDao {
	/**
	 * 
	 * �����û����������ѯ�û�
	 */
	 User getUser(String username,String password) throws Exception;
	 
	 /**
	      * �����û��Ƿ����
	  */
	 boolean getUserOne(String username) throws Exception;
}
