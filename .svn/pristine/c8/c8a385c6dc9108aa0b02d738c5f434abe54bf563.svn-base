package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import hitwh.fanghh.manage.module.base.dao.BuildingDao;
import hitwh.fanghh.manage.module.base.dao.BuildingSellingPointDao;
import hitwh.fanghh.manage.module.base.service.BuildingSellingPointService;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.BuildingPropertyType;
import hitwh.fanghh.manage.pojo.building.BuildingSellingPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BuildingSellingPointServiceImpl implements BuildingSellingPointService{
	@Autowired
	private BuildingSellingPointDao buildingSellingPointDao;
	@Override
	public void add(BuildingSellingPoint b) {
		// TODO Auto-generated method stub
		buildingSellingPointDao.add(b);
	}

	@Override
	public void update(BuildingSellingPoint b) {
		// TODO Auto-generated method stub
		buildingSellingPointDao.update(b);
	}

	@Override
	public void delete(BuildingSellingPoint b) {
		// TODO Auto-generated method stub
		buildingSellingPointDao.delete(b);
	}
	@Override
	public List<BuildingSellingPoint> getAll() {
		
		return buildingSellingPointDao.getAll();
	}
	@Override
	public List<BuildingSellingPoint> searchByHql(String hql) {
		
		return buildingSellingPointDao.searchByHql(hql);
	}
}
