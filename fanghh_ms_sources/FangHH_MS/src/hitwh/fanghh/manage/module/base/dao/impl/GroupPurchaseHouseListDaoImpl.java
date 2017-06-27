package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ClearanceHouseInfoDao;
import hitwh.fanghh.manage.module.base.dao.GroupPurchaseHouseListDao;
import hitwh.fanghh.manage.pojo.building.ClearanceHouseInfo;
import hitwh.fanghh.manage.pojo.building.GroupPurchaseHouseList;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GroupPurchaseHouseListDaoImpl extends BaseDaoImpl implements GroupPurchaseHouseListDao{
	@Override
	public GroupPurchaseHouseList getById(int id) {
		return this.getHibernateTemplate().get(GroupPurchaseHouseList.class, id);
	}
	@Override
	public List<GroupPurchaseHouseList> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<GroupPurchaseHouseList> getByActivityId(String activityId) {
		String hql = "from GroupPurchaseHouseList where activityId = ?";
		return this.getHibernateTemplate().find(hql,activityId);
	}


	@Override
	public void add(GroupPurchaseHouseList g) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(g);
	}

	@Override
	public void update(GroupPurchaseHouseList g) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(g);
	}

	@Override
	public void delete(GroupPurchaseHouseList g) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(g);
	}

}
