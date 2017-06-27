package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.CityDao;
import hitwh.fanghh.manage.module.base.dao.UnitDao;
import hitwh.fanghh.manage.pojo.building.City;
import hitwh.fanghh.manage.pojo.building.Unit;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class CityDaoImpl extends BaseDaoImpl implements  CityDao{

	
	@Override
	public void add(City c) {
		this.getHibernateTemplate().save(c);
	}

	@Override
	public void update(City c) {
		this.getHibernateTemplate().update(c);
	}

	@Override
	public void delete(City c) {
		this.getHibernateTemplate().delete(c);
	}

	@Override
	public City getById(int id) {
		return this.getHibernateTemplate().get(City.class, id);
	}
	@Override
	public List<City> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<City> getAll() {
		String hql = "from City";
		return this.getHibernateTemplate().find(hql);
	}
}
