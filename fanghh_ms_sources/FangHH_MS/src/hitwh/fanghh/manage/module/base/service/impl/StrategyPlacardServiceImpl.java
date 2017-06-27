package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.StrategyLabelCatgDao;
import hitwh.fanghh.manage.module.base.dao.StrategyPlacardDao;
import hitwh.fanghh.manage.module.base.service.StrategyLabelCatgService;
import hitwh.fanghh.manage.module.base.service.StrategyPlacardService;
import hitwh.fanghh.manage.pojo.building.StrategyLabelCatg;
import hitwh.fanghh.manage.pojo.building.StrategyPlacard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyPlacardServiceImpl implements StrategyPlacardService{
	@Autowired
	private StrategyPlacardDao strategyPlacardDao;
	@Override
	public void add(StrategyPlacard s) {
		// TODO Auto-generated method stub
		strategyPlacardDao.add(s);
	}

	@Override
	public void update(StrategyPlacard s) {
		// TODO Auto-generated method stub
		strategyPlacardDao.update(s);
	}

	@Override
	public void delete(StrategyPlacard s) {
		// TODO Auto-generated method stub
		strategyPlacardDao.delete(s);
	}
	@Override
	public List<StrategyPlacard> searchByHql(String hql) {
		
		return strategyPlacardDao.searchByHql(hql);
	}
	@Override
	public StrategyPlacard getById(int id) {
		return strategyPlacardDao.getById(id);
		
	}
	@Override
	public List<StrategyPlacard> getAll() {
		return strategyPlacardDao.getAll();
	}

}
