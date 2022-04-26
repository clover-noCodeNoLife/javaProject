package test.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import test.tool.tool;

public class SQLHelper {
	private Connection conn = null;
	private Statement stmt = null;
	/**
	 * 加载jdbc驱动，并创建MYSQL数据库连接
	 * @return true:代表连接成功
	 */
	public boolean open() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			
			tool.showMessage("加载数据库驱动失败:"+e.getMessage());
			return false;
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/mybook","root","123456");
		} catch (SQLException e) {
			
			tool.showMessage("数据库连接失败："+e.getMessage());
			return false;
		}
		
		return true;
	}
	
	/**
	 * 用于数据库查询工作
	 * @param sql
	 * @return ResultSet结果集
	 */
	public ResultSet executeQuery(String sql) {
		try {
			open();
			stmt = conn.prepareStatement(sql);
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			tool.showMessage("数据操作失败："+e.getMessage());
			return null;
		}finally {
//			close();
		}
	}
	
	public int execute(String sql) {
		
		try {
			open();
			stmt = conn.prepareStatement(sql);
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			tool.showMessage("数据操作失败："+e.getMessage());
			return -1;
		}finally {
			close();
		}
	}
	public void close() {
		
			try {
				if(conn!=null) conn.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				tool.showMessage("释放数据库数据失败："+e.getMessage());
			}
	}
}
