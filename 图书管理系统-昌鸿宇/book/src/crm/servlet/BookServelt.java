package crm.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import crm.daomin.Book;
import crm.service.BookService;
import crm.service.Impl.BookServiceImpl;
import crm.utils.CommonUtils;

@WebServlet("/bookServlet")
public class BookServelt extends BaseServlet {
	BookService service = new BookServiceImpl();
	
	public void addsubmit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行了adds方法");
		response.setContentType("text/html;charset=utf-8");
		Book book = new Book();
		//获取参数
		book.setBid(CommonUtils.getUUID());
		DateConverter trans = new DateConverter();
		trans.setPatterns(new String[] {"yyyy-MM-dd","yyyy/MM/dd"});
		ConvertUtils.register(trans, Date.class);
		
		try {
			BeanUtils.copyProperties(book, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		book.setRealBookname(request.getParameter("bookname"));
		String realbookname = book.getRealBookname();
		System.out.println(realbookname);
		
		int count = service.selectBookByName(realbookname);
		System.out.println(count);
		if (count!=0) {
			book.setRealBookname(realbookname);
			book.setBookname(realbookname+"("+(count+1)+")");
			
		}else {
			book.setRealBookname(realbookname);
			book.setBookname(realbookname);
		}
		DecimalFormat df = new DecimalFormat("######0.00");
		book.setPrice(Double.parseDouble(df.format(book.getPrice())));
		
		System.out.println(book);
		boolean result = service.addBook(book);
		HttpSession session = request.getSession();
		session.setAttribute("book", book);
		System.out.println(book.getBid());
		if (result) {
			response.sendRedirect("jsp/success.jsp");
		}
	
	}
	public void addpage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.sendRedirect("jsp/book/add.jsp");
	}
	
	public void showBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		BookService service = new BookServiceImpl();
		List<Book> books = service.showAllBooks();
		System.out.println(books);
		session.setAttribute("books", books);
		response.sendRedirect("jsp/book/list.jsp");
	}
	
	public void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("hdhhjh");
		String bid = request.getParameter("bid");
		boolean result = service.deleteBook(bid);
		if (result) {
			showBookList(request, response);
		}
		
	}
	
	public void updatePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.sendRedirect("jsp/book/edit.jsp");
		String bid = request.getParameter("bid");
		HttpSession session = request.getSession();
		session.setAttribute("bid", bid);
	}
	
	public void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("执行了up方法");
		response.setContentType("text/html;charset=utf-8");
		
		Book book = new Book();
		//获取参数
		HttpSession session = request.getSession();
		book.setBid((String)session.getAttribute("bid"));
		DateConverter trans = new DateConverter();
		trans.setPatterns(new String[] {"yyyy-MM-dd","yyyy/MM/dd"});
		ConvertUtils.register(trans, Date.class);
		
		try {
			BeanUtils.copyProperties(book, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(book);
		boolean result = service.updateBook(book);
		session.setAttribute("book", book);
		System.out.println(book.getBid());
		if (result) {
			response.sendRedirect("jsp/success.jsp");
		}
	
	}

}
