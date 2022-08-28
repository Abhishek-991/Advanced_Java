

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CheckFilter
 */
@WebFilter("/checklog")
public class CheckFilter implements Filter {


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String us=request.getParameter("tus");
		String pa=request.getParameter("tpa");
		
		if(us.equals("MSU")&&pa.equals("JAVA"))
		{
			chain.doFilter(request, response); //call sevlet with same url

		}
		else {
			PrintWriter pw=response.getWriter();
			pw.write("SORRY!! YOU ARE UNAUTHORISED USER.....");
		}
		
		
		
	
	
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
