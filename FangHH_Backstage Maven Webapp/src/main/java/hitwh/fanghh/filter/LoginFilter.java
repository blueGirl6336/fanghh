package hitwh.fanghh.filter;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hitwh.fanghh.bean.UserBean;
import hitwh.fanghh.manager.LoginManager;
import hitwh.fanghh.service.UserService;

@Component
public class LoginFilter implements Filter
{
	@Autowired
	private LoginManager loginManager;
	@Autowired
	private UserService userService;

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse res = (HttpServletResponse) arg1;

		HttpSession session = req.getSession(true);

		// 列外uri，用于允许加载登陆界面
		final String[] containStrings =
		{ "/index.html", "template/login.html", "/user/getCheckCode", ".css", ".js", ".map" };

		String uri = req.getRequestURI().toLowerCase();

		if (loginManager.checkRegister() || uriContains(containStrings, uri))
		{
			arg2.doFilter(req, res);
		} else
		{
			// res.sendRedirect(req.getContextPath() + "/index.html");
			// 为方便调试，强制使用此用户登录：userName：lk password：1234567

			String userName = "lk", password = "1234567";
			userService.getCheckCode(100, 100, 1);
			String checkCode = session.getAttribute("checkCode").toString();
			UserBean result = userService.loginWithUserName(userName, password, checkCode);
			System.out.println("auto login userName:" + userName + " result:" + result.getLoginResult());
			arg2.doFilter(req, res);

		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	private boolean uriContains(String[] containStrings, String uri)
	{
		for (String containString : containStrings)
		{
			if (uri.contains(containString.toLowerCase()))
			{
				return true;
			}
		}
		return false;
	}

}
