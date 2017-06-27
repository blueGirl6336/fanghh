package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.PerferentialHouseInfoDao;
import hitwh.fanghh.manage.module.base.dao.PerferentialHouseListDao;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseInfo;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseList;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class PerferentialHouseListDaoImpl extends BaseDaoImpl implements PerferentialHouseListDao{

	

	@Override
	public PerferentialHouseList getById(int id) {
		return this.getHibernateTemplate().get(PerferentialHouseList.class, id);
	}
	@Override
	public List<PerferentialHouseList> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<PerferentialHouseList> getAll() {
		String hql = "from PerferentialHouseList";
		return this.getHibernateTemplate().find(hql);
	}


	@Override
	public void add(PerferentialHouseList p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(p);
	}

	@Override
	public void update(PerferentialHouseList p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(p);
	}

	@Override
	public void delete(PerferentialHouseList p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(p);
	}

}
