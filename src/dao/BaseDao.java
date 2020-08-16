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
	 * ����������ѯ�û�
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
			//��ȡԪ����
			ResultSetMetaData metaData = resultSet.getMetaData();
			//ͨ��Ԫ���ݻ�ȡ�����������
			int columnCount = metaData.getColumnCount();
			if(resultSet.next()) {
				T t = classz.newInstance();
				for(int x = 1; x <= columnCount; x++) {
					//��ȡ����
					String colName = metaData.getColumnLabel(x);
					
					//��ȡ��ֵ
					Object colValue = resultSet.getObject(x);
					
					//��ֵ
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
	 * �����û��Ƿ����
	 */
	
}
