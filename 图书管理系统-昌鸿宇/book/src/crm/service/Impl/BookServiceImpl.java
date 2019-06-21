package crm.service.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.ObjectUtils.Null;

import crm.dao.BookDAO;
import crm.dao.Impl.BookDAOImpl;
import crm.daomin.Book;
import crm.service.BookService;

public class BookServiceImpl implements BookService{
	BookDAO dao = new BookDAOImpl();

	/**
	* 方法名:addBook
	* @param c
	* @return
	* @since
	* @see crm.service.BookService#addBook(crm.daomin.Book)
	*/
	@Override
	public boolean addBook(Book c) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = dao.insertBook(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result==1;
	}
	/**
	* 方法名:showAllBooks
	* @return
	* @since
	* @see crm.service.BookService#showAllBooks()
	*/
	@Override
	public List<Book> showAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books = null;
		try {
			books = dao.findAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	/**
	* 方法名:updateBook
	* @param c
	* @return
	* @since
	* @see crm.service.BookService#updateBook(crm.daomin.Book)
	*/
	@Override
	public boolean updateBook(Book c) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = dao.updateBook(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result==1;
	}
	/**
	* 方法名:deleteBook
	* @param bid
	* @return
	* @since
	* @see crm.service.BookService#deleteBook(java.lang.String)
	*/
	@Override
	public boolean deleteBook(String bid) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = dao.deleteBook(bid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result==1;
	}
	/**
	* 方法名:selectBookByName
	* @param name
	* @return
	* @since
	* @see crm.service.BookService#selectBookByName(java.lang.String)
	*/
	@Override
	public int selectBookByName(String name) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = dao.selectBookByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
