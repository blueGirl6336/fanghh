package hitwh.fanghh.manage.web;

import hitwh.fanghh.manage.pojo.Module;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.service.ModuleService;
import hitwh.fanghh.manage.service.UserService;
import hitwh.fanghh.manage.util.ExtResponseJsonService;
import hitwh.fanghh.manage.util.StringUtils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理页面Controller
 * 
 */
@Controller
@RequestMapping(value = "/admin")
@SessionAttributes({ "user" })
public class AdminController {

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private UserService userService;

	@Autowired
	private ExtResponseJsonService responseService;

	// 管理员首页
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView goIndex(ModelMap modelMap) {
		if (modelMap.get("user") == null) {
			return new ModelAndView("redirect:/login");
		}
		ModelAndView view = new ModelAndView();

		User user = (User) modelMap.get("user");
		String role = user.getRole();
		// 无权限，未登录
		if (role == null || role.length() == 0)
			return new ModelAndView("redirect:/login");
		// 普通用户
		if (role.equals("1001004"))
			return new ModelAndView("redirect:/admin/client");
		view.setViewName("adminIndex.tls");
		List<Module> mList = this.moduleService.getByRole(user.getRole(), 0, 0);
		view.addObject("modules", mList);

		return view;
	}

	// 普通用户首页
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView goToClientIndex(ModelMap modelMap,
			HttpServletRequest request) {
		if (modelMap.get("user") == null) {
			return new ModelAndView("redirect:/login");
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("clientIndex.tls");
		User user = (User) modelMap.get("user");

		List<Module> mList = this.moduleService.getByRole(user.getRole(), 0, 0);
		view.addObject("modules", mList);
		return view;
	}

	// 跳转到个人信息查看页面
	@RequestMapping(value = "/personalinfo", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView forwardToPersonalInfo(@ModelAttribute User user) {
		/*if (user != null && user.getEmpNo() != null
				&& user.getEmpNo().length() > 0)
			return new ModelAndView("redirect:/admin/info/" + user.getEmpNo());*/
		return new ModelAndView("redirect:/admin");
	}

	// 跳转到修改密码页面
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView goChangePass(@ModelAttribute User user) {
		List<Module> mList = this.moduleService.getByRole(user.getRole(), 0, 0);
		ModelAndView view = new ModelAndView("/admin/change_password.jsp");
		view.addObject("modules", mList);
		return view;
	}

	// 修改密码
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> changePassword(@ModelAttribute User user,
			@RequestParam String oldPass, @RequestParam String newPass,
			@RequestParam String newPassConf) {
		System.out.println(user.getUsername() + " " + oldPass + " " + newPass
				+ " " + newPassConf);
		String pass = StringUtils.encrypt_MD5(user.getUsername() + oldPass);
		if (!user.getPassword().equals(pass))
			return this.responseService.responseError("密码错误");
		if (!newPass.equals(newPassConf)) {
			return this.responseService.responseError("两次新密码不一致");
		}
		String newPassword = StringUtils.encrypt_MD5(user.getUsername()
				+ newPass);
		user.setPassword(newPassword);
		userService.update(user);
		return this.responseService.responseSuccess("修改成功");
	}
}
