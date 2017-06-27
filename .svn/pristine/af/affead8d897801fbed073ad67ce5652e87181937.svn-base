package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.StrategyLabelCatgDao;
import hitwh.fanghh.manage.module.base.dao.StrategyPlacardDao;
import hitwh.fanghh.manage.pojo.building.StrategyLabelCatg;
import hitwh.fanghh.manage.pojo.building.StrategyPlacard;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StrategyPlacardDaoImpl extends BaseDaoImpl implements  StrategyPlacardDao{

	
	@Override
	public void add(StrategyPlacard s) {
		this.getHibernateTemplate().save(s);
	}

	@Override
	public void update(StrategyPlacard s) {
		this.getHibernateTemplate().update(s);
	}

	@Override
	public void delete(StrategyPlacard s) {
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public StrategyPlacard getById(int id) {
		return this.getHibernateTemplate().get(StrategyPlacard.class, id);
	}
	@Override
	public List<StrategyPlacard> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<StrategyPlacard> getAll() {
		String hql = "from StrategyPlacard";
		return this.getHibernateTemplate().find(hql);
	}
}
