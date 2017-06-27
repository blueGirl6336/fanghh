package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.BrokerCommentFromConsultantService;
import hitwh.fanghh.manage.pojo.building.BrokerCommentFromConsultant;
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
@RequestMapping(value = "manage/brokerCommentFromConsultant")
@SessionAttributes({ "user" })
public class BrokerCommentFromConsultantController {
	
	@Autowired
	private BrokerCommentFromConsultantService brokerCommentFromConsultantService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索经纪人评价按经纪人姓名和置业顾问姓名
	 * @param brokerName 经纪人姓名
	 * @param consultantName 置业顾问姓名
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String brokerName, 
			@RequestParam String consultantName)
	{
		List<BrokerCommentFromConsultant> pList = new ArrayList<BrokerCommentFromConsultant>();
		StringBuilder hql = new StringBuilder("select b from BrokerCommentFromConsultant as b ");
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
		pList = this.brokerCommentFromConsultantService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
	
	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<BrokerCommentFromConsultant> list = 
				this.brokerCommentFromConsultantService.getAll();
		return responseService.responseListMap(list);
	}


	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestBody List<BrokerCommentFromConsultant> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.brokerCommentFromConsultantService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<BrokerCommentFromConsultant> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.brokerCommentFromConsultantService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除成功");
	}
	
}
