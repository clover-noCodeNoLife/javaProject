package test.dao;

import java.util.List;

import test.book;

/**
 * 用于提供impl.bookService实现提供接口
 * @author Clover
 *
 */
public interface IBook {
	/**
	 * 插入操作
	 * @param book
	 */
	public int insert(book book);
	/**
	 * 删除操作
	 * @param book
	 */
	public int delete(book book);
	/**
	 * 更新操作
	 * @param book
	 */
	public int update(book book);
//	/**
//	 * 根据书籍名称模糊查询
//	 * @param title
//	 * @return
//	 */
//	public List<book> getBookByTitle(String title);
	/**
	 * 根据ISBN查询
	 * @param isbn
	 * @return 
	 */
	public book getBookByISBN(String isbn);
	/**
	 * 返回所有图书信息
	 * @return
	 */
	public List<book> getAll();
}
