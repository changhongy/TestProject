package crm.dao;

import java.sql.SQLException;
import java.util.List;

import crm.daomin.Book;

public interface BookDAO {
	//新增图书
	public int insertBook(Book c)throws SQLException;
	
	//显示图书列表
	public List<Book> findAllBooks()throws SQLException;
	
	//删除图书
	public int deleteBook(String bid)throws SQLException;
	
	//修改图书 
	public int updateBook(Book c)throws SQLException;
	
	//通过姓名查询图书
	public int selectBookByName(String realbookname)throws SQLException;
}
