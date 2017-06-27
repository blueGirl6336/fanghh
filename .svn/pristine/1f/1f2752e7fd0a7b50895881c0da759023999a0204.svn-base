package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.SurroundFacilityDao;
import hitwh.fanghh.manage.module.base.dao.UnitDao;
import hitwh.fanghh.manage.pojo.building.SurroundFacility;
import hitwh.fanghh.manage.pojo.building.Unit;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class SurroundFacilityDaoImpl extends BaseDaoImpl implements  SurroundFacilityDao{

	
	@Override
	public void add(SurroundFacility s) {
		this.getHibernateTemplate().save(s);
	}

	@Override
	public void update(SurroundFacility s) {
		this.getHibernateTemplate().update(s);
	}

	@Override
	public void delete(SurroundFacility s) {
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public SurroundFacility getById(int id) {
		return this.getHibernateTemplate().get(SurroundFacility.class, id);
	}
	@Override
	public List<SurroundFacility> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<SurroundFacility> getAll() {
		String hql = "from SurroundFacility";
		return this.getHibernateTemplate().find(hql);
	}

}
