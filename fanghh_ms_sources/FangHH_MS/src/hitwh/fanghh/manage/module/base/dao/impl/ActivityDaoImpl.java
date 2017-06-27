package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ActivityDao;
import hitwh.fanghh.manage.pojo.building.Activity;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.InfoForComb;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class ActivityDaoImpl extends BaseDaoImpl implements ActivityDao{
	@Override
	public void add(Activity b) {
		this.getHibernateTemplate().save(b);
	}

	@Override
	public void update(Activity b) {
		this.getHibernateTemplate().update(b);
	}

	@Override
	public void delete(Activity b) {
		this.getHibernateTemplate().delete(b);
	}

	@Override
	public Activity getById(int id) {
		return this.getHibernateTemplate().get(Activity.class, id);
	}
	@Override
	public List<Activity> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<Activity> getAll() {
		String hql = "from Activity";
		return this.getHibernateTemplate().find(hql);
	}

}
