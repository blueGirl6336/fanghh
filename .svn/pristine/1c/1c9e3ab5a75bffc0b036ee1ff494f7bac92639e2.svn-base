package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.ClearanceHouseInfoDao;
import hitwh.fanghh.manage.module.base.dao.GroupPurchaseInfoDao;
import hitwh.fanghh.manage.module.base.service.ClearanceHouseInfoService;
import hitwh.fanghh.manage.module.base.service.GroupPurchaseInfoService;
import hitwh.fanghh.manage.pojo.building.ClearanceHouseInfo;
import hitwh.fanghh.manage.pojo.building.GroupPurchaseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GroupPurchaseInfoServiceImpl implements GroupPurchaseInfoService{
	@Autowired
	private GroupPurchaseInfoDao groupPurchaseInfoDao;
	@Override
	public void add(GroupPurchaseInfo g) {
		// TODO Auto-generated method stub
		groupPurchaseInfoDao.add(g);
	}

	@Override
	public void update(GroupPurchaseInfo g) {
		// TODO Auto-generated method stub
		groupPurchaseInfoDao.update(g);
	}

	@Override
	public void delete(Integer g) {
		// TODO Auto-generated method stub
		groupPurchaseInfoDao.delete(g);
	}
	@Override
	public List<GroupPurchaseInfo> searchByHql(String hql) {
		
		return groupPurchaseInfoDao.searchByHql(hql);
	}
	@Override
	public GroupPurchaseInfo getById(int id) {
		return groupPurchaseInfoDao.getById(id);
	}
	@Override
	public List<GroupPurchaseInfo> getAll() {
		return groupPurchaseInfoDao.getAll();
	}

	@Override
	public List<GroupPurchaseInfo> searchByActivityId(String activityId){
		StringBuilder hql = new StringBuilder("select g from GroupPurchaseInfo as g where g.activityId = '" + activityId + "'");
		return groupPurchaseInfoDao.searchByHql(hql.toString());
	}
}
