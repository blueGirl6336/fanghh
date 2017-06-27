package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ClearanceHouseInfoDao;
import hitwh.fanghh.manage.module.base.dao.PerferentialHouseInfoDao;
import hitwh.fanghh.manage.pojo.building.ClearanceHouseInfo;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseInfo;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class ClearanceHouseInfoDaoImpl extends BaseDaoImpl implements ClearanceHouseInfoDao{
	@Override
	public ClearanceHouseInfo getById(int id) {
		return this.getHibernateTemplate().get(ClearanceHouseInfo.class, id);
	}
	@Override
	public List<ClearanceHouseInfo> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<ClearanceHouseInfo> getAll() {
		String hql = "from ClearanceHouseInfo";
		return this.getHibernateTemplate().find(hql);
	}


	@Override
	public void add(ClearanceHouseInfo c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(c);
	}

	@Override
	public void update(ClearanceHouseInfo c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(c);
	}

	@Override
	public void delete(ClearanceHouseInfo c) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(c);
	}
	

}
