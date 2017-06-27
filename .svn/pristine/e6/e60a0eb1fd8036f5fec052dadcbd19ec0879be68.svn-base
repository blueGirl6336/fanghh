
package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.SurroundFacilityService;
import hitwh.fanghh.manage.module.base.service.UnitService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.BuildingSellingPoint;
import hitwh.fanghh.manage.pojo.building.Region;
import hitwh.fanghh.manage.pojo.building.SurroundFacility;
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
@RequestMapping(value = "manage/surroundFacility")
@SessionAttributes({ "user" })
public class SurroundFacilityController {
	@Autowired
	private SurroundFacilityService surroundFacilityService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	
	/**
	 * 搜索楼盘周边
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> search(@RequestParam Integer buildingId)
	{
		List<SurroundFacility> pList = new ArrayList<SurroundFacility>();
		StringBuilder hql = new StringBuilder("select s from SurroundFacility as s " +
				"where s.building.buildingId = " + buildingId );
		
		pList = this.surroundFacilityService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<SurroundFacility> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.surroundFacilityService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<SurroundFacility> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.surroundFacilityService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<SurroundFacility> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.surroundFacilityService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
