package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.ClearanceHouseList;
import hitwh.fanghh.manage.pojo.building.GroupPurchaseHouseList;

import java.util.List;

public interface GroupPurchaseHouseListService {
	public void add(GroupPurchaseHouseList g);
	
	public void update(GroupPurchaseHouseList g);
	
	public void delete(GroupPurchaseHouseList g);

	public List<GroupPurchaseHouseList> searchByHql(String hql);
	
	public GroupPurchaseHouseList getById(int id);

	public List<GroupPurchaseHouseList> getByActivityId(String activityId);
}
