package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.ClearanceHouseInfo;
import hitwh.fanghh.manage.pojo.building.GroupPurchaseHouseList;

import java.util.List;

public interface GroupPurchaseHouseListDao {
	public void add(GroupPurchaseHouseList g);
	
	public void update(GroupPurchaseHouseList g);
	
	public void delete(GroupPurchaseHouseList g);
	
	public GroupPurchaseHouseList getById(int id);

	public List<GroupPurchaseHouseList> searchByHql(String hql);

	public List<GroupPurchaseHouseList> getByActivityId(String activityId);
}
