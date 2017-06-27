package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BuildingDao;
import hitwh.fanghh.manage.module.base.dao.BuildingSellingPointDao;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.BuildingPropertyType;
import hitwh.fanghh.manage.pojo.building.BuildingSellingPoint;
@Repository
public class BuildingSellingPointDaoImpl extends BaseDaoImpl implements BuildingSellingPointDao{
	@Override
	public void add(BuildingSellingPoint b) {
		this.getHibernateTemplate().save(b);
	}

	@Override
	public void update(BuildingSellingPoint b) {
		this.getHibernateTemplate().update(b);
	}

	@Override
	public void delete(BuildingSellingPoint b) {
		this.getHibernateTemplate().delete(b);
	}

	@Override
	public BuildingSellingPoint getById(int id) {
		return this.getHibernateTemplate().get(BuildingSellingPoint.class, id);
	}
	@Override
	public List<BuildingSellingPoint> getAll() {
		String hql = "from BuildingSellingPoint";
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<BuildingSellingPoint> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
}
