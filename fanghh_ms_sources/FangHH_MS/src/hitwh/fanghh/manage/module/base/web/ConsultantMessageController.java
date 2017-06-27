package hitwh.fanghh.manage.module.base.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import hitwh.fanghh.manage.module.base.service.ConsultantMessageService;
import hitwh.fanghh.manage.module.base.service.HomeConsultantService;
import hitwh.fanghh.manage.module.base.service.SalesDirectorService;
import hitwh.fanghh.manage.pojo.building.ConsultantMessage;
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
@RequestMapping(value = "manage/consultantMessage")
@SessionAttributes({ "user" })
public class ConsultantMessageController {
	
	@Autowired
	private ConsultantMessageService consultantMessageService;
	@Autowired
	private HomeConsultantService homeConsultantService;
	@Autowired
	private SalesDirectorService salesDirectorService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索置业顾问消息按用户名，楼盘名和置业顾问名
	 * @param userName 用户名
	 * @param consultantName 置业顾问姓名
	 * @param buildingName 楼盘名
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(@RequestParam String directorName,@RequestParam String consultantName, 
			@RequestParam String title,@RequestParam String content)
	{
		List<ConsultantMessage> pList = new ArrayList<ConsultantMessage>();
		StringBuilder hql = new StringBuilder("from ConsultantMessage ");
		boolean hasDirector =false;
		boolean hasConsultant =false;
		boolean hasTitle =false;
		if(directorName != null && directorName !="")
		{
			hasDirector =true;
			hql.append(" where salesDirector.directorName like '%" + directorName+"%'");
		}
		if(consultantName != null && consultantName !="")
		{
			hasConsultant =true;
			if (hasDirector){
				hql.append(" and homeConsultant.consultantName like '%" + consultantName +"%'");
			}else{
				hql.append(" where homeConsultant.consultantName like '%" + consultantName +"%'");
			}
		}
		if(title != null && title !="")
		{ 	
			hasTitle = true;
			if (hasConsultant||hasDirector){
				hql.append(" and messageTitle like '%" + title +"%'");
			}else{
				hql.append(" where messageTitle like '%" + title +"%'");
			}
		}
		if(content != null && content != "")
		{ 	
			if (hasConsultant||hasDirector|| hasTitle){
				hql.append(" and messageContent like '%" + content +"%'");
			}else{
				hql.append(" where messageContent like '%" + content +"%'");
			}
		}
		pList = this.consultantMessageService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}

	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<ConsultantMessage> list = 
				this.consultantMessageService.getAll();
		return responseService.responseListMap(list);
	}

	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam Integer directorId,@RequestParam Integer consultantId,
			@RequestParam String messageTitle,@RequestParam String messageContent ) {
		ConsultantMessage cm = new ConsultantMessage();
		cm.setHomeConsultant(homeConsultantService.getById(consultantId));
		cm.setSalesDirector(salesDirectorService.getById(directorId));
		cm.setMessageTitle(messageTitle);
		cm.setMessageContent(messageContent);
		cm.setMessageStatus("05030100");
		cm.setModifyTime(new Date());
		this.consultantMessageService.add(cm);
		return this.responseService.responseSuccess("添加成功");
	}
	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestBody List<ConsultantMessage> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			ConsultantMessage cm =list.get(i);
			cm.setModifyTime(new Date());
			this.consultantMessageService.update(cm);
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestBody List<ConsultantMessage> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.consultantMessageService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除成功");
	}
	
}
