package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.CityDao;
import hitwh.fanghh.manage.module.base.dao.UnitDao;
import hitwh.fanghh.manage.module.base.service.CityService;
import hitwh.fanghh.manage.pojo.building.City;
import hitwh.fanghh.manage.pojo.building.Unit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CityServiceImpl implements CityService{
	@Autowired
	private CityDao cityDao;
	@Override
	public void add(City c) {
		// TODO Auto-generated method stub
		cityDao.add(c);
	}

	@Override
	public void update(City c) {
		// TODO Auto-generated method stub
		cityDao.update(c);
	}

	@Override
	public void delete(City c) {
		// TODO Auto-generated method stub
		cityDao.delete(c);
	}
	@Override
	public List<City> searchByHql(String hql) {
		
		return cityDao.searchByHql(hql);
	}
	@Override
	public City getById(int id) {
		return cityDao.getById(id);
		
	}
	@Override
	public List<City> getAll() {
		return cityDao.getAll();
	}
}
