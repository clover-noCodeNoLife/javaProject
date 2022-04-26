package test.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import test.user;
import test.dao.IUser;

public class UserService implements IUser{
	private SQLHelper sqlHelper = null;
	public UserService() {
		sqlHelper = new SQLHelper();
	}
	
	@Override
	public user getUserByName(String username) {
		String sql= String.format("select * from t_user where userName='%s'", username);
		System.out.println(sql);
		ResultSet rs = sqlHelper.executeQuery(sql);
		user user = new user();
		try {
			if((rs!=null) && rs.next()) {
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassWord(rs.getString(3));
				user.setRole(rs.getString(4));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				//这里必须先关rs，再关stmt，最后关conn
				//所以把SQLHelper里的executeQuery的close()给注释，再在这里关
				rs.close();
				sqlHelper.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
