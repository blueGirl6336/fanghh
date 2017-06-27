package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.CommissionRule;

import java.util.List;

public interface CommissionRuleService {
	public void add(CommissionRule c);

	public void update(CommissionRule c);

	public void delete(CommissionRule c);

	public List<CommissionRule> getAll();
	
	public CommissionRule getById(int id);

	public List<CommissionRule> searchByHql(String hql);
	
	public CommissionRule searchByBuildingIdAndRuleType(int buildingId,String ruleType);
}
