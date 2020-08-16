package dao;

import org.apache.tomcat.util.buf.UEncoder;

import entity.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUser(String username, String password) throws Exception {
		String sql = "select id , username, password from user where username = ? and Password = ?";
		Object[] arg = {username ,password};
		return getUserOne(User.class, sql, arg);
	}

	@Override
	public boolean getUserOne(String username) throws Exception {
		String sql = "select username from user where username = ?";
		Object[] arg = {username};
		boolean flag = false;
		User user = getUserOne(User.class, sql, arg);
		System.out.println(user);
		//返回true说明该用户可以注册
		if(user == null) {
			flag = true;
			return flag;
		}
		return flag;
	}

	

}
