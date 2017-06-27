package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.RoofBeamService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
import hitwh.fanghh.manage.pojo.building.RoofBeam;
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
@RequestMapping(value = "manage/roofBeam")
@SessionAttributes({ "user" })
public class RoofBeamController {
	@Autowired
	private RoofBeamService roofBeamService;
	@Autowired
	private ExtResponseJsonService responseService;

	/**
	 * 搜索楼栋按楼盘编号编号
	 * 
	 * @param buildingId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> searchRoof(@RequestParam Integer buildingId) {
		List<RoofBeam> pList = new ArrayList<RoofBeam>();
		StringBuilder hql = new StringBuilder("select r from RoofBeam as r "
				+ "where r.building.buildingId = " + buildingId);


		pList = this.roofBeamService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}

	// 获取所有楼栋信息
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<RoofBeam> roofBeam = this.roofBeamService.getAll();
		return responseService.responseListMap(roofBeam);
	}

	// 获取所有楼栋信息 ：id ,名称
	@RequestMapping(value = "/getAllForCom", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllForCom() {
		List<InfoForComb> roofBeam = this.roofBeamService.getAllForCon();
		return responseService.responseListMap(roofBeam);
	}

	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam String roofName,
			@RequestParam String propertyType,
			@RequestParam String roofStructer, @RequestParam String roofHeight,
			@RequestParam String roofFace, @RequestParam int airFloors,
			@RequestParam int earthFloors, @RequestParam int roofNum,
			@RequestParam int building) {
		RoofBeam roofBeam = new RoofBeam();
		Building b = new Building();
		b.setBuildingId(building);
		roofBeam.setRoofName(roofName);
		roofBeam.setPropertyType(propertyType);
		roofBeam.setRoofStructer(roofStructer);
		roofBeam.setRoofHeight(roofHeight);
		roofBeam.setRoofFace(roofFace);
		roofBeam.setAirFloors(airFloors);
		roofBeam.setEarthFloors(earthFloors);
		roofBeam.setRoofNum(roofNum);
		roofBeam.setBuilding(b);
		this.roofBeamService.add(roofBeam);
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user,
			@RequestBody List<RoofBeam> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.roofBeamService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user,
			@RequestBody List<RoofBeam> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.roofBeamService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
