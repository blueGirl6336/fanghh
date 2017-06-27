package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BuildingDao;
import hitwh.fanghh.manage.module.base.dao.PerferentialHouseInfoDao;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseInfo;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class PerferentialHouseInfoDaoImpl extends BaseDaoImpl implements PerferentialHouseInfoDao{

	

	@Override
	public PerferentialHouseInfo getById(int id) {
		return this.getHibernateTemplate().get(PerferentialHouseInfo.class, id);
	}
	@Override
	public List<PerferentialHouseInfo> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<PerferentialHouseInfo> getAll() {
		String hql = "from PerferentialHouseInfo";
		return this.getHibernateTemplate().find(hql);
	}


	@Override
	public void add(PerferentialHouseInfo p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(p);
	}

	@Override
	public void update(PerferentialHouseInfo p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(p);
	}

	@Override
	public void delete(PerferentialHouseInfo p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(p);
	}
	
}
