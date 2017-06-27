package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.UnitService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
import hitwh.fanghh.manage.pojo.building.RoofBeam;
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
@RequestMapping(value = "manage/unit")
@SessionAttributes({ "user" })
public class UnitController {
	@Autowired
	private UnitService unitService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索单元按楼栋编号
	 * @param roofId
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> searchUnit(@RequestParam Integer roofId 
			)
	{
		List<Unit> pList = new ArrayList<Unit>();
		StringBuilder hql = new StringBuilder("select u from Unit as u " +
				"where u.roofBeam.roofId = " + roofId );
		
		pList = this.unitService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	// 获取所有单元信息
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<Unit> unit = 
				this.unitService.getAll();
		return responseService.responseListMap(unit);
	}
	// 获取所有单元信息 ：id ,名称
	@RequestMapping(value = "/getAllForCom", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAllForCom() {
		List<InfoForComb> unit = 
				this.unitService.getAllForCon();
		return responseService.responseListMap(unit);
	}
	
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<Unit> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.unitService.add(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<Unit> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.unitService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<Unit> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.unitService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}
}
