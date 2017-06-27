package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.BuildingPropertyTypeDao;
import hitwh.fanghh.manage.module.base.service.BuildingPropertyTypeService;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.BuildingPropertyType;
@Service
public class BuildingPropertyTypeServiceImpl implements BuildingPropertyTypeService{
	@Autowired
	private BuildingPropertyTypeDao BuildingPropertyTypeDao;
	@Override
	public void add(BuildingPropertyType b) {
		// TODO Auto-generated method stub
		BuildingPropertyTypeDao.add(b);
	}

	@Override
	public void update(BuildingPropertyType b) {
		// TODO Auto-generated method stub
		BuildingPropertyTypeDao.update(b);
	}

	@Override
	public void delete(BuildingPropertyType b) {
		// TODO Auto-generated method stub
		BuildingPropertyTypeDao.delete(b);
	}
	@Override
	public List<BuildingPropertyType> getAll() {
		return BuildingPropertyTypeDao.getAll();
	}
	@Override
	public List<BuildingPropertyType> searchByHql(String hql) {
		
		return BuildingPropertyTypeDao.searchByHql(hql);
	}
}
