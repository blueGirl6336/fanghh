package hitwh.fanghh.manage.module.base.web;


import hitwh.fanghh.manage.module.base.service.BrokerService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

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
@RequestMapping(value = "manage/broker")
@SessionAttributes({ "user" })
public class BrokerController {
	@Autowired
	private BrokerService brokerService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索经纪人按经纪人姓名
	 * @param broker 经纪人姓名
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> search(@RequestParam String broker) {
		if(broker == null || "".equals(broker)) 
			return responseService.responseError("经纪人名为空");
		StringBuilder hql = new StringBuilder(" from Broker as b where brokerName like '%" + broker + "%'");
		List<Broker> city = 
				this.brokerService.searchByHql(hql.toString());
		return responseService.responseListMap(city);
	}
	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<Broker> brokers = 
				this.brokerService.getAll();
		
		return responseService.responseListMap(brokers);
	}
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<Broker> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.brokerService.add(list.get(i));
		}
		return this.responseService.responseSuccess("添加成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<Broker> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.brokerService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<Broker> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.brokerService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除成功");
	}
}
