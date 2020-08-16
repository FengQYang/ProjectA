package Test;

import org.junit.Test;

import Service.UserServiceDao;
import Service.UserServiceDaoImpl;
import dao.BaseDao;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class TestUser {
	
	@Test
	public void Test1() {
		//BaseDao<User> baseDao =  new BaseDao<User>();
		UserServiceDao userServiceDao =  new UserServiceDaoImpl();
		String sql = "select id , username, password from user where username = ? and Password = ?";
		String username = "∑Á«Â—Ô";
		String password = "2536";
		Object[] arg = {username ,password};
		//System.out.println(baseDao.getUserOne(User.class, sql, arg));
		try {
			System.out.println(userServiceDao.selectOne(username, password));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void Test2() {
		BaseDao<User> bs = new BaseDao<User>();
		String sql = "select username from user where username = ?";
		Object[] arg = {"lisi"};
		User userOne = BaseDao.getUserOne(User.class, sql, arg);
		System.out.println(userOne);
	}
	
	@Test
	public void Test3() {
		UserDao us = new UserDaoImpl();
		try {
			boolean flag = us.getUserOne("lisi");
			System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
