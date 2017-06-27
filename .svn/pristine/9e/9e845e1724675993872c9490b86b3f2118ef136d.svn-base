package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.BuildingService;
import hitwh.fanghh.manage.module.base.service.RegionService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
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
@RequestMapping(value = "manage/building")
@SessionAttributes({ "user" })
public class BuildingInfoController {
	
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索楼盘按名称区域
	 * @param buildingName
	 * @param region
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String buildingName, 
			@RequestParam Integer region,@RequestParam Integer city)
	{
		List<Building> pList = new ArrayList<Building>();
		StringBuilder hql = new StringBuilder("select b from Building as b,Region as r " +
				"where b.region.regionId=r.regionId ");
		if(buildingName != null && buildingName.length() > 0)
		{
			hql.append(" and b.buildingName like '%" + buildingName + "%'");
		}
		if(region != null && region!= 0)
		{
			hql.append(" and r.regionId = " + region );
		}
		if(city != null && city!= 0)
		{
			hql.append(" and b.region.city.cityId = " + city );
		}
		pList = this.buildingService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	/**
	 * 搜索楼盘按城市 区域
	 * @param buildingName
	 * @param region
	 * @return
	 */
	@RequestMapping(value = "/searchByCon", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> searchByCon( 
			@RequestParam Integer region,@RequestParam Integer city)
	{
		List<Building> pList = new ArrayList<Building>();
		StringBuilder hql = new StringBuilder("select new hitwh.fanghh.manage.pojo.building.InfoForComb(" +
				"b.buildingId,b.buildingName) from Building as b where 1 = 1 ");
		if(region != null && region!= 0)
		{
			hql.append(" and b.region.regionId = " + region );
		}
		if(city != null && city!= 0)
		{
			hql.append(" and b.region.city.cityId = " + city );
		}
		pList = this.buildingService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	@RequestMapping(value = "/searchByDeveloper", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> searchByDeveloper(
			@RequestParam Integer developerId){
		List<Building> pList = new ArrayList<Building>();
		StringBuilder hql = new StringBuilder("from Building as b where b.developer.developerId = "+developerId);
		pList = this.buildingService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	
	@RequestMapping(value = "/updateDeveloper", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateDeveloper(@RequestBody List<Building> bList){
		//StringBuilder hql = new StingBuilder("from Building as")
		return this.responseService.responseSuccess("");
	}
	// 获取所有楼盘信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<Building> list = 
				this.buildingService.getAll();
		return responseService.responseListMap(list);
	}
	// 获取所有楼盘信息 楼盘id  楼盘名称
	@RequestMapping(value = "/getAllForCom", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllForCom() {
		List<InfoForComb> buildingPropertyType = 
				this.buildingService.getAllForCon();
		return responseService.responseListMap(buildingPropertyType);
	}
	@RequestMapping(value = "/getNameById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getById(@RequestParam Integer buildingId) {
		Building building = 
				this.buildingService.getById(buildingId);
		return responseService.responseObjectMap(building.getBuildingName());
	}
	// 添加新项
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam String buildingName,@RequestParam String openingTime,
			@RequestParam String launchTime,@RequestParam Long averagePrice,@RequestParam String buildingAddr,
			@RequestParam long highestCommission,@RequestParam long cautionMoney,
			@RequestParam Integer duration,@RequestParam String videoLink,@RequestParam double planAre,
			@RequestParam double constructionArea,@RequestParam double plotRate,@RequestParam double greeningRate,
			@RequestParam Integer householdNum,@RequestParam Integer parkingspaceNum,
			@RequestParam Integer regionId,@RequestParam String buildingLocation,
			@RequestParam String saleSiteLocation,@RequestParam String constructionKind,@RequestParam String constructionUse,
			@RequestParam Boolean isCopartner,@RequestParam Boolean isActivited,@RequestParam String purchaseNote,
			@RequestParam int sellingHotlabel,@RequestParam int sellingHotSort,@RequestParam int buildingType) {
		Building building = new Building();
		building.setAveragePrice(averagePrice);
		building.setBuildingAddr(buildingAddr);
		building.setBuildingLocation(buildingLocation);
		building.setBuildingName(buildingName);
		//building.setBuildingPic(buildingPic);
		//building.setBuildingPortrait(buildingPortrait);
		building.setCautionMoney(cautionMoney);
		building.setConstructionArea(constructionArea);
		building.setConstructionKind(constructionKind);
		building.setConstructionUse(constructionUse);
		building.setCreateTime(new Date());
		building.setDuration(duration);
		building.setGreeningRate(greeningRate);
		building.setHighestCommission(highestCommission);
		building.setHouseholdNum(householdNum);
		building.setIsActivited(isActivited);
		building.setIsCopartner(isCopartner);
		building.setSellingHotlabel(sellingHotlabel);
		building.setSellingHotSort(sellingHotSort);
		building.setBuildingType(buildingType);
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-mm-dd");
		Date launch= null;
		Date open = null;
		try {
			launch= sdf.parse(launchTime);
			open= sdf.parse(openingTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		building.setLaunchTime(launch);
		building.setOpeningTime(open);
		building.setParkingspaceNum(parkingspaceNum);
		building.setPlanArea(planAre);
		building.setPlotRate(plotRate);
		building.setPurchaseNote(purchaseNote);
		building.setRegion(regionService.getById(regionId));
		building.setSaleSiteLocation(saleSiteLocation);
		building.setVideoLink(videoLink);
		this.buildingService.add(building);
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestParam String buildingId,@RequestParam String buildingName,@RequestParam String openingTime,
			@RequestParam String launchTime,@RequestParam Long averagePrice,@RequestParam String buildingAddr,
			@RequestParam long highestCommission,@RequestParam long cautionMoney,
			@RequestParam Integer duration,@RequestParam String videoLink,@RequestParam double planArea,
			@RequestParam double constructionArea,@RequestParam double plotRate,@RequestParam double greeningRate,
			@RequestParam Integer householdNum,@RequestParam Integer parkingspaceNum,
			@RequestParam Integer regionId,@RequestParam Integer city,@RequestParam String buildingLocation,
			@RequestParam String saleSiteLocation,@RequestParam String constructionKind,@RequestParam String constructionUse,
			@RequestParam Boolean isCopartner,@RequestParam Boolean isActivited,@RequestParam String purchaseNote,
			@RequestParam int sellingHotlabel,@RequestParam int sellingHotSort,@RequestParam int buildingType) {
		/**
		 * 重要修改，原来更新的时候会设置未更改的数据为空
		 */
		Building building = buildingService.getById(Integer.parseInt(buildingId));
		//building.setBuildingId(Integer.parseInt(buildingId));
		building.setAveragePrice(averagePrice);
		building.setBuildingAddr(buildingAddr);
		building.setBuildingLocation(buildingLocation);
		building.setBuildingName(buildingName);
		//building.setBuildingPic(buildingPic);
		//building.setBuildingPortrait(buildingPortrait);
		building.setCautionMoney(cautionMoney);
		building.setConstructionArea(constructionArea);
		building.setConstructionKind(constructionKind);
		building.setConstructionUse(constructionUse);
		building.setCreateTime(new Date());
		building.setDuration(duration);
		building.setGreeningRate(greeningRate);
		building.setHighestCommission(highestCommission);
		building.setHouseholdNum(householdNum);
		building.setIsActivited(isActivited);
		building.setIsCopartner(isCopartner);
		building.setPurchaseNote(purchaseNote);
		building.setSellingHotlabel(sellingHotlabel);
		building.setSellingHotSort(sellingHotSort);
		building.setBuildingType(buildingType);
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-mm-dd");
		Date launch= null;
		Date open = null;
		try {
			launch= sdf.parse(launchTime);
			open= sdf.parse(openingTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		building.setLaunchTime(launch);
		building.setOpeningTime(open);
		building.setParkingspaceNum(parkingspaceNum);
		building.setPlanArea(planArea);
		building.setPlotRate(plotRate);
		building.setPurchaseNote(purchaseNote);
		building.setRegion(regionService.getById(regionId));
		building.setSaleSiteLocation(saleSiteLocation);
		building.setVideoLink(videoLink);
		this.buildingService.update(building);
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<Building> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.buildingService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
	
}
