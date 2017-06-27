package hitwh.fanghh.manage.module.base.dao;


import hitwh.fanghh.manage.pojo.building.Activity;
import hitwh.fanghh.manage.pojo.building.InfoForComb;

import java.util.List;

public interface ActivityDao {
	public void add(Activity b);
	
	public void update(Activity b);
	
	public void delete(Activity b);
	
	public Activity getById(int id);

	public List<Activity> searchByHql(String hql);

	public List<Activity> getAll();
}
