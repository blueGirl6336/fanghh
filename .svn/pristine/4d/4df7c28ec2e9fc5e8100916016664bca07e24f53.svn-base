package hitwh.fanghh.manage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(true);
		
		String uri = req.getRequestURI().toLowerCase();
		
		if(uri.contains(".jpg") || uri.contains(".js") || uri.contains(".css")){
			chain.doFilter(request, response);
			return;
		}
		
		// 从session里取的用户名信息
		Object obj = session.getAttribute("user");
		// 判断如果没有取到用户信息,就跳转到登陆页面
		if (obj == null) {
			// 跳转到登陆页
			res.sendRedirect("/hrms/login");
			return;
		} else {
			chain.doFilter(request, response);
		}
	}
	public void destroy() {
	}
}
