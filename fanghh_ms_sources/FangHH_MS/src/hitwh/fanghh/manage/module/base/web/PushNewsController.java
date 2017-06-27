package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.BrokerService;
import hitwh.fanghh.manage.module.base.service.PushNewsService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.PushNews;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

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
@RequestMapping(value = "manage/pushNews")
@SessionAttributes({ "user" })
public class PushNewsController {
	@Autowired
	private PushNewsService pushNewsService;
	@Autowired
	private BrokerService brokerService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索推送消息消息按经纪人姓名，消息标题和消息内容
	 * @param brokerName 经纪人姓名
	 * @param title 消息标题
	 * @param content 消息内容
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> search(@RequestParam String brokerName,
			@RequestParam String title,@RequestParam String content) {
		StringBuilder hql = new StringBuilder(" from PushNews");
		boolean hasBrokerName =false;
		boolean hasTitle =false;
		if(null != brokerName && "" != brokerName) 
		{
			hasBrokerName = true;
			hql.append(" where broker.brokerName like '%" + brokerName+"%'");
		}
		if(null != title && "" != title) 
		{
			hasTitle = true;
			if (hasBrokerName)
			{
				hql.append(" and newsTitle like '%" + title+"%'");
			}else{
				hql.append(" where newsTitle like '%" + title+"%'");
			}
		}
		if(null != content && "" != content) 
		{
			if (hasBrokerName || hasTitle)
			{
				hql.append(" and newsContent like '%" + content+"%'");
			}else{
				hql.append(" where newsContent like '%" + content+"%'");
			}
		}
		List<PushNews> pushNews = 
				this.pushNewsService.searchByHql(hql.toString());
		return responseService.responseListMap(pushNews);
	}
	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<PushNews> pushNews = 
				this.pushNewsService.getAll();
		return responseService.responseListMap(pushNews);
	}
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam Integer brokerId,
			@RequestParam String title,@RequestParam String content ,@RequestParam String newsType) {
		PushNews pushNews = new PushNews();
		pushNews.setBroker(brokerService.getById(brokerId));
		pushNews.setNewsContent(content);
		pushNews.setNewsTitle(title);
		pushNews.setNewsStatus("05010200");
		pushNews.setSendTime(new Date());
		pushNews.setNewsType(newsType);
		this.pushNewsService.add(pushNews);
		return this.responseService.responseSuccess("添加成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestBody List<PushNews> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.pushNewsService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<PushNews> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.pushNewsService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除成功");
	}
}
