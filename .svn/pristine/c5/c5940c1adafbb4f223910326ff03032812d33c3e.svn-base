package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.PerferentialHouseInfoService;
import hitwh.fanghh.manage.module.base.service.RegionService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseInfo;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@RequestMapping(value = "manage/perferentialHouseInfo")
@SessionAttributes({ "user" })
public class PerferentialHouseInfoConTroller {


@Autowired
private PerferentialHouseInfoService perferentialHouseInfoService;
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
@RequestMapping(value = "/search", method = RequestMethod.POST)
@ResponseBody
public Map<String,Object> search(@RequestParam String building, 
		@RequestParam String startTime,@RequestParam  String endTime)
{
	List<PerferentialHouseInfo> pList = new ArrayList<PerferentialHouseInfo>();
	StringBuilder hql = new StringBuilder("select p from PerferentialHouseInfo as p " +
			"where 1=1 ");
	if(building != null )
	{
		hql.append(" and p.building.buildingId like '%"+ building+"%'");
	}
	if(startTime != null && startTime.length() != 0
			&& endTime != null && endTime.length() != 0)
	{
		hql.append(" and p.startTime between '" + startTime + "' and '" +endTime+"'" );
	}
	pList = this.perferentialHouseInfoService.searchByHql(hql.toString());
	return this.responseService.responseListMap(pList);
}

// 获取所有特惠活动信息
@RequestMapping(value = "/getAll", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> getAll() {
	List<PerferentialHouseInfo> list = 
			this.perferentialHouseInfoService.getAll();
	return responseService.responseListMap(list);
}

//添加新项 415
@RequestMapping(value = "/add", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> add(@ModelAttribute User user,@RequestParam Integer building,
		@RequestParam String activityId,@RequestParam String activityPic,
		@RequestParam String startTime,
		@RequestParam String endTime,
		@RequestParam String purchaseNote,
		@RequestParam String remark){
	
	PerferentialHouseInfo perferentialHouseInfo = new PerferentialHouseInfo();
	Building buildingTemp = new Building();
	buildingTemp.setBuildingId(building);
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date startTimeC= null;
	Date endTimeC = null;
	try {
		startTimeC= sdf.parse(startTime);
		endTimeC= sdf.parse(endTime);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	perferentialHouseInfo.setBuilding(buildingTemp);
	perferentialHouseInfo.setActivityId(activityId);
	perferentialHouseInfo.setActivityPic(activityPic);
	perferentialHouseInfo.setStartTime(startTimeC);
	perferentialHouseInfo.setEndTime(endTimeC);
	perferentialHouseInfo.setPurchaseNote(purchaseNote);
	perferentialHouseInfo.setRemark(remark);
	this.perferentialHouseInfoService.add(perferentialHouseInfo);
	return this.responseService.responseSuccess("添加成功");
}
// 更新项
@RequestMapping(value = "/update", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> update(@ModelAttribute User user, @RequestParam Integer building,
		@RequestParam String activityId,@RequestParam String activityPic,
		@RequestParam String startTime,
		@RequestParam String endTime,
		@RequestParam String purchaseNote,
		@RequestParam String remark) {
	PerferentialHouseInfo perferentialHouseInfo = perferentialHouseInfoService.searchByActivityId(activityId).get(0);
	Building buildingTemp = new Building();
	buildingTemp.setBuildingId(building);
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date startTimeC= null;
	Date endTimeC = null;
	try {
		startTimeC= sdf.parse(startTime);
		endTimeC= sdf.parse(endTime);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	perferentialHouseInfo.setBuilding(buildingTemp);
	perferentialHouseInfo.setActivityId(activityId);
	perferentialHouseInfo.setActivityPic(activityPic);
	perferentialHouseInfo.setStartTime(startTimeC);
	perferentialHouseInfo.setEndTime(endTimeC);
	perferentialHouseInfo.setPurchaseNote(purchaseNote);
	perferentialHouseInfo.setRemark(remark);
	this.perferentialHouseInfoService.update(perferentialHouseInfo);
	return this.responseService.responseSuccess("修改成功");
}


// 删除项
@RequestMapping(value = "/delete", method = RequestMethod.POST)
@ResponseBody
public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<PerferentialHouseInfo> list) {
	int size = list.size();
	for (int i = 0; i < size; i++) {
		this.perferentialHouseInfoService.delete(list.get(i));
	}
	return this.responseService.responseSuccess("修改成功");
}
		
}
