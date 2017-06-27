package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import hitwh.fanghh.manage.module.base.dao.HouseDao;
import hitwh.fanghh.manage.module.base.dao.RegionDao;
import hitwh.fanghh.manage.module.base.service.HouseService;
import hitwh.fanghh.manage.module.base.service.RegionService;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.HouseStyle;
import hitwh.fanghh.manage.pojo.building.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RegionServiceImpl implements RegionService{
	@Autowired
	private RegionDao regionDao;
	@Override
	public void add(Region r) {
		// TODO Auto-generated method stub
		regionDao.add(r);
	}

	@Override
	public void update(Region r) {
		// TODO Auto-generated method stub
		regionDao.update(r);
	}

	@Override
	public void delete(Region r) {
		// TODO Auto-generated method stub
		regionDao.delete(r);
	}
	@Override
	public List<Region> getAll() {
		return regionDao.getAll();
	}
	@Override
	public List<Region> searchByHql(String hql) {
		
		return regionDao.searchByHql(hql);
	}
	@Override
	public Region getById(int id) {
		return regionDao.getById(id);
	}
}
