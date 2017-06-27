package hitwh.fanghh.manage.module.base.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.IntegralRecord;

public interface IntegralRecordService {

	void add(IntegralRecord i);

	void update(IntegralRecord i);

	void delete(IntegralRecord i);

	public List<IntegralRecord> searchByHql(String hql);

	public List<IntegralRecord> getAll();

	public IntegralRecord getById(int id);

}
