package crm.dao.Impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import crm.dao.BookDAO;
import crm.daomin.Book;
import crm.utils.CommonUtils;
import crm.utils.DataSourceUtils;

public class BookDAOImpl implements BookDAO{
	
	//增加图书
	@Override
	public int insertBook(Book c) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into bookinfo(bid,bookname,bookcategory,uptime,price,hot,realbookname) values(?,?,?,?,?,?,?);";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Object []obj = {CommonUtils.getUUID(),c.getBookname(),c.getBookcategory(),df.format(c.getUptime()),c.getPrice(),Math.random()*100,c.getRealBookname()};
		int result = runner.update(sql,obj);
		return result;
	}

	//查询所有图书用于列表显示
	@Override
	public List<Book> findAllBooks() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from bookinfo order by hot desc;";
		List<Book> books = runner.query(sql, new BeanListHandler<>(Book.class));
		return books;
	}

	//删除图书
	@Override
	public int deleteBook(String bid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from bookinfo where bid = ?";
		int result = runner.update(sql,bid);
		return result;
	}
	
	//更新图书
	@Override
	public int updateBook(Book c) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update bookinfo set bookname=?,bookcategory=?,uptime=?,price=? where bid=?;";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Object []obj = {c.getBookname(),c.getBookcategory(),df.format(c.getUptime()),c.getPrice(),c.getBid()};
		int result = runner.update(sql,obj);
		return result;
	}


	//通过真实书名查询图书
	@Override
	public int selectBookByName(String realBookname) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from bookinfo where realbookname= ?;";
		long result = (long) runner.query(sql, new ScalarHandler(),realBookname);
		return (int)result;
	}


}
