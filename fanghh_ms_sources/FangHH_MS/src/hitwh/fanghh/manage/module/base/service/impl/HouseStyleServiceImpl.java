package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import hitwh.fanghh.manage.module.base.dao.HouseDao;
import hitwh.fanghh.manage.module.base.dao.HouseStyleDao;
import hitwh.fanghh.manage.module.base.service.HouseStyleService;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.BuildingSellingPoint;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.HouseStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HouseStyleServiceImpl implements HouseStyleService{
	@Autowired
	private HouseStyleDao houseStyleDao;
	@Override
	public void add(HouseStyle h) {
		// TODO Auto-generated method stub
		houseStyleDao.add(h);
	}

	@Override
	public void update(HouseStyle h) {
		// TODO Auto-generated method stub
		houseStyleDao.update(h);
	}

	@Override
	public void delete(HouseStyle h) {
		// TODO Auto-generated method stub
		houseStyleDao.delete(h);
	}
	@Override
	public List<HouseStyle> getAll() {
		return houseStyleDao.getAll();
	}
	@Override
	public List<HouseStyle> searchByHql(String hql) {
		
		return houseStyleDao.searchByHql(hql);
	}
}
