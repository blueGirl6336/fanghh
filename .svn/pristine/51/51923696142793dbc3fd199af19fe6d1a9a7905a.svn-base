package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.dao.UserDao;
import hitwh.fanghh.manage.module.base.dao.BuildingDao;
import hitwh.fanghh.manage.module.base.service.BuildingService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
@Service
public class BuildingServiceImpl implements BuildingService{

	@Autowired
	private BuildingDao buildingDao;
	@Override
	public void add(Building b) {
		// TODO Auto-generated method stub
		buildingDao.add(b);
	}

	@Override
	public void update(Building b) {
		// TODO Auto-generated method stub
		buildingDao.update(b);
	}

	@Override
	public void delete(Building b) {
		// TODO Auto-generated method stub
		buildingDao.delete(b);
	}
	@Override
	public List<Building> searchByHql(String hql) {
		
		return buildingDao.searchByHql(hql);
	}
	@Override
	public Building getById(int id) {
		return buildingDao.getById(id);
	}
	@Override
	public List<Building> getAll() {
		return buildingDao.getAll();
	}
	@Override
	public List<InfoForComb> getAllForCon() {
		// TODO Auto-generated method stub
		return buildingDao.getAllForCon();
	}
}
