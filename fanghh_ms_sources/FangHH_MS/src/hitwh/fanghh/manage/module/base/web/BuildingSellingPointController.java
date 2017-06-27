package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.BuildingSellingPointService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.BuildingPropertyType;
import hitwh.fanghh.manage.pojo.building.BuildingSellingPoint;
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
@RequestMapping(value = "manage/buildingSellingPoint")
@SessionAttributes({ "user" })
public class BuildingSellingPointController {
	@Autowired
	private BuildingSellingPointService buildingSellingPointService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	
	/**
	 * 搜索楼盘卖点
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> search(@RequestParam Integer buildingId)
	{
		List<BuildingSellingPoint> pList = new ArrayList<BuildingSellingPoint>();
		StringBuilder hql = new StringBuilder("select b from BuildingSellingPoint as b " +
				"where b.building.buildingId = " + buildingId );
		
		pList = this.buildingSellingPointService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<BuildingSellingPoint> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.buildingSellingPointService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<BuildingSellingPoint> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.buildingSellingPointService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<BuildingSellingPoint> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.buildingSellingPointService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
