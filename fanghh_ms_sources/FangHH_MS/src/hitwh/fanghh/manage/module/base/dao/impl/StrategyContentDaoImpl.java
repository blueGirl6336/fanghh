package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ShareInfoDao;
import hitwh.fanghh.manage.module.base.dao.StrategyContentDao;
import hitwh.fanghh.manage.pojo.building.ShareInfo;
import hitwh.fanghh.manage.pojo.building.StrategyContent;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StrategyContentDaoImpl extends BaseDaoImpl implements  StrategyContentDao{

	
	@Override
	public void add(StrategyContent s) {
		this.getHibernateTemplate().save(s);
	}

	@Override
	public void update(StrategyContent s) {
		this.getHibernateTemplate().update(s);
	}

	@Override
	public void delete(StrategyContent s) {
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public StrategyContent getById(int id) {
		return this.getHibernateTemplate().get(StrategyContent.class, id);
	}
	@Override
	public List<StrategyContent> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<StrategyContent> getAll() {
		String hql = "from StrategyContent";
		return this.getHibernateTemplate().find(hql);
	}

}
