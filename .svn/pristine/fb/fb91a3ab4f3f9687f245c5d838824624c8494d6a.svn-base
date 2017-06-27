package hitwh.fanghh.manage.module.base.web;

import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.IntegralLevelService;
import hitwh.fanghh.manage.pojo.building.IntegralLevel;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/integralLevel")
@SessionAttributes({ "user" })
public class IntegralLevelController {
	
	@Autowired
	private IntegralLevelService integralLevelService;
	@Autowired
	private ExtResponseJsonService responseService;

	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam Integer userLevel,
			@RequestParam Integer lowestStandard,@RequestParam Integer highestStandard) {
		IntegralLevel il = new IntegralLevel();
		il.setUserLevel(userLevel);
		il.setLowestStandard(lowestStandard);
		il.setHighestStandard(highestStandard);
		this.integralLevelService.add(il);
		return this.responseService.responseSuccess("添加成功");
	}
	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<IntegralLevel> list = 
				this.integralLevelService.getAll();
		return responseService.responseListMap(list);
	}


	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestBody List<IntegralLevel> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.integralLevelService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<IntegralLevel> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.integralLevelService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除成功");
	}
	
}
