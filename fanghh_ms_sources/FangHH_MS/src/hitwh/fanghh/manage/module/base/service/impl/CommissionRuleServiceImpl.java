package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.CommissionRuleDao;
import hitwh.fanghh.manage.module.base.service.CommissionRuleService;
import hitwh.fanghh.manage.pojo.building.CommissionRule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CommissionRuleServiceImpl implements CommissionRuleService {

	@Autowired
	private CommissionRuleDao commissionRuleDao;
	@Override
	public void add(CommissionRule c) {
		// TODO Auto-generated method stub
		commissionRuleDao.add(c);
	}

	@Override
	public void update(CommissionRule c) {
		// TODO Auto-generated method stub
		commissionRuleDao.update(c);
	}

	@Override
	public void delete(CommissionRule c) {
		// TODO Auto-generated method stub
		commissionRuleDao.delete(c);
	}

	@Override
	public List<CommissionRule> getAll() {
		// TODO Auto-generated method stub
		return commissionRuleDao.getAll();
	}

	@Override
	public CommissionRule getById(int id) {
		// TODO Auto-generated method stub
		return commissionRuleDao.getById(id);
	}

	@Override
	public List<CommissionRule> searchByHql(String hql) {
		// TODO Auto-generated method stub
		return commissionRuleDao.searchByHql(hql);
	}

	@Override
	public CommissionRule searchByBuildingIdAndRuleType(int buildingId,String ruleType) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("select c from CommissionRule as c where c.building.buildingId = "+ buildingId + "and c.ruleType = " + ruleType);
		return commissionRuleDao.searchByHql(hql.toString()).get(0);
	}

}
