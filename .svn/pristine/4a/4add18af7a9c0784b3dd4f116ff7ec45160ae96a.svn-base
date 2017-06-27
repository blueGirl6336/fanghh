package hitwh.fanghh.manage.web;


import hitwh.fanghh.manage.pojo.ConfigBean;
import hitwh.fanghh.manage.service.ConfigBeanService;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 配置信息Controller
 * 
 * @author Michael Miao
 * @Date 2013-8-31
 */
@Controller
@RequestMapping(value = "manage/config")
public class ConfigBeanController {
	@Autowired
	private ConfigBeanService configBeanService;
	
	@Autowired
	private ExtResponseJsonService responseService;

	// 获取某个模块下所有的配置
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllModule() {
		List<ConfigBean> dicList = this.configBeanService.getAll();
		return this.responseService.responseListMap(dicList);
	}


	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateDictionary(
			@RequestBody List<ConfigBean> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.configBeanService.update(list.get(i));
		}
		return this.responseService.responseSuccess("更新成功");
	}
}
