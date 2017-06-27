package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.IntegralRecordService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.IntegralRecord;
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
@RequestMapping(value = "manage/integralRecord")
@SessionAttributes({ "user" })
public class IntegralRecordController {
	@Autowired
	private IntegralRecordService integralRecordService;
	@Autowired
	private ExtResponseJsonService responseService;
	
	/**
	 * 搜索用户积分记录按用户名
	 * @param userName 用户名
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> search(@RequestParam String userName) {
		StringBuilder hql = new StringBuilder("from IntegralRecord ");
		if(userName != null && "" != userName ) 
		{
			hql.append(" where user.username like '%" + userName+"%'");
		}
		List<IntegralRecord> integralrecord = 
				this.integralRecordService.searchByHql(hql.toString());
		return responseService.responseListMap(integralrecord);
	}
	// 获取所有信息
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<IntegralRecord> integralrecord = 
				this.integralRecordService.getAll();
		return responseService.responseListMap(integralrecord);
	}
	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@ModelAttribute User user, @RequestBody List<IntegralRecord> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			
			this.integralRecordService.add(list.get(i));
		}
		return this.responseService.responseSuccess("添加成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@ModelAttribute User user, @RequestBody List<IntegralRecord> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.integralRecordService.update(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	
	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user, @RequestBody List<IntegralRecord> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.integralRecordService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("删除成功");
	}
}
