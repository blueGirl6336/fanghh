package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.IntegralRecordDao;
import hitwh.fanghh.manage.module.base.service.IntegralRecordService;
import hitwh.fanghh.manage.pojo.building.IntegralRecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class IntegralRecordServiceImpl implements IntegralRecordService{
	@Autowired
	private IntegralRecordDao integralRecordDao;
	@Override
	public void add(IntegralRecord i) {
		integralRecordDao.add(i);
	}

	@Override
	public void update(IntegralRecord i) {
		integralRecordDao.update(i);
	}

	@Override
	public void delete(IntegralRecord i) {
		integralRecordDao.delete(i);
	}
	@Override
	public List<IntegralRecord> searchByHql(String hql) {
		
		return integralRecordDao.searchByHql(hql);
	}
	@Override
	public IntegralRecord getById(int id) {
		return integralRecordDao.getById(id);
		
	}
	@Override
	public List<IntegralRecord> getAll() {
		return integralRecordDao.getAll();
	}
}
