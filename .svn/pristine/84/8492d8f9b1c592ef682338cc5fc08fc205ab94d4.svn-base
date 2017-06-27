package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ClearanceHouseListDao;
import hitwh.fanghh.manage.module.base.dao.PerferentialHouseListDao;
import hitwh.fanghh.manage.pojo.building.ClearanceHouseList;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseList;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class ClearanceHouseListDaoImpl extends BaseDaoImpl implements ClearanceHouseListDao{

	

	@Override
	public ClearanceHouseList getById(int id) {
		return this.getHibernateTemplate().get(ClearanceHouseList.class, id);
	}
	@Override
	public List<ClearanceHouseList> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<ClearanceHouseList> getAll() {
		String hql = "from ClearanceHouseList";
		return this.getHibernateTemplate().find(hql);
	}


	@Override
	public void add(ClearanceHouseList p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(p);
	}

	@Override
	public void update(ClearanceHouseList p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(p);
	}

	@Override
	public void delete(ClearanceHouseList p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(p);
	}


}
