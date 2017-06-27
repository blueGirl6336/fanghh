package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.ClearanceHouseInfoDao;
import hitwh.fanghh.manage.module.base.service.ClearanceHouseInfoService;
import hitwh.fanghh.manage.pojo.building.ClearanceHouseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	@Service
	public class ClearanceHouseInfoServiceImpl implements ClearanceHouseInfoService{
	@Autowired
	private ClearanceHouseInfoDao clearanceHouseInfoDao;
	@Override
	public void add(ClearanceHouseInfo c) {
		// TODO Auto-generated method stub
		clearanceHouseInfoDao.add(c);
	}

	@Override
	public void update(ClearanceHouseInfo c) {
		// TODO Auto-generated method stub
		clearanceHouseInfoDao.update(c);
	}

	@Override
	public void delete(ClearanceHouseInfo c) {
		// TODO Auto-generated method stub
		clearanceHouseInfoDao.delete(c);
	}
	@Override
	public List<ClearanceHouseInfo> searchByHql(String hql) {
		
		return clearanceHouseInfoDao.searchByHql(hql);
	}
	@Override
	public ClearanceHouseInfo getById(int id) {
		return clearanceHouseInfoDao.getById(id);
	}
	@Override
	public List<ClearanceHouseInfo> getAll() {
		return clearanceHouseInfoDao.getAll();
	}

	@Override
	public List<ClearanceHouseInfo> searchByActivityId(String activityId) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("select c from ClearanceHouseInfo as c where c.activityId = '" + activityId + "'");
		return clearanceHouseInfoDao.searchByHql(hql.toString());
	}
}
