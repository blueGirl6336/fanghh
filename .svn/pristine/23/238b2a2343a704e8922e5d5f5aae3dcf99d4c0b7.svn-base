package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.SurroundFacilityDao;
import hitwh.fanghh.manage.module.base.service.SurroundFacilityService;
import hitwh.fanghh.manage.pojo.building.SurroundFacility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SurroundFacilityServiceImpl implements SurroundFacilityService{
	@Autowired
	private SurroundFacilityDao surroundFacilityDao;
	@Override
	public void add(SurroundFacility s) {
		// TODO Auto-generated method stub
		surroundFacilityDao.add(s);
	}

	@Override
	public void update(SurroundFacility s) {
		// TODO Auto-generated method stub
		surroundFacilityDao.update(s);
	}

	@Override
	public void delete(SurroundFacility s) {
		// TODO Auto-generated method stub
		surroundFacilityDao.delete(s);
	}
	@Override
	public List<SurroundFacility> searchByHql(String hql) {
		
		return surroundFacilityDao.searchByHql(hql);
	}
	@Override
	public SurroundFacility getById(int id) {
		return surroundFacilityDao.getById(id);
		
	}
	@Override
	public List<SurroundFacility> getAll() {
		return surroundFacilityDao.getAll();
	}
}
