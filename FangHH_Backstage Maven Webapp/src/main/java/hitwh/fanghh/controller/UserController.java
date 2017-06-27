package hitwh.fanghh.controller;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hitwh.fanghh.bean.UserBean;
import hitwh.fanghh.service.UserService;
import hitwh.fanghh.util.ResponseMapUtil;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;

	/**
	 * 用户登陆（使用用户名）
	 *
	 * @Title: loginWithUserName
	 * @version:
	 * @author: ZY
	 * 
	 * @param userName用户名
	 * @param password密码
	 * @param checkCode验证码
	 * @return
	 */
	@RequestMapping("/loginWithUserName")
	@ResponseBody
	public Map<String, Object> loginWithUserName(@RequestParam String userName, @RequestParam String password,
			@RequestParam String checkCode)
	{
		UserBean userBean = userService.loginWithUserName(userName, password, checkCode);
		switch (userBean.getLoginResult())
		{
		case 0:
			return ResponseMapUtil.responseError("用户名/密码错误！");
		case 1:
		case 2:
			return ResponseMapUtil.responseSuccess(userBean);
		case 3:
			return ResponseMapUtil.responseError("验证码错误！");
		default:
			return ResponseMapUtil.responseError("未知登录错误！");
		}
	}

	/**
	 * 用户登出
	 *
	 * @Title: logout
	 * @version:
	 * @author: ZY
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public Map<String, Object> logout()
	{
		boolean res = userService.logout();
		if (!res)
			return ResponseMapUtil.responseError("登出失败");
		else
			return ResponseMapUtil.responseSuccess(res);
	}

	/**
	 * 获取验证码图片，此接口将直接返回图片信息
	 *
	 * @Title: getCheckCode
	 * @version:
	 * @author: ZY
	 * 
	 * @param request
	 * @param response
	 * @param width图片宽度
	 * @param height图片高度
	 * @param stringSize字体大小
	 */
	@RequestMapping("/getCheckCode")
	public void getCheckCode(HttpServletRequest request, HttpServletResponse response, @RequestParam int width,
			@RequestParam int height, @RequestParam int stringSize)
	{
		ByteArrayOutputStream byteArrayOutputStream = userService.getCheckCode(width, height, stringSize);
		try
		{
			int contentLength = byteArrayOutputStream.size();
			response.setHeader("content-length", contentLength + "");
			response.getOutputStream().write(byteArrayOutputStream.toByteArray());// 将内存中的图片通过流动形式输出
			response.setContentType("image/png");// 设置相应类型,告诉浏览器输出的内容为图片
			response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Set-Cookie", "name=value; HttpOnly");// 设置HttpOnly属性,防止Xss攻击
			response.setDateHeader("Expire", 0);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
}
