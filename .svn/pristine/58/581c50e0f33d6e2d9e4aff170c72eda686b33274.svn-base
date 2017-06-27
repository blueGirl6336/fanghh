package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.PushNewsDao;
import hitwh.fanghh.manage.pojo.building.PushNews;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class PushNewsDaoImpl extends BaseDaoImpl implements  PushNewsDao{

	
	@Override
	public void add(PushNews c) {
		this.getHibernateTemplate().save(c);
	}

	@Override
	public void update(PushNews c) {
		this.getHibernateTemplate().update(c);
	}

	@Override
	public void delete(PushNews c) {
		this.getHibernateTemplate().delete(c);
	}

	@Override
	public PushNews getById(int id) {
		return this.getHibernateTemplate().get(PushNews.class, id);
	}
	@Override
	public List<PushNews> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<PushNews> getAll() {
		String hql = "from PushNews";
		return this.getHibernateTemplate().find(hql);
	}
}
