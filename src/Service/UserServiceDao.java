package Service;

import entity.User;

public interface UserServiceDao {
	/**
	 * 验证用户登录
	 */
	User selectOne(String username,String password) throws Exception;
	
	/**
	 * 
	 * 检验用户名是否存在
	 */
	boolean checkName(String username) throws Exception;
}
