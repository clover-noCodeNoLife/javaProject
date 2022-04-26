package test.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.book;
import test.dao.IBook;

public class BookService implements IBook {
	private SQLHelper sqlHelper;
	public BookService() {
		sqlHelper = new SQLHelper();
	}
	/**
	 * 添加操作，成功返回大于0的整型值。-1代表失败
	 * @param book
	 */
	public int insert(book book) {
		String sql = String.format("insert into t_book(isbn,title,auther,unitPrice,num)values('%s','%s','%s',%f,%d)", 
				book.getIsbn(),book.getTitle(),book.getAuther(),book.getUnitPrice(),book.getNum());
		System.out.println(sql);
		
		int result = sqlHelper.execute(sql);
		return result;
		
	}
	/**
	 * 更新操作
	 */
	public int update(book book) {
		String sql = String.format("update t_book set isbn='%s',title='%s',auther='%s',unitPrice=%d,num=%d where id=%id", 
				book.getIsbn(),book.getTitle(),book.getAuther(),book.getUnitPrice(),book.getNum(),book.getId());
		int result = sqlHelper.execute(sql);
		return result;
	}
	/**
	 * 删除操作
	 */
	public int delete(book book) {
		String sql=String.format("delete from t_book where id=%d", book.getId());
		int result = sqlHelper.execute(sql);
		return result;
	}
	/**
	 * 获取全部图书
	 */
	public List<book> getAll(){
		
		List<book> books = new ArrayList<book>();
		String sql = "select * from t_book";
		ResultSet rs = sqlHelper.executeQuery(sql);
		if(rs!=null) {
			try {
				while(rs.next()) {
					book book= new book();
					book.setId(rs.getInt(1));
					book.setIsbn(rs.getString(2));
					book.setTitle(rs.getString(3));
					book.setAuther(rs.getString(4));
					book.setUnitPrice(rs.getDouble(5));
					book.setNum(rs.getInt(6));
					
					books.add(book);
				}

			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return null;
			}
			finally {
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
		return books;

	}
	/**
	 * 根据isbn查询图书
	 */
	public book getBookByISBN(String isbn) {
		String sql = String.format("select * from t_book where isbn='%s'", isbn);
		ResultSet rs = sqlHelper.executeQuery(sql);
		book book= new book();
			try {
				
				if(rs!=null && rs.next()) {
				
					book.setId(rs.getInt(1));
					book.setIsbn(rs.getString(2));
					book.setTitle(rs.getString(3));
					book.setAuther(rs.getString(4));
					book.setUnitPrice(rs.getDouble(5));
					book.setNum(rs.getInt(6));
					
				}
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
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
			return book;
	}
}
