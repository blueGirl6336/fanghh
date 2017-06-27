package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.IntegralLevelDao;
import hitwh.fanghh.manage.pojo.building.IntegralLevel;
@Repository
public class IntegralLevelDaoImpl extends BaseDaoImpl implements IntegralLevelDao{

	@Override
	public void update(IntegralLevel i) {
		this.getHibernateTemplate().update(i);
	}

	@Override
	public void delete(IntegralLevel i) {
		this.getHibernateTemplate().delete(i);
	}

	@Override
	public IntegralLevel getById(int id) {
		return this.getHibernateTemplate().get(IntegralLevel.class, id);
	}
	@Override
	public List<IntegralLevel> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<IntegralLevel> getAll() {
		String hql = "from IntegralLevel";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public void add(IntegralLevel i) {
		this.getHibernateTemplate().save(i);
	}


}
