package hitwh.fanghh.manage.module.base.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.IntegralRule;

public interface IntegralRuleService {
	public void update(IntegralRule i);
	
	public void delete(IntegralRule i);

	public List<IntegralRule> searchByHql(String hql);

	public IntegralRule getById(int id);

	public List<IntegralRule> getAll();
	
}
