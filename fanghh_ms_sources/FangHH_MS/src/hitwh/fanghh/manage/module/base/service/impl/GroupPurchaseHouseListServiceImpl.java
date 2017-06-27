package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.GroupPurchaseHouseListDao;
import hitwh.fanghh.manage.module.base.dao.PerferentialHouseListDao;
import hitwh.fanghh.manage.module.base.service.GroupPurchaseHouseListService;
import hitwh.fanghh.manage.module.base.service.PerferentialHouseListService;
import hitwh.fanghh.manage.pojo.building.GroupPurchaseHouseList;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupPurchaseHouseListServiceImpl  implements GroupPurchaseHouseListService{

	@Autowired
	private  GroupPurchaseHouseListDao groupPurchaseHouseListDao;
	@Override
	public void add( GroupPurchaseHouseList p) {
		// TODO Auto-generated method stub
		groupPurchaseHouseListDao.add(p);
	}

	@Override
	public void update( GroupPurchaseHouseList p) {
		// TODO Auto-generated method stub
		groupPurchaseHouseListDao.update(p);
	}

	@Override
	public void delete( GroupPurchaseHouseList p) {
		// TODO Auto-generated method stub
		groupPurchaseHouseListDao.delete(p);
	}
	@Override
	public List< GroupPurchaseHouseList> searchByHql(String hql) {
		
		return groupPurchaseHouseListDao.searchByHql(hql);
	}
	@Override
	public  GroupPurchaseHouseList getById(int id) {
		return groupPurchaseHouseListDao.getById(id);
	}
	@Override
	public List< GroupPurchaseHouseList> getByActivityId(String activityId) {
		return groupPurchaseHouseListDao.getByActivityId(activityId);
	}

}
