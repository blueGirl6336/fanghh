package hitwh.fanghh.manage.filter;

import hitwh.fanghh.manage.pojo.User;

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

public class ManageAuthFilter  implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(true);

		// 从session里取的用户名信息
		Object obj = session.getAttribute("user");
		// 判断如果没有取到用户信息,就跳转到登陆页面
		if (obj == null) {
			// 跳转到登陆页
			res.sendRedirect("/hrms/login");
		} else {
			User user = (User)session.getAttribute("user");
			String role = user.getRole();
			if(role == null || role.length() == 0 )
				// 跳转到登陆页
				res.sendRedirect("/hrms_whzy/login");
			if(role.equals("1010900")) //普通用户
				res.sendRedirect("/hrms_whzy/admin/client");
			
			chain.doFilter(request, response);
		}
	}
	public void destroy() {
	}
}