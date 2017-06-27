package hitwh.fanghh.manage.web;

import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.service.UserService;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 对用户方面的操作进行处理
 * 
 * @author QIQI
 */
@Controller
@RequestMapping(value = "/manage/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ExtResponseJsonService responseService;

	// 获取所有的用户
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAllUser() {
		List<User> users = this.userService.getAllUser();
		return responseService.responseListMap(users);
	}

	// 按照真实姓名查询
	@RequestMapping(value = "/searchByRealName", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> searchByRealName(@RequestParam String realName) {
		List<User> users = new ArrayList<User>();
		if (realName == null || realName.length() == 0)
			users = this.userService.getAllUser();
		else
			users = this.userService.getByRealname("%"+realName+"%");
		return responseService.responseListMap(users);
	}

	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestBody List<User> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if (list.get(i).getId() == -1) {
				continue;
			}
			this.userService.add(list.get(i));
		}
		return this.responseService.responseSuccess("添加用户成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestBody List<User> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.userService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改用户成功");
	}

	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<User> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.userService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除用户成功");
	}

	// 用来修改用户的密码
	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateEmpNo(@RequestParam String username,
			@RequestParam String password) {
		int result = this.userService.resetPassword(username, password);
		if (result == 1) {
			return this.responseService.responseSuccess("操作成功！");
		} else {
			return this.responseService.responseError("操作失败，无此用户！");
		}
	}
}
