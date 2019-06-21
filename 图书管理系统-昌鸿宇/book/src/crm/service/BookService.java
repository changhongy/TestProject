package crm.service;

import java.util.List;

import crm.daomin.Book;


public interface BookService {
	public boolean addBook(Book c);
	public List<Book> showAllBooks();
	public boolean deleteBook(String bid);
	public boolean updateBook(Book c);
	public int selectBookByName(String name);
}
