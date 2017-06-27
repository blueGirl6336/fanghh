package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.RegionService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Region;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

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
@RequestMapping(value = "manage/region")
@SessionAttributes({ "user" })
public class RegionController {
	@Autowired
	private RegionService regionService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	// 获取所有的物业类型
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<Region> region = 
				this.regionService.getAll();
		return responseService.responseListMap(region);
	}
	/**
	 * 搜索区域
	 * @param cityId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam Integer cityId)
	{
		List<Region> pList = new ArrayList<Region>();
		StringBuilder hql = new StringBuilder("select r from Region as r " +
				"where r.city.cityId = " + cityId );
		
		pList = this.regionService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<Region> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.regionService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<Region> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.regionService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<Region> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.regionService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
