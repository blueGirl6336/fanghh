package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.DeveloperDao;
import hitwh.fanghh.manage.module.base.dao.PropertyDao;
import hitwh.fanghh.manage.module.base.service.DeveloperService;
import hitwh.fanghh.manage.module.base.service.PropertyService;
import hitwh.fanghh.manage.pojo.building.Developer;
import hitwh.fanghh.manage.pojo.building.Property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PropertyServiceImpl implements PropertyService{
	@Autowired
	private PropertyDao propertyDao;
	@Override
	public void add(Property p) {
		// TODO Auto-generated method stub
		propertyDao.add(p);
	}

	@Override
	public void update(Property p) {
		// TODO Auto-generated method stub
		propertyDao.update(p);
	}

	@Override
	public void delete(Property p) {
		// TODO Auto-generated method stub
		propertyDao.delete(p);
	}

	@Override
	public List<Property> searchByHql(String hql) {
		// TODO Auto-generated method stub
		return propertyDao.searchByHql(hql);
	}

	@Override
	public Property getById(int id) {
		// TODO Auto-generated method stub
		return propertyDao.getById(id);
	}

	@Override
	public List<Property> getAll() {
		// TODO Auto-generated method stub
		return propertyDao.getAll();
	}


}
