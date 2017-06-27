package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.BuildingPropertyTypeService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.BuildingPropertyType;
import hitwh.fanghh.manage.pojo.building.Unit;
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
@RequestMapping(value = "manage/buildingPropertyType")
@SessionAttributes({ "user" })
public class BuildingPropertyTypeController {
	@Autowired
	private BuildingPropertyTypeService buildingPropertyTypeService ;
	@Autowired
	private ExtResponseJsonService responseService;
	
	// 获取所有的物业类型
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<BuildingPropertyType> buildingPropertyType = 
				this.buildingPropertyTypeService.getAll();
		return responseService.responseListMap(buildingPropertyType);
	}
	/**
	 * 搜索物业类型
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> search(@RequestParam Integer buildingId)
	{
		List<BuildingPropertyType> pList = new ArrayList<BuildingPropertyType>();
		StringBuilder hql = new StringBuilder("select b from BuildingPropertyType as b " +
				"where b.building.buildingId = " + buildingId );
		
		pList = this.buildingPropertyTypeService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<BuildingPropertyType> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.buildingPropertyTypeService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<BuildingPropertyType> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.buildingPropertyTypeService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<BuildingPropertyType> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.buildingPropertyTypeService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
