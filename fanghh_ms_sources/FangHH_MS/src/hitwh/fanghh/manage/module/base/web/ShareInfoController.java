package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.BuildingService;
import hitwh.fanghh.manage.module.base.service.RegionService;
import hitwh.fanghh.manage.module.base.service.ShareInfoService;
import hitwh.fanghh.manage.module.base.service.impl.BuildingServiceImpl;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.ShareInfo;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import java.math.BigDecimal;
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
@RequestMapping(value = "manage/shareInfo")
@SessionAttributes({ "user" })
public class ShareInfoController {
	@Autowired
	private ShareInfoService shareInfoService;
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private ExtResponseJsonService responseService;
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam Integer buildingId,
			@RequestParam String title,@RequestParam BigDecimal cashBack,@RequestParam BigDecimal totalCash) {
		ShareInfo si = new ShareInfo();
		si.setTitle(title);
		si.setCashBack(cashBack);
		si.setTotalCash(totalCash);
		si.setRemainCash(totalCash);
		si.setIssueTime(new Date());
		si.setBuilding(buildingService.getById(buildingId));
		this.shareInfoService.add(si);
		return this.responseService.responseSuccess("添加成功");
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String title,
			@RequestParam String buildingName)
	{
		List<ShareInfo> pList = new ArrayList<ShareInfo>();
		StringBuilder hql = new StringBuilder("from ShareInfo ");
		boolean hasTitle =false;
		if(title != null && title !="")
		{ 	
			hasTitle = true;
			hql.append(" where title like '%" + title +"%'");
		}
		if(buildingName != null && buildingName != "")
		{ 	
			if (hasTitle){
				hql.append(" and building.buildingName like '%" + buildingName +"%'");
			}else{
				hql.append(" where building.buildingName like '%" + buildingName +"%'");
			}
		}
		pList = this.shareInfoService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<ShareInfo> list = 
				this.shareInfoService.getAll();
		return responseService.responseListMap(list);
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<ShareInfo> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.shareInfoService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<ShareInfo> list) {
//		int size = list.size();
//		for (int i = 0; i < size; i++) {
//			this.shareInfoService.delete(list.get(i));
//		}
//		return this.responseService.responseSuccess("修改成功");
//	}

}
