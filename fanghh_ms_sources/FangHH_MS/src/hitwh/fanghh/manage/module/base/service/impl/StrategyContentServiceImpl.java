package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.ShareInfoDao;
import hitwh.fanghh.manage.module.base.dao.StrategyContentDao;
import hitwh.fanghh.manage.module.base.service.ShareInfoService;
import hitwh.fanghh.manage.module.base.service.StrategyContentService;
import hitwh.fanghh.manage.pojo.building.ShareInfo;
import hitwh.fanghh.manage.pojo.building.StrategyContent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyContentServiceImpl implements StrategyContentService{
	@Autowired
	private StrategyContentDao strategyContentDao;
	@Override
	public void add(StrategyContent s) {
		// TODO Auto-generated method stub
		strategyContentDao.add(s);
	}

	@Override
	public void update(StrategyContent s) {
		// TODO Auto-generated method stub
		strategyContentDao.update(s);
	}

	@Override
	public void delete(StrategyContent s) {
		// TODO Auto-generated method stub
		strategyContentDao.delete(s);
	}
	@Override
	public List<StrategyContent> searchByHql(String hql) {
		
		return strategyContentDao.searchByHql(hql);
	}
	@Override
	public StrategyContent getById(int id) {
		return strategyContentDao.getById(id);
		
	}
	@Override
	public List<StrategyContent> getAll() {
		return strategyContentDao.getAll();
	}

}
