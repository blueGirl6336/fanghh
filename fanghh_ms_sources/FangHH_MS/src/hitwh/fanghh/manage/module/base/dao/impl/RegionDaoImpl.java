package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BuildingDao;
import hitwh.fanghh.manage.module.base.dao.RegionDao;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.Region;
@Repository
public class RegionDaoImpl extends BaseDaoImpl implements RegionDao{
	@Override
	public void add(Region r) {
		this.getHibernateTemplate().save(r);
	}

	@Override
	public void update(Region r) {
		this.getHibernateTemplate().update(r);
	}

	@Override
	public void delete(Region r) {
		this.getHibernateTemplate().delete(r);
	}

	@Override
	public Region getById(int id) {
		return this.getHibernateTemplate().get(Region.class, id);
	}
	@Override
	public List<Region> getAll() {
		String hql = "from Region";
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<Region> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
}
