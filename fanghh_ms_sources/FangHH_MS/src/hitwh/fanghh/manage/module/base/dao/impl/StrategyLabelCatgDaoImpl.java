package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.StrategyContentDao;
import hitwh.fanghh.manage.module.base.dao.StrategyLabelCatgDao;
import hitwh.fanghh.manage.pojo.building.StrategyContent;
import hitwh.fanghh.manage.pojo.building.StrategyLabelCatg;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StrategyLabelCatgDaoImpl extends BaseDaoImpl implements  StrategyLabelCatgDao{

	
	@Override
	public void add(StrategyLabelCatg s) {
		this.getHibernateTemplate().save(s);
	}

	@Override
	public void update(StrategyLabelCatg s) {
		this.getHibernateTemplate().update(s);
	}

	@Override
	public void delete(StrategyLabelCatg s) {
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public StrategyLabelCatg getById(int id) {
		return this.getHibernateTemplate().get(StrategyLabelCatg.class, id);
	}
	@Override
	public List<StrategyLabelCatg> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<StrategyLabelCatg> getAll() {
		String hql = "from StrategyLabelCatg";
		return this.getHibernateTemplate().find(hql);
	}
}
