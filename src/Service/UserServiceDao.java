package Service;

import entity.User;

public interface UserServiceDao {
	/**
	 * ��֤�û���¼
	 */
	User selectOne(String username,String password) throws Exception;
	
	/**
	 * 
	 * �����û����Ƿ����
	 */
	boolean checkName(String username) throws Exception;
}
