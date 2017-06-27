package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.StrategyPlacardDao;
import hitwh.fanghh.manage.module.base.dao.TalksPlacardDao;
import hitwh.fanghh.manage.pojo.building.StrategyPlacard;
import hitwh.fanghh.manage.pojo.building.TalksPlacard;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TalksPlacardDaoImpl extends BaseDaoImpl implements  TalksPlacardDao{

	
	@Override
	public void add(TalksPlacard t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(TalksPlacard t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(TalksPlacard t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public TalksPlacard getById(int id) {
		return this.getHibernateTemplate().get(TalksPlacard.class, id);
	}
	@Override
	public List<TalksPlacard> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<TalksPlacard> getAll() {
		String hql = "from TalksPlacard";
		return this.getHibernateTemplate().find(hql);
	}
}
