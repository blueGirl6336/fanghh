package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.RegionDao;
import hitwh.fanghh.manage.module.base.dao.RoofBeamDao;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
import hitwh.fanghh.manage.pojo.building.Region;
import hitwh.fanghh.manage.pojo.building.RoofBeam;
import hitwh.fanghh.manage.pojo.building.Unit;
@Repository
public class RoofBeamDaoImpl extends BaseDaoImpl implements  RoofBeamDao{
	@Override
	public void add(RoofBeam r) {
		this.getHibernateTemplate().save(r);
	}

	@Override
	public void update(RoofBeam r) {
		this.getHibernateTemplate().update(r);
	}

	@Override
	public void delete(RoofBeam r) {
		this.getHibernateTemplate().delete(r);
	}

	@Override
	public RoofBeam getById(int id) {
		return this.getHibernateTemplate().get(RoofBeam.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RoofBeam> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RoofBeam> getAll() {
		String hql = "from RoofBeam";
		return this.getHibernateTemplate().find(hql);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<InfoForComb> getAllForCon() {
		// TODO Auto-generated method stub
		String hql = "select new hitwh.fanghh.manage.pojo.building.InfoForComb(" +
				"r.roofId,r.roofName) from RoofBeam as r";
		return this.getHibernateTemplate().find(hql);
	}
}
