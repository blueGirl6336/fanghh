package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.GroupPurchaseHouseListService;
import hitwh.fanghh.manage.module.base.service.RegionService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.GroupPurchaseHouseList;
import hitwh.fanghh.manage.pojo.building.House;
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
@RequestMapping(value = "manage/groupPurchaseHouseList")
@SessionAttributes({ "user" })
public class GroupPurchaseHouseListController {
	@Autowired
	private GroupPurchaseHouseListService groupPurchaseHouseListService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ExtResponseJsonService responseService;
	// 获取所有捡漏活动信息
	@RequestMapping(value = "/getByActivityId", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAll(@RequestParam String activityId) {
		List<GroupPurchaseHouseList> list = 
				this.groupPurchaseHouseListService.getByActivityId(activityId);
		return responseService.responseListMap(list);
	}

	//添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user,
			@RequestParam Integer house,
			@RequestParam String activityId,
			@RequestParam String childOrderId,
			@RequestParam boolean isPurchased,
			@RequestParam String childOrderStatus) {
		
		List<GroupPurchaseHouseList> list = new ArrayList<GroupPurchaseHouseList>();
		GroupPurchaseHouseList item = new GroupPurchaseHouseList();
		item.setActivityId(activityId); item.setChildOrderId(childOrderId);
		item.setIsPurchased(isPurchased); item.setChildOrderStatus(childOrderStatus);
		House h = new House(); h.setHouseId(house); item.setHouse(h);
		list.add(item);
		this.groupPurchaseHouseListService.add(list.get(0));
		return this.responseService.responseSuccess("修改成功");
	}
	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<GroupPurchaseHouseList> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.groupPurchaseHouseListService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}


	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<GroupPurchaseHouseList> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.groupPurchaseHouseListService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
