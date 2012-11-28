package f.rd.paths.web.original;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class OneLockFilter implements Filter {
	
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("---------doFilter Before-----------");
		chain.doFilter(request, response);
		System.out.println("---------doFilter After-----------");
	}

	public void destroy() {

	}

}
