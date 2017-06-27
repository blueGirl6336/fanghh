package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.BuildingCommentService;
import hitwh.fanghh.manage.pojo.building.BuildingComment;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "manage/buildingComment")
@SessionAttributes({ "user" })
public class BuildingCommentController {
	
	@Autowired
	private BuildingCommentService buildingCommentService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索楼盘点评按用户名，置业顾问名和楼盘名
	 * @param userName 用户名
	 * @param consultantName 置业顾问名
	 * @param buildingName 楼盘名
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String userName, 
			@RequestParam String consultantName,@RequestParam String buildingName)
	{
		List<BuildingComment> pList = new ArrayList<BuildingComment>();
		StringBuilder hql = new StringBuilder("from BuildingComment ");
		boolean hasUser =false;
		boolean hasConsultant =false;
		if(userName != null && userName !="")
		{
			hql.append(" where user.username like '%" + userName+"%'");
			hasUser =true;
		}
		if(consultantName != null && consultantName !="")
		{ 	
			hasConsultant = true;
			if (hasUser){
				hql.append(" and homeConsultant.consultantName like '%" + consultantName +"%'");
			}else{
				hql.append(" where homeConsultant.consultantName like '%" + consultantName +"%'");
			}
		}
		if(buildingName != null && buildingName != "")
		{ 	
			if (hasUser || hasConsultant){
				hql.append(" and building.buildingName like '%" + buildingName +"%'");
			}else{
				hql.append(" where building.buildingName like '%" + buildingName +"%'");
			}
		}
		pList = this.buildingCommentService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}

	// 获取所有楼盘评论信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<BuildingComment> list = 
				this.buildingCommentService.getAll();
		return responseService.responseListMap(list);
	}


	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestBody List<BuildingComment> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.buildingCommentService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<BuildingComment> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.buildingCommentService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除成功");
	}
	
}
