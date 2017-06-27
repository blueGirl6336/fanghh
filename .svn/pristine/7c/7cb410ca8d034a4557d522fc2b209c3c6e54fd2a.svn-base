package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.ClearanceHouseListService;
import hitwh.fanghh.manage.module.base.service.RegionService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.ClearanceHouseList;
import hitwh.fanghh.manage.pojo.building.House;
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
@RequestMapping(value = "manage/clearanceHouseList")
@SessionAttributes({ "user" })
public class ClearanceHouseListController {
	@Autowired
	private ClearanceHouseListService clearanceHouseListService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ExtResponseJsonService responseService;
	// 获取所有捡漏活动信息
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<ClearanceHouseList> list = 
				this.clearanceHouseListService.getAll();
		return responseService.responseListMap(list);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> search(@RequestParam String activityId) {
		List<ClearanceHouseList> pList = new ArrayList<ClearanceHouseList>();
		StringBuilder hql = new StringBuilder("select c from ClearanceHouseList as c " +
				"where c.activityId like '%" + activityId + "%'");
		pList = this.clearanceHouseListService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}

	//添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam String activityId,
			@RequestParam String childOrderId,@RequestParam boolean isPurchased,
			@RequestParam String childOrderStatus,@RequestParam Integer house) {
		ClearanceHouseList clearanceHouseList = new ClearanceHouseList();
		House h = new House();
		h.setHouseId(house);
		clearanceHouseList.setActivityId(activityId);
		clearanceHouseList.setChildOrderId(childOrderId);
		clearanceHouseList.setChildOrderStatus(childOrderStatus);
		clearanceHouseList.setHouse(h);
		clearanceHouseList.setIsPurchased(isPurchased);
		this.clearanceHouseListService.add(clearanceHouseList);
		return this.responseService.responseSuccess("修改成功");
	}
	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestParam Integer chlId,@RequestParam String activityId,
			@RequestParam String childOrderId,@RequestParam boolean isPurchased,
			@RequestParam String childOrderStatus,@RequestParam Integer house) {
		ClearanceHouseList clearanceHouseList = clearanceHouseListService.searchByChlId(chlId).get(0);
		House h = new House();
		h.setHouseId(house);
		clearanceHouseList.setActivityId(activityId);
		clearanceHouseList.setChildOrderId(childOrderId);
		clearanceHouseList.setChildOrderStatus(childOrderStatus);
		clearanceHouseList.setHouse(h);
		clearanceHouseList.setIsPurchased(isPurchased);
		this.clearanceHouseListService.update(clearanceHouseList);
		return this.responseService.responseSuccess("修改成功");
	}


	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<ClearanceHouseList> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.clearanceHouseListService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
