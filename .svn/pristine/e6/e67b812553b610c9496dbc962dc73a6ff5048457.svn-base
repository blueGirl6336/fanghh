package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.HouseService;
import hitwh.fanghh.manage.module.base.service.HouseStyleService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.HouseStyle;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
import hitwh.fanghh.manage.pojo.building.Unit;
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
@RequestMapping(value = "manage/house")
@SessionAttributes({ "user" })
public class HouseController {
	@Autowired
	private HouseService houseService;
	@Autowired
	private ExtResponseJsonService responseService;
	@Autowired
	private HouseStyleService houseStyleService;
	/**
	 * 搜索房屋按单元编号
	 * @param unitId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> searchHouse(@RequestParam Integer unitId){
		List<House> pList = new ArrayList<House>();
		StringBuilder hql = new StringBuilder("select h from House as h " +
				"where h.unit.unitId = " + unitId );
		
		pList = this.houseService.searchByHql(hql.toString());
		for(int i = 0; i < pList.size();i++){
			//获取房屋样式字典码
			pList.get(i).setHouseStyleCode(pList.get(i).getHouseStyle().getHouseStyle());
		}
		return this.responseService.responseListMap(pList);
	}
	
	// 获取所有单元信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<House> house = 
				this.houseService.getAll();
		return responseService.responseListMap(house);
	}
	
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<House> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.get(i).getHouseStyle().setHouseStyle(list.get(i).getHouseStyleCode());
			this.houseService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<House> list) {
		int size = list.size();
		List<HouseStyle> pList = new ArrayList<HouseStyle>();
		for (int i = 0; i < size; i++) {
			StringBuilder hql = new StringBuilder("select h from HouseStyle as h " +
					"where h.building.buildingId = " + list.get(i).getBuilding().getBuildingId() );
			pList = this.houseStyleService.searchByHql(hql.toString());
			for(int j = 0;j < pList.size();j++){
				if(pList.get(j).getHouseStyle().equals(list.get(i).getHouseStyleCode())){
					
				}
			}
			list.get(i).setHouseStyle(pList.get(0));
			this.houseService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<House> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.houseService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
