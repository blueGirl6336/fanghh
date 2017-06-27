package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.SalesDirectorDao;
import hitwh.fanghh.manage.pojo.building.SalesDirector;
@Repository
public class SalesDirectorDaoImpl extends BaseDaoImpl implements SalesDirectorDao{

	@Override
	public void update(SalesDirector s) {
		this.getHibernateTemplate().update(s);
	}

	@Override
	public void delete(SalesDirector s) {
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public SalesDirector getById(int id) {
		return this.getHibernateTemplate().get(SalesDirector.class, id);
	}
	@Override
	public List<SalesDirector> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<SalesDirector> getAll() {
		String hql = "from SalesDirector";
		return this.getHibernateTemplate().find(hql);
	}


}
