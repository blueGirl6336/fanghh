package hitwh.fanghh.manage.web;

import java.util.List;

import hitwh.fanghh.manage.pojo.Module;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.service.ModuleService;
import hitwh.fanghh.manage.service.UserService;
import hitwh.fanghh.manage.util.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对登录进行处理
 * 
 * @author Miao
 */
@Controller
@SessionAttributes({ "user" })
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModuleService moduleService;

	//系统跳转登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView needLogin() {
		return new ModelAndView("login.jsp");
	}

	// 系统首页 根据登录情况和用户等级进行跳转
	@RequestMapping(value = { "/", "/index"}, method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView index(ModelMap modelMap) {
		if (modelMap == null || modelMap.get("user") == null) {
			return new ModelAndView("redirect:/login");
		}
		User user = (User) modelMap.get("user");
		String viewName = dispatchViewByRole(user);
		return new ModelAndView(viewName);
	}

	/**
	 * 完成权限到页面的映射
	 */
	private String dispatchViewByRole(User user) {
		/**
		 * 普通用户和开发人员跳转至admin页面
		 * 其他用户跳转到manage页面
		 */
		/**
		 * 2014年2月26日
		 * 普通用户和审核人员跳转至admin/client页面
		 * 管理员和开发人员跳转至manage/index页面
		 * 开发人员跳转至admin/index页面
		 */
		String role = user.getRole();
		// 无权限，未登录
		if (role == null || role.length() == 0)
			return "redirect:/login";
//		// 系统管理员
//		if (role.equals("1001001"))
//			return "redirect:/manage/index";
//		// 人事处处长
//		if (role.equals("1001002"))
//			return "redirect:/manage/index";
//		// 人事处职员
//		if (role.equals("1001003"))
//			return "redirect:/manage/index";
//		//开发人员
//		if (role.equals("1001005"))
//			return "redirect:/manage/index";
//		//审核人员
//		if (role.equals("1001006"))
//			return "redirect:/admin/client";
//		//学校领导
//		if (role.equals("1001007"))
//			return "redirect:/manage/index";
		// 普通用户和审核用户
		if (role.equals("1001004")||role.equals("1001006"))
			return "redirect:/admin/client";


		return "redirect:/manage/index";
	}

	/**
	 * 登录处理
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		ModelAndView view = new ModelAndView();

		String error = null;
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String code = request.getParameter("code");

		String str = (String) request.getSession().getAttribute("randomStr");
		
		//验证码校验
		//开发时可以把下面这段注释掉，避免每次输入验证码
		//在新的需求中，取消掉验证码机制 2014.06.09
//		if (!code.equalsIgnoreCase(str)) {
//			error = "验证码错误";
//			view.addObject("username", username);
//			view.addObject("password", password);
//			view.addObject("errorMessage", error);
//			view.setViewName("/login.jsp");
//			return view;
//		}

		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		
		// 验证登录
		int n = userService.checkLogin(u, RequestUtil.getIpAddr(request));
		switch (n) {
		case 1:
			User user = this.userService.getByUsername(username);
			modelMap.addAttribute(user);
			view.setViewName("redirect:/index");
			break;
		case -1:
			error = "用户不存在";
			view.addObject("username", username);
			view.addObject("errorMessage", error);
			view.setViewName("/login.jsp");
			break;
		case -2:
			error = "密码错误";
			view.addObject("username", username);
			view.addObject("errorMessage", error);
			view.setViewName("/login.jsp");
			break;
		case -3:
			error = "用户已停用";
			view.addObject("username", username);
			view.addObject("errorMessage", error);
			view.setViewName("/login.jsp");
			break;
		case -4:
			error = "账号密码错误次数到达上限，今日已锁定";
			view.addObject("username", username);
			view.addObject("errorMessage", error);
			view.setViewName("/login.jsp");
			break;
		case -5:
			error = "您的电脑密码错误次数到达上限，今日已锁定";
			view.addObject("username", username);
			view.addObject("errorMessage", error);
			view.setViewName("/login.jsp");
			break;

		default:
			error = "未知错误";
			view.addObject("user", u);
			view.addObject("errorMessage", error);
			view.setViewName("/login.jsp");
		}

		return view;
	}

	// 获取某个模块下所有的字典组
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		if (modelMap != null)
			modelMap.clear();
		ModelAndView view = new ModelAndView("redirect:/index");
		return view;
	}

	// 获取某个模块下所有的字典组
	@RequestMapping(value = "/testTile", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView testTile(ModelMap modelMap, HttpServletRequest request) {
		if (modelMap.get("user") == null) {
			return new ModelAndView("redirect:/index");
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("adminIndex.tls");
		User user = (User) modelMap.get("user");

		List<Module> mList = this.moduleService.getByRole(user.getRole(), 0, 0);
		view.addObject("modules", mList);
		return view;
	}

}
