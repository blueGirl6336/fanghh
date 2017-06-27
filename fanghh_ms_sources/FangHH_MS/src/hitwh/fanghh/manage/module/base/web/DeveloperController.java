package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.DeveloperService;
import hitwh.fanghh.manage.module.base.service.SurroundFacilityService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Developer;
import hitwh.fanghh.manage.pojo.building.SurroundFacility;
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
@RequestMapping(value = "manage/developer")
@SessionAttributes({ "user" })
public class DeveloperController {
	@Autowired
	private DeveloperService developerService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	
	/**
	 * 搜索开发商信息 楼盘id
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> searchByDevelopName(@RequestParam String developName,@RequestParam String developAddr)
	{
		List<Developer> pList = new ArrayList<Developer>();
		StringBuilder hql = new StringBuilder("select d from Developer as d " +
				"where d.developName like '%" + developName + "%'" );
		
		pList = this.developerService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	
	/**
	 * 搜索开发商信息 楼盘名称
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/searchByBuildingName", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> searchByBuildingId(@RequestParam String buildingName)
	{
		List<Developer> pList = new ArrayList<Developer>();
		StringBuilder hql = new StringBuilder("select d from Developer as d " +
				"where d.building.buildingName like '%" + buildingName + "%'" );
		pList = this.developerService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<Developer> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.developerService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<Developer> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.developerService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<Developer> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.developerService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
