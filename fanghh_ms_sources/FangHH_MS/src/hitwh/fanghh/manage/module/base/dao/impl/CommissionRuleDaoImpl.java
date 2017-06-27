package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.CommissionRuleDao;
import hitwh.fanghh.manage.pojo.building.CommissionRule;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class CommissionRuleDaoImpl extends BaseDaoImpl implements CommissionRuleDao {

	@Override
	public void add(CommissionRule c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(c);
	}

	@Override
	public void update(CommissionRule c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(c);
	}

	@Override
	public void delete(CommissionRule c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(c);
	}

	@Override
	public List<CommissionRule> getAll() {
		// TODO Auto-generated method stub
		String hql = "from CommissionRule";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public CommissionRule getById(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(CommissionRule.class, id);
	}

	@Override
	public List<CommissionRule> searchByHql(String hql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(hql);
	}

}
