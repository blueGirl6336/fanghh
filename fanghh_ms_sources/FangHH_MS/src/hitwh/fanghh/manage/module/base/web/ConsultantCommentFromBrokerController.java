package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.ConsultantCommentFromBrokerService;
import hitwh.fanghh.manage.pojo.building.ConsultantCommentFromBroker;
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
@RequestMapping(value = "manage/consultantCommentFromBroker")
@SessionAttributes({ "user" })
public class ConsultantCommentFromBrokerController {
	
	@Autowired
	private ConsultantCommentFromBrokerService consultantCommentFromBrokerService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索置业顾问评价按经纪人姓名和置业顾问名
	 * @param brokerName 经纪人姓名
	 * @param consultantName 置业顾问姓名
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String brokerName, 
			@RequestParam String consultantName)
	{
		List<ConsultantCommentFromBroker> pList = new ArrayList<ConsultantCommentFromBroker>();
		StringBuilder hql = new StringBuilder("select b from ConsultantCommentFromBroker as b ");
		boolean hasBroker =false;
		if(brokerName != null && brokerName !="")
		{
			hql.append(" where b.broker.brokerName like '%" + brokerName+"%'");
			hasBroker =true;
		}
		if(consultantName != null && consultantName !="")
		{ 	
			if (hasBroker){
				hql.append(" and b.homeConsultant.consultantName like '%" + consultantName +"%'");
			}else{
				hql.append(" where b.homeConsultant.consultantName like '%" + consultantName +"%'");
			}
		}
		pList = this.consultantCommentFromBrokerService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<ConsultantCommentFromBroker> list = 
				this.consultantCommentFromBrokerService.getAll();
		return responseService.responseListMap(list);
	}


	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestBody List<ConsultantCommentFromBroker> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.consultantCommentFromBrokerService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<ConsultantCommentFromBroker> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.consultantCommentFromBrokerService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除成功");
	}
	
}
