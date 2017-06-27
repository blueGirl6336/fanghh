package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.HouseStyleDao;
import hitwh.fanghh.manage.module.base.dao.HousingStrategyDao;
import hitwh.fanghh.manage.module.base.service.HouseStyleService;
import hitwh.fanghh.manage.module.base.service.HousingStrategyService;
import hitwh.fanghh.manage.pojo.building.HouseStyle;
import hitwh.fanghh.manage.pojo.building.HousingStrategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HousingStrategyServiceImpl implements HousingStrategyService{
	@Autowired
	private HousingStrategyDao housingStrategyDao;
	@Override
	public void add(HousingStrategy h) {
		// TODO Auto-generated method stub
		housingStrategyDao.add(h);
	}

	@Override
	public void update(HousingStrategy h) {
		// TODO Auto-generated method stub
		housingStrategyDao.update(h);
	}

	@Override
	public void delete(HousingStrategy h) {
		// TODO Auto-generated method stub
		housingStrategyDao.delete(h);
	}
	@Override
	public List<HousingStrategy> getAll() {
		return housingStrategyDao.getAll();
	}
	@Override
	public List<HousingStrategy> searchByHql(String hql) {
		
		return housingStrategyDao.searchByHql(hql);
	}

}
