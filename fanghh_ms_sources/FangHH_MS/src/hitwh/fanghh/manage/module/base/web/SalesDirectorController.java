package hitwh.fanghh.manage.module.base.web;

import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.SalesDirectorService;
import hitwh.fanghh.manage.pojo.building.SalesDirector;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/salesDirector")
@SessionAttributes({ "user" })
public class SalesDirectorController {
	
	@Autowired
	private SalesDirectorService salesDirectorService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<SalesDirector> list = 
				this.salesDirectorService.getAll();
		return responseService.responseListMap(list);
	}


	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestBody List<SalesDirector> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.salesDirectorService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<SalesDirector> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.salesDirectorService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除成功");
	}
	
}
