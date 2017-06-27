package hitwh.fanghh.manage.web;

import hitwh.fanghh.manage.service.SystemSettingService;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统设置
 */
@Controller
@RequestMapping(value = "/manage/system")
public class SystemController {
	@Autowired
	private SystemSettingService systemSettingService;
	
	//@Autowired
	//private PersonBaseInfoService personBaseInfoService;

	@Autowired
	private ExtResponseJsonService responseService;

	// 打开个人信息审核功能
	@RequestMapping(value = "/openSelfModify", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> openSelfModify() {
		this.systemSettingService.openSelfModify();
		return this.responseService.responseSuccess("开启成功");
	}

	// 关闭个人信息审核功能
	@RequestMapping(value = "/closeSelfModify", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> closeSelfModify() {
		this.systemSettingService.closeSelfModigy();
		return this.responseService.responseSuccess("关闭成功");
	}
	
	/**
	 * 将所有的人添加到用户中
	 * 
	 * @return
	 *//*
	@RequestMapping(value = "/addAllPerson2User", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addAllPerson2User() {
		int count = this.personBaseInfoService.addAllPersonToUser();
		return this.responseService.responseSuccess("新建用户:"+count);
	}
*/
	/**
	 * 维持登录状态，接受心跳包
	 * @return
	 */
	@RequestMapping(value = "/continueLogin", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> continueLogin() {
		return this.responseService.responseSuccess("done");
	}
	
}
