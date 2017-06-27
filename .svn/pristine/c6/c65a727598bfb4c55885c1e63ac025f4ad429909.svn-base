package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BuildingDao;
import hitwh.fanghh.manage.module.base.dao.HouseDao;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.House;
@Repository
public class HouseDaoImpl extends BaseDaoImpl implements HouseDao{
	@Override
	public void add(House h) {
		this.getHibernateTemplate().save(h);
	}

	@Override
	public void update(House h) {
		this.getHibernateTemplate().update(h);
	}

	@Override
	public void delete(House h) {
		this.getHibernateTemplate().delete(h);
	}

	@Override
	public House getById(int id) {
		return this.getHibernateTemplate().get(House.class, id);
	}
	@Override
	public List<House> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<House> getAll() {
		String hql = "from House";
		return this.getHibernateTemplate().find(hql);
	}
}
