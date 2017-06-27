package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.Activity;
import hitwh.fanghh.manage.pojo.building.Building;

import java.util.List;

public interface ActivityService {
	public void add(Activity b);
	
	public void update(Activity b);
	
	public void delete(Activity b);

	public List<Activity> searchByHql(String hql);

	public Activity getById(int id);

	public List<Activity> getAll();
	
}
