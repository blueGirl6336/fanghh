package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.ClearanceHouseInfo;
import hitwh.fanghh.manage.pojo.building.GroupPurchaseInfo;

import java.util.List;

public interface GroupPurchaseInfoService {
	public void add(GroupPurchaseInfo g);
	
	public void update(GroupPurchaseInfo g);
	
	public void delete(Integer gpId);

	public List<GroupPurchaseInfo> searchByHql(String hql);
	
	public GroupPurchaseInfo getById(int id);

	public List<GroupPurchaseInfo> getAll();
	
	public List<GroupPurchaseInfo> searchByActivityId(String activityId);
}
