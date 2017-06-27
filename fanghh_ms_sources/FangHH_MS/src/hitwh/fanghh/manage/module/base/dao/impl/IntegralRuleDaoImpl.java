package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.IntegralRuleDao;
import hitwh.fanghh.manage.pojo.building.IntegralRule;
@Repository
public class IntegralRuleDaoImpl extends BaseDaoImpl implements IntegralRuleDao{

	@Override
	public void update(IntegralRule i) {
		this.getHibernateTemplate().update(i);
	}

	@Override
	public void delete(IntegralRule i) {
		this.getHibernateTemplate().delete(i);
	}

	@Override
	public IntegralRule getById(int id) {
		return this.getHibernateTemplate().get(IntegralRule.class, id);
	}
	@Override
	public List<IntegralRule> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<IntegralRule> getAll() {
		String hql = "from IntegralRule";
		return this.getHibernateTemplate().find(hql);
	}


}
