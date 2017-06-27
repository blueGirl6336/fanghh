package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.DeveloperDao;
import hitwh.fanghh.manage.module.base.dao.PropertyDao;
import hitwh.fanghh.manage.pojo.building.Developer;
import hitwh.fanghh.manage.pojo.building.Property;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class PropertyDaoImpl extends BaseDaoImpl implements PropertyDao{
	@Override
	public void add(Property p) {
		this.getHibernateTemplate().save(p);
	}

	@Override
	public void update(Property p) {
		this.getHibernateTemplate().update(p);
	}

	@Override
	public void delete(Property p) {
		this.getHibernateTemplate().delete(p);
	}

	@Override
	public Property getById(int id) {
		return this.getHibernateTemplate().get(Property.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Property> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<Property> getAll() {
		String hql = "from Property";
		return this.getHibernateTemplate().find(hql);
	}

}
