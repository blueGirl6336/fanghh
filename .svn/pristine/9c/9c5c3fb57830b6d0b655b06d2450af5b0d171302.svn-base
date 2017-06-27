package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.BuildingService;
import hitwh.fanghh.manage.module.base.service.ClearanceHouseInfoService;
import hitwh.fanghh.manage.module.base.service.RegionService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.ClearanceHouseInfo;
import hitwh.fanghh.manage.pojo.building.CommissionRule;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping(value = "manage/clearanceHouseInfo")
@SessionAttributes({ "user" })
public class ClearanceHouseInfoController {
	@Autowired
	private ClearanceHouseInfoService clearanceHouseInfoService;
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ExtResponseJsonService responseService;

	/**
	 * 搜索时间 搜索
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String startTime,@RequestParam  String endTime,@RequestParam  String buildingName)
	{
		List<ClearanceHouseInfo> pList = new ArrayList<ClearanceHouseInfo>();
		StringBuilder hql = new StringBuilder("select c from ClearanceHouseInfo as c " +
				"where 1=1 ");
		if(startTime != null && startTime.length() != 0
				&& endTime != null && endTime.length() != 0)
		{
			hql.append(" and c.startTime between '" + startTime + "' and '" +endTime+"'" );
		}
		if(buildingName != null && buildingName.length() > 0) {
			hql.append("and c.building.buildingName like '%" + buildingName + "%'");
		}
		pList = this.clearanceHouseInfoService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}

	// 获取所有特惠活动信息
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<ClearanceHouseInfo> list = 
				this.clearanceHouseInfoService.getAll();
		return responseService.responseListMap(list);
	}

	//添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam String activityId,@RequestParam Integer houseId,@RequestParam String activityPic,
			@RequestParam Date startTime,@RequestParam Date endTime,
			@RequestParam String purchaseNote,@RequestParam String remark,
			@RequestParam int building
			) {
		ClearanceHouseInfo clearanceHouseInfo = new ClearanceHouseInfo();
		Building b = new Building();
		b.setBuildingId(building);
		House h = new House();
		h.setHouseId(houseId);
		clearanceHouseInfo.setHouse(h);
		clearanceHouseInfo.setActivityId(activityId);
		clearanceHouseInfo.setActivityPic(activityPic);
		clearanceHouseInfo.setBuilding(b);
		clearanceHouseInfo.setEndTime(endTime);
		clearanceHouseInfo.setPurchaseNote(purchaseNote);
		clearanceHouseInfo.setRemark(remark);
		clearanceHouseInfo.setStartTime(startTime);
		this.clearanceHouseInfoService.add(clearanceHouseInfo);
		return this.responseService.responseSuccess("修改成功");
	}
	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestParam String activityId,@RequestParam Integer houseId,@RequestParam String activityPic,
			@RequestParam Date startTime,@RequestParam Date endTime,
			@RequestParam String purchaseNote,@RequestParam String remark,
			@RequestParam int building) {
		
		ClearanceHouseInfo clearanceHouseInfo = clearanceHouseInfoService.searchByActivityId(activityId).get(0);
		Building b = new Building();
		b.setBuildingId(building);
		House h = new House();
		h.setHouseId(houseId);
		int ruleId = buildingService.getById(building).getRule().getRuleId();
		CommissionRule r = new CommissionRule();
		r.setRuleId(ruleId);
		clearanceHouseInfo.setBuilding(b);
		clearanceHouseInfo.setHouse(h);
		clearanceHouseInfo.setActivityId(activityId);
		clearanceHouseInfo.setActivityPic(activityPic);
		clearanceHouseInfo.setStartTime(startTime);
		clearanceHouseInfo.setEndTime(endTime);
		clearanceHouseInfo.setPurchaseNote(purchaseNote);
		clearanceHouseInfo.setRemark(remark);
		clearanceHouseInfo.setRule(r);
		this.clearanceHouseInfoService.update(clearanceHouseInfo);
		return this.responseService.responseSuccess("修改成功");
	}


	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<ClearanceHouseInfo> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.clearanceHouseInfoService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
