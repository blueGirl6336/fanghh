package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.CommissionRule;

import java.util.List;

public interface CommissionRuleDao {

	public void add(CommissionRule c);

	public void update(CommissionRule c);

	public void delete(CommissionRule c);

	public List<CommissionRule> getAll();
	
	public CommissionRule getById(int id);

	public List<CommissionRule> searchByHql(String hql);
}
