package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.HouseDao;
import hitwh.fanghh.manage.module.base.service.HouseService;
import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.HouseStyle;
@Service
public class HouseServiceImpl implements HouseService{
	@Autowired
	private HouseDao houseDao;
	@Override
	public void add(House h) {
		// TODO Auto-generated method stub
		houseDao.add(h);
	}

	//update暂时这样处理以后再修改
	@Override
	public void update(House h) {
		// TODO Auto-generated method stub
		
		houseDao.update(h);
	}

	@Override
	public void delete(House h) {
		// TODO Auto-generated method stub
		houseDao.delete(h);
	}
	@Override
	public List<House> searchByHql(String hql) {
		
		return houseDao.searchByHql(hql);
	}
	@Override
	public House getById(int id) {
		return houseDao.getById(id);
	}
	@Override
	public List<House> getAll() {
		return houseDao.getAll();
	}
}
