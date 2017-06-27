package hitwh.fanghh.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域过滤器
 *
 * @author ZH
 * @date 2016-08-28-21:58
 */

public class CorsFilter implements Filter
{

	// 允许访问的客户端域名 多个域名用","隔开
	private String allowOrigin;
	// 允许访问的方法名，多个方法名用逗号分割
	private String allowMethods;
	// 是否允许请求带有验证信息
	private String allowCredentials;
	// 允许服务端访问的客户端请求头，多个请求头用逗号分割
	private String allowHeaders;
	// 允许客户端访问的服务端响应头，多个响应头用逗号分割
	private String exposeHeaders;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		allowOrigin = filterConfig.getInitParameter("allowOrigin");
		allowMethods = filterConfig.getInitParameter("allowMethods");
		allowCredentials = filterConfig.getInitParameter("allowCredentials");
		allowHeaders = filterConfig.getInitParameter("allowHeaders");
		exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (null != allowOrigin)
		{
			List<String> allowOriginList = Arrays.asList(allowOrigin.split(","));
			if (null != allowOriginList)
			{
				String currentOrigin = request.getHeader("Origin");
				if (allowOriginList.contains(currentOrigin))
				{
					response.setHeader("Access-Control-Allow-Origin", currentOrigin);
				}
			}
		}
		if (null != allowMethods)
		{
			response.setHeader("Access-Control-Allow-Methods", allowMethods);
		}
		if (null != allowCredentials)
		{
			response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
		}
		if (null != allowHeaders)
		{
			response.setHeader("Access-Control-Allow-Headers", allowHeaders);
		}
		if (null != exposeHeaders)
		{
			response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
		}
		chain.doFilter(req, res);
	}

	@Override
	public void destroy()
	{
	}

}