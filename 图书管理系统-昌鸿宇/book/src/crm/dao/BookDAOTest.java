package crm.dao;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import crm.dao.Impl.BookDAOImpl;
import crm.daomin.Book;
import junit.framework.TestCase;

/**  
* 文件名:BookDAOTest.java
* @version:1.0.0.0
* @author:cp 
* @see
* @since
* Company www.igeekhome.com
*/
class BookDAOTest {
	BookDAO dao = new BookDAOImpl();

	/**
	 * Test method for {@link crm.dao.BookDAO#insertBook(crm.daomin.Book)}.
	 * @throws SQLException 
	 */
	@Test
	void testInsertBook() throws SQLException {
//		Book book = new Book(null,"概率论","数学",new Date(),50.21);
		Book book = new Book(null,"音乐鉴赏","艺术",new Date(),70.21);
		int result = dao.insertBook(book);
		TestCase.assertTrue(result==1);
		
	}

	/**
	 * Test method for {@link crm.dao.BookDAO#findAllBooks()}.
	 * @throws SQLException 
	 */
	@Test
	void testFindAllBooks() throws SQLException {
		List<Book> books = dao.findAllBooks();
		System.out.println(books);
		TestCase.assertTrue(books!=null);
	}

	/**
	 * Test method for {@link crm.dao.BookDAO#deleteBook(java.lang.String)}.
	 * @throws SQLException 
	 */
	@Test
	void testDeleteBook() throws SQLException {
		String bid = "14dda956917d";
		int result = dao.deleteBook(bid);
		TestCase.assertTrue(result==1);
	}

	

}
