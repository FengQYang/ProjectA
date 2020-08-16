package Service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class UserServiceDaoImpl implements UserServiceDao {
	UserDao userdao = new UserDaoImpl();
	@Override
	public User selectOne(String username, String password) throws Exception {
		
		return userdao.getUser(username, password);
	}
	@Override
	public boolean checkName(String username) throws Exception {
		boolean flag = userdao.getUserOne(username);
		return flag;
	}

}
