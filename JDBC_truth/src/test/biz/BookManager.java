package test.biz;

import java.util.List;

import test.book;
import test.Impl.BookService;
import test.dao.IBook;

public class BookManager {
	IBook bookDao = new BookService();
	/**
	 * 图书入库操作
	 * @return 
	 */
	public boolean enterBook(book book) {
		int result = bookDao.insert(book);
		return result!=-1;
	}
	/**
	 * 图书出库操作
	 * @param isbn 书号
	 * @return true 成功 false 失败
	 */
	public boolean outBook(String isbn) {
		book book = bookDao.getBookByISBN(isbn);
		if(book!=null) {
			int result = bookDao.delete(book);
			return result!=-1;

		}
		return false;
	}
	/**
	 * 获取所有图书信息
	 * @return
	 */
	public List<book> getAllBook(){
		return bookDao.getAll();
	}
	
	public book getBookByIsbn(String isbn) {
		return bookDao.getBookByISBN(isbn);
	}
}
