package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.StrategyContentDao;
import hitwh.fanghh.manage.module.base.dao.StrategyLabelCatgDao;
import hitwh.fanghh.manage.module.base.service.StrategyContentService;
import hitwh.fanghh.manage.module.base.service.StrategyLabelCatgService;
import hitwh.fanghh.manage.pojo.building.StrategyContent;
import hitwh.fanghh.manage.pojo.building.StrategyLabelCatg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyLabelCatgServiceImpl implements StrategyLabelCatgService{
	@Autowired
	private StrategyLabelCatgDao strategyLabelCatgDao;
	@Override
	public void add(StrategyLabelCatg s) {
		// TODO Auto-generated method stub
		strategyLabelCatgDao.add(s);
	}

	@Override
	public void update(StrategyLabelCatg s) {
		// TODO Auto-generated method stub
		strategyLabelCatgDao.update(s);
	}

	@Override
	public void delete(StrategyLabelCatg s) {
		// TODO Auto-generated method stub
		strategyLabelCatgDao.delete(s);
	}
	@Override
	public List<StrategyLabelCatg> searchByHql(String hql) {
		
		return strategyLabelCatgDao.searchByHql(hql);
	}
	@Override
	public StrategyLabelCatg getById(int id) {
		return strategyLabelCatgDao.getById(id);
		
	}
	@Override
	public List<StrategyLabelCatg> getAll() {
		return strategyLabelCatgDao.getAll();
	}


}
