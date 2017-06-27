package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.PerferentialHouseInfoDao;
import hitwh.fanghh.manage.module.base.service.PerferentialHouseInfoService;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PerferentialHouseInfoServiceImpl implements PerferentialHouseInfoService{

	@Autowired
	private PerferentialHouseInfoDao perferentialHouseInfoDao;
	@Override
	public void add(PerferentialHouseInfo p) {
		// TODO Auto-generated method stub
		perferentialHouseInfoDao.add(p);
	}

	@Override
	public void update(PerferentialHouseInfo p) {
		// TODO Auto-generated method stub
		perferentialHouseInfoDao.update(p);
	}

	@Override
	public void delete(PerferentialHouseInfo p) {
		// TODO Auto-generated method stub
		perferentialHouseInfoDao.delete(p);
	}
	@Override
	public List<PerferentialHouseInfo> searchByHql(String hql) {
		
		return perferentialHouseInfoDao.searchByHql(hql);
	}
	@Override
	public PerferentialHouseInfo getById(int id) {
		return perferentialHouseInfoDao.getById(id);
	}
	@Override
	public List<PerferentialHouseInfo> getAll() {
		return perferentialHouseInfoDao.getAll();
	}

	@Override
	public List<PerferentialHouseInfo> searchByActivityId(String activityId) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("select p from PerferentialHouseInfo as p where activityId = '" + activityId + "'");
		return perferentialHouseInfoDao.searchByHql(hql.toString());
	}
}
