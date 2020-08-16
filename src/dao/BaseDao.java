package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.apache.commons.beanutils.BeanUtils;

import utils.JDBCutils;

public class BaseDao<T> {
	/**
	 * 根据条件查询用户
	 * @param <T>
	 */
	public static <T> T getUserOne(Class<T> classz,String sql,Object...args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCutils.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for(int i = 0;i < args.length;i++) {
				preparedStatement.setObject(i+1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			//获取元数据
			ResultSetMetaData metaData = resultSet.getMetaData();
			//通过元数据获取结果集的列数
			int columnCount = metaData.getColumnCount();
			if(resultSet.next()) {
				T t = classz.newInstance();
				for(int x = 1; x <= columnCount; x++) {
					//获取列名
					String colName = metaData.getColumnLabel(x);
					
					//获取列值
					Object colValue = resultSet.getObject(x);
					
					//赋值
					BeanUtils.setProperty(t, colName, colValue);
				}
				return t;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutils.closeAll(connection, preparedStatement, resultSet);
		}
		
		return null;
	}
	
	/**
	 * 检验用户是否存在
	 */
	
}
