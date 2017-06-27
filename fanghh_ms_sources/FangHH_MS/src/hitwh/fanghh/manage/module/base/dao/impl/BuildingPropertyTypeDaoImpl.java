package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BuildingDao;
import hitwh.fanghh.manage.module.base.dao.BuildingPropertyTypeDao;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.BuildingPropertyType;
@Repository
public class BuildingPropertyTypeDaoImpl extends BaseDaoImpl implements BuildingPropertyTypeDao{
	@Override
	public void add(BuildingPropertyType b) {
		this.getHibernateTemplate().save(b);
	}

	@Override
	public void update(BuildingPropertyType b) {
		this.getHibernateTemplate().update(b);
	}

	@Override
	public void delete(BuildingPropertyType b) {
		this.getHibernateTemplate().delete(b);
	}

	@Override
	public BuildingPropertyType getById(int id) {
		return this.getHibernateTemplate().get(BuildingPropertyType.class, id);
	}
	@Override
	public List<BuildingPropertyType> getAll() {
		String hql = "from BuildingPropertyType";
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<BuildingPropertyType> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
}
