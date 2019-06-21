package crm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BaseServlet") 
public class BaseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		
		//1.
		String method = req.getParameter("method");
//		System.out.println(method);
		
		//2.
		//得到当前Servlet类的类对象
		Class c = this.getClass();
		//根据传入的方法名得到当否对象
		try {
			Method m = c.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			
//			System.out.println(m);
			//3.执行方法
			m.invoke(this, req,resp);
			
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
