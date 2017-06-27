package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BuildingDao;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
@Repository
public class BuildingDaoImpl extends BaseDaoImpl implements BuildingDao{
	@Override
	public void add(Building b) {
		this.getHibernateTemplate().save(b);
	}

	@Override
	public void update(Building b) {
		this.getHibernateTemplate().update(b);
	}

	@Override
	public void delete(Building b) {
		this.getHibernateTemplate().delete(b);
	}

	@Override
	public Building getById(int id) {
		return this.getHibernateTemplate().get(Building.class, id);
	}
	@Override
	public List<Building> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<Building> getAll() {
		String hql = "from Building";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<InfoForComb> getAllForCon() {
		// TODO Auto-generated method stub
		String hql = "select new hitwh.fanghh.manage.pojo.building.InfoForComb(" +
				"b.buildingId,b.buildingName) from Building as b";
		return this.getHibernateTemplate().find(hql);
	}

}
