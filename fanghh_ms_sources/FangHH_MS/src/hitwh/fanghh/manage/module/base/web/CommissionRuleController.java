package hitwh.fanghh.manage.module.base.web;

import hitwh.fanghh.manage.module.base.service.CommissionRuleService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.CommissionRule;
import hitwh.fanghh.manage.util.ExtResponseJsonService;

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
@RequestMapping(value = "manage/commissionRule")
@SessionAttributes({ "user" })
public class CommissionRuleController {

	@Autowired
	private CommissionRuleService commissionRuleService;
	@Autowired
	private ExtResponseJsonService responseService;

	// 添加新项
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam double plateProportional,
			@RequestParam double teamLeaderProportion,
			@RequestParam double brokerLeaderProportional,
			@RequestParam double storeLeaderProportion,
			@RequestParam String corporateRule,
			@RequestParam double regionProportional,
			@RequestParam String ruleType, @RequestParam String ruleStatus,
			@RequestParam int building) {
		CommissionRule c = new CommissionRule();
		c.setCreateTime(new Date());
		c.setPlateProportional(plateProportional);
		c.setTeamLeaderProportion(teamLeaderProportion);
		c.setBrokerLeaderProportional(brokerLeaderProportional);
		c.setStoreLeaderProportion(storeLeaderProportion);
		c.setCorporateRule(corporateRule);
		c.setRegionProportional(regionProportional);
		c.setBuildingId(building);
		c.setRuleType(ruleType);
		c.setStatus(ruleStatus);
		this.commissionRuleService.add(c);
		return this.responseService.responseSuccess("修改成功");
	}

	// 更新项
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> update(@RequestParam double plateProportional,
			@RequestParam double teamLeaderProportion,
			@RequestParam double brokerLeaderProportional,
			@RequestParam double storeLeaderProportion,
			@RequestParam String corporateRule,
			@RequestParam double regionProportional,
			@RequestParam String ruleType, @RequestParam String ruleStatus,
			@RequestParam int building) {
		CommissionRule c = commissionRuleService.searchByBuildingIdAndRuleType(
				building, ruleType);
		c.setPlateProportional(plateProportional);
		c.setTeamLeaderProportion(teamLeaderProportion);
		c.setBrokerLeaderProportional(brokerLeaderProportional);
		c.setStoreLeaderProportion(storeLeaderProportion);
		c.setCorporateRule(corporateRule);
		c.setRegionProportional(regionProportional);
		c.setBuildingId(building);
		c.setRuleType(ruleType);
		c.setStatus(ruleStatus);
		this.commissionRuleService.update(c);
		return this.responseService.responseSuccess("修改成功");
	}

	// 删除项
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@ModelAttribute User user,
			@RequestBody List<CommissionRule> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			this.commissionRuleService.delete(list.get(i));
		}
		return this.responseService.responseSuccess("修改成功");
	}

	// 获取所有的城市
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		List<CommissionRule> commissionRule = this.commissionRuleService
				.getAll();
		return responseService.responseListMap(commissionRule);
	}

	// 获取选中的城市
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> search(@RequestParam Integer buildingId) {
		List<CommissionRule> pList = new ArrayList<CommissionRule>();
		StringBuilder hql = new StringBuilder(
				"select c from CommissionRule as c " + "where c.buildingId = "
						+ buildingId);

		pList = this.commissionRuleService.searchByHql(hql.toString());
		return this.responseService.responseListMap(pList);
	}
}
