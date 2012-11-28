package f.rd.paths.web.original;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneLockServlet extends HttpServlet {
	
	private String myName;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("--------------------");
		System.out.println("----------doGet----------");
		System.out.println(this.myName);
		System.out.println("--------------------");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("--------------------");
		System.out.println("----------doPost----------");
		System.out.println(this.myName);
		System.out.println("--------------------");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("--------------------");
		System.out.println("----------service----------");
		System.out.println(name);
		System.out.println(this.getInitParameter("myName"));
		System.out.println("--------------------");
	}

	private static final long serialVersionUID = 1L;

}
