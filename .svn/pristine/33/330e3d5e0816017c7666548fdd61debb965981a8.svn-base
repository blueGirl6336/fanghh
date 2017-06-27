package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.GroupPurchaseInfoService;
import hitwh.fanghh.manage.module.base.service.RegionService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.GroupPurchaseInfo;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/groupPurchaseInfo")
@SessionAttributes({ "user" })
public class GroupPurchaseInfoController {
	@Autowired
	private GroupPurchaseInfoService groupPurchaseInfoService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ExtResponseJsonService responseService;

	/**
	 * 搜索时间和楼盘id 搜索
	 * @param buildingId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String building, 
			@RequestParam String startTime,@RequestParam  String endTime)
	{
		startTime = startTime.split("T")[0];  
		endTime = endTime.split("T")[0];
		List<GroupPurchaseInfo> pList = new ArrayList<GroupPurchaseInfo>();
		StringBuilder hql = new StringBuilder("select g from GroupPurchaseInfo as g " +
				"where 1=1 ");
		if(building != null )
		{
			hql.append(" and g.building.buildingId like '%"+ building+"%'");
		}
		if(startTime != null && startTime.length() != 0
				&& endTime != null && endTime.length() != 0)
		{
			hql.append(" and g.startTime between '" + startTime + "' and '" +endTime+"'" );
		}
		pList = this.groupPurchaseInfoService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}


	// 获取所有团购活动信息
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<GroupPurchaseInfo> list = 
				this.groupPurchaseInfoService.getAll();
		return responseService.responseListMap(list);
	}

	//添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestParam String building,@RequestParam String activityId,
			@RequestParam Integer personNumInFavor,@RequestParam Integer minPersonNumStandard,@RequestParam Date startTime,
			@RequestParam Date endTime,@RequestParam Integer totalOfferNum,@RequestParam Integer currentPurchasedNum,
			@RequestParam long orginalPricePerSquareMeter,@RequestParam long orginalHousePrice,
			@RequestParam long currentPricePerSquareMetre,@RequestParam long currentHouse,
			@RequestParam String purchaseNote,@RequestParam Boolean isSuccess) {
		List<GroupPurchaseInfo> list = new ArrayList<GroupPurchaseInfo>();
		GroupPurchaseInfo temp = new GroupPurchaseInfo();
		temp.setBuilding( new Building (Integer.parseInt(building)));
		temp.setActivityId(activityId);
		temp.setPersonNumInFavor(personNumInFavor);
		temp.setMinPersonNumStandard(minPersonNumStandard);
		temp.setStartTime(startTime);
		temp.setEndTime(endTime);
		temp.setTotalOfferNum(totalOfferNum);
		temp.setCurrentPurchasedNum(currentPurchasedNum);
		temp.setOrginalPricePerSquareMeter(orginalPricePerSquareMeter);
		temp.setOrginalHousePrice(orginalHousePrice);
		temp.setCurrentPricePerSquareMetre(currentPricePerSquareMetre);
		temp.setCurrentHouse(currentHouse);
		temp.setPurchaseNote(purchaseNote);
		temp.setIsSuccess(isSuccess);
		list.add(temp);
		this.groupPurchaseInfoService.add(list.get(0));
		return this.responseService.responseSuccess("修改成功");
	}
	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestParam String building,@RequestParam String activityId,
			@RequestParam Integer personNumInFavor,@RequestParam Integer minPersonNumStandard,@RequestParam Date startTime,
			@RequestParam Date endTime,@RequestParam Integer totalOfferNum,@RequestParam Integer currentPurchasedNum,
			@RequestParam long orginalPricePerSquareMeter,@RequestParam long orginalHousePrice,
			@RequestParam long currentPricePerSquareMetre,@RequestParam long currentHouse,
			@RequestParam String purchaseNote,@RequestParam Boolean isSuccess) {
		GroupPurchaseInfo temp = this.groupPurchaseInfoService.searchByActivityId(activityId).get(0);
		temp.setBuilding( new Building (Integer.parseInt(building)));
		temp.setActivityId(activityId);
		temp.setPersonNumInFavor(personNumInFavor);
		temp.setMinPersonNumStandard(minPersonNumStandard);
		temp.setStartTime(startTime);
		temp.setEndTime(endTime);
		temp.setTotalOfferNum(totalOfferNum);
		temp.setCurrentPurchasedNum(currentPurchasedNum);
		temp.setOrginalPricePerSquareMeter(orginalPricePerSquareMeter);
		temp.setOrginalHousePrice(orginalHousePrice);
		temp.setCurrentPricePerSquareMetre(currentPricePerSquareMetre);
		temp.setCurrentHouse(currentHouse);
		temp.setPurchaseNote(purchaseNote);
		temp.setIsSuccess(isSuccess);
		this.groupPurchaseInfoService.update(temp);
		return this.responseService.responseSuccess("修改成功");
	}


	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestParam Integer gpId) {
		this.groupPurchaseInfoService.delete(gpId);
		return this.responseService.responseSuccess("修改成功");
	}
}
