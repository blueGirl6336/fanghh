package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.CityService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.City;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/city")
@SessionAttributes({ "user" })
public class CityController {
	@Autowired
	private CityService cityService;
	@Autowired
	private ExtResponseJsonService responseService;

	// 获取选中的城市
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> search(@RequestParam String cityName) {
		if (cityName == null || "".equals(cityName))
			return responseService.responseError("城市名为空");
		StringBuilder hql = new StringBuilder(
				" from City as c where cityName like '%" + cityName + "%'");
		List<City> city = this.cityService.searchByHql(hql.toString());
		return responseService.responseListMap(city);
	}

	// 获取所有的城市
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<City> city = this.cityService.getAll();
		return responseService.responseListMap(city);
	}

	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user,
			@RequestBody List<City> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {

			this.cityService.add(list.get(i));
		}
		return this.responseService.responseSuccess("添加成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user,
			@RequestBody List<City> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.cityService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user,
			@RequestBody List<City> list) {
		int size = list.size();
		try {
			for (int i = 0; i < size; i++) {
				this.cityService.delete(list.get(i));
			}
		} catch (Exception e) {
			return this.responseService.responseError("删除失败");
		}
		return this.responseService.responseSuccess("删除成功");
	}
}
