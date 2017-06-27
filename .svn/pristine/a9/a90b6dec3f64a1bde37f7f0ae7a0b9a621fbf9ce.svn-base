package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.DeveloperService;
import hitwh.fanghh.manage.module.base.service.PropertyService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Developer;
import hitwh.fanghh.manage.pojo.building.Property;
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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/property")
@SessionAttributes({ "user" })
public class PropertyController {
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	
	/**
	 * 搜索物业信息 楼盘id
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> searchByBuildingId(@RequestParam Integer buildingId)
	{
		List<Property> pList = new ArrayList<Property>();
		StringBuilder hql = new StringBuilder("select p from Property as p " +
				"where p.building.buildingId = " + buildingId );
		
		pList = this.propertyService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	
	/**
	 * 搜索物业信息 楼盘名称
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/searchByBuildingName", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> searchByBuildingId(@RequestParam String buildingName)
	{
		List<Property> pList = new ArrayList<Property>();
		StringBuilder hql = new StringBuilder("select p from Property as p " +
				"where p.building.buildingName like '%" + buildingName + "%'" );
		pList = this.propertyService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<Property> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.propertyService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<Property> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.propertyService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<Property> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.propertyService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
