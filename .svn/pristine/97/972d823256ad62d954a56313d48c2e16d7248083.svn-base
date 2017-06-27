package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.ActivityDao;
import hitwh.fanghh.manage.module.base.service.ActivityService;
import hitwh.fanghh.manage.pojo.building.Activity;
import hitwh.fanghh.manage.pojo.building.Building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private ActivityDao activityDao;
	@Override
	public void add(Activity b) {
		// TODO Auto-generated method stub
		activityDao.add(b);
	}

	@Override
	public void update(Activity b) {
		// TODO Auto-generated method stub
		activityDao.update(b);
	}

	@Override
	public void delete(Activity b) {
		// TODO Auto-generated method stub
		activityDao.delete(b);
	}
	@Override
	public List<Activity> searchByHql(String hql) {
		
		return activityDao.searchByHql(hql);
	}
	@Override
	public Activity getById(int id) {
		return activityDao.getById(id);
	}
	@Override
	public List<Activity> getAll() {
		return activityDao.getAll();
	}
}
