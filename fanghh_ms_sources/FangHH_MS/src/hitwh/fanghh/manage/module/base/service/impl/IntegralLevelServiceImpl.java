package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.IntegralLevelDao;
import hitwh.fanghh.manage.module.base.service.IntegralLevelService;
import hitwh.fanghh.manage.pojo.building.IntegralLevel;
@Service
public class IntegralLevelServiceImpl implements IntegralLevelService{

	@Autowired
	private IntegralLevelDao integralLevelDao;


	@Override
	public void update(IntegralLevel i) {
		integralLevelDao.update(i);
	}

	@Override
	public void delete(IntegralLevel i) {
		integralLevelDao.delete(i);
	}
	@Override
	public List<IntegralLevel> searchByHql(String hql) {
		
		return integralLevelDao.searchByHql(hql);
	}
	@Override
	public IntegralLevel getById(int id) {
		return integralLevelDao.getById(id);
	}
	@Override
	public List<IntegralLevel> getAll() {
		return integralLevelDao.getAll();
	}

	@Override
	public void add(IntegralLevel i) {
		integralLevelDao.add(i);
	}
}
