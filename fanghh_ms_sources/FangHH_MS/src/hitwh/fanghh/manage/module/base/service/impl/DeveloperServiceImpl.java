package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.DeveloperDao;
import hitwh.fanghh.manage.module.base.dao.HouseDao;
import hitwh.fanghh.manage.module.base.service.DeveloperService;
import hitwh.fanghh.manage.pojo.building.Developer;
@Service
public class DeveloperServiceImpl implements DeveloperService{
	@Autowired
	private DeveloperDao developerDao;
	@Override
	public void add(Developer d) {
		// TODO Auto-generated method stub
		developerDao.add(d);
	}

	@Override
	public void update(Developer d) {
		// TODO Auto-generated method stub
		developerDao.update(d);
	}

	@Override
	public void delete(Developer d) {
		// TODO Auto-generated method stub
		developerDao.delete(d);
	}

	@Override
	public List<Developer> searchByHql(String hql) {
		// TODO Auto-generated method stub
		return developerDao.searchByHql(hql);
	}

	@Override
	public Developer getById(int id) {
		// TODO Auto-generated method stub
		return developerDao.getById(id);
	}

	@Override
	public List<Developer> getAll() {
		// TODO Auto-generated method stub
		return developerDao.getAll();
	}

}
