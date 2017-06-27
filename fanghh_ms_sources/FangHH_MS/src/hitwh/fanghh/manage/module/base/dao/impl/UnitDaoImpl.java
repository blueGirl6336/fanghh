package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.RoofBeamDao;
import hitwh.fanghh.manage.module.base.dao.UnitDao;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
import hitwh.fanghh.manage.pojo.building.RoofBeam;
import hitwh.fanghh.manage.pojo.building.Unit;

@Repository
public class UnitDaoImpl extends BaseDaoImpl implements  UnitDao{

	
	@Override
	public void add(Unit u) {
		this.getHibernateTemplate().save(u);
	}

	@Override
	public void update(Unit u) {
		this.getHibernateTemplate().update(u);
	}

	@Override
	public void delete(Unit u) {
		this.getHibernateTemplate().delete(u);
	}

	@Override
	public Unit getById(int id) {
		return this.getHibernateTemplate().get(Unit.class, id);
	}
	@Override
	public List<Unit> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<Unit> getAll() {
		String hql = "from Unit";
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<InfoForComb> getAllForCon() {
		// TODO Auto-generated method stub
		String hql = "select new hitwh.fanghh.manage.pojo.building.InfoForComb(" +
				"u.unitId,u.unitCode) from Unit as u";
		return this.getHibernateTemplate().find(hql);
	}
}
