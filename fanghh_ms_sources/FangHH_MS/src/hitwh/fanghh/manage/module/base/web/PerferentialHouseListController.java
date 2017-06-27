package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.PerferentialHouseListService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseList;
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
@RequestMapping(value = "manage/perferentialHouseList")
@SessionAttributes({ "user" })
public class PerferentialHouseListController {
	@Autowired
	private PerferentialHouseListService perferentialHouseListService;
	@Autowired
	private ExtResponseJsonService responseService;

	

	// 获取所有特惠活动信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<PerferentialHouseList> list = 
				this.perferentialHouseListService.getAll();
		return responseService.responseListMap(list);
	}
	
	
	/**
	 * 根据活动ID搜索
	 * @param activityId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String activityId)
	{
		List<PerferentialHouseList> pList = new ArrayList<PerferentialHouseList>();
		StringBuilder hql = new StringBuilder("select p from PerferentialHouseList as p " +
				"where 1=1 ");
		if(activityId != null )
		{
			hql.append(" and p.activityId ="+ activityId);
		}
		
		pList = this.perferentialHouseListService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	

	//添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestParam Integer houseId,
			@RequestParam String childOrderId,@RequestParam boolean isPurchased,
			@RequestParam String childOrderStatus,
			@RequestParam String activityId) {
		PerferentialHouseList p = new PerferentialHouseList();
		House h = new House();
		h.setHouseId(houseId);
		p.setHouse(h);
		p.setActivityId(activityId);
		p.setChildOrderId(childOrderId);
		p.setIsPurchased(isPurchased);
		p.setChildOrderStatus(childOrderStatus);
		perferentialHouseListService.add(p);
		return this.responseService.responseSuccess("添加成功");
	}
	
	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(
			@ModelAttribute User user, @RequestParam Integer phlId,@RequestParam Integer houseId,
			@RequestParam String childOrderId,@RequestParam boolean isPurchased,
			@RequestParam String childOrderStatus,
			@RequestParam String activityId) {
		PerferentialHouseList p = perferentialHouseListService.searchByPhlId(phlId).get(0);
		House h = new House();
		h.setHouseId(houseId);
		p.setHouse(h);
		p.setActivityId(activityId);
		p.setChildOrderId(childOrderId);
		p.setIsPurchased(isPurchased);
		p.setChildOrderStatus(childOrderStatus);
		this.perferentialHouseListService.update(p);
		return this.responseService.responseSuccess("修改成功");
	}


	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<PerferentialHouseList> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.perferentialHouseListService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
