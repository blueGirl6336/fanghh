package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.IntegralRuleDao;
import hitwh.fanghh.manage.module.base.service.IntegralRuleService;
import hitwh.fanghh.manage.pojo.building.IntegralRule;
@Service
public class IntegralRuleServiceImpl implements IntegralRuleService{

	@Autowired
	private IntegralRuleDao integralRuleDao;


	@Override
	public void update(IntegralRule b) {
		// TODO Auto-generated method stub
		integralRuleDao.update(b);
	}

	@Override
	public void delete(IntegralRule b) {
		// TODO Auto-generated method stub
		integralRuleDao.delete(b);
	}
	@Override
	public List<IntegralRule> searchByHql(String hql) {
		
		return integralRuleDao.searchByHql(hql);
	}
	@Override
	public IntegralRule getById(int id) {
		return integralRuleDao.getById(id);
	}
	@Override
	public List<IntegralRule> getAll() {
		return integralRuleDao.getAll();
	}
}
