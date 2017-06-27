package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.IntegralRecordDao;
import hitwh.fanghh.manage.pojo.building.IntegralRecord;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class IntegralRecordDaoImpl extends BaseDaoImpl implements  IntegralRecordDao{

	
	@Override
	public void add(IntegralRecord i) {
		this.getHibernateTemplate().save(i);
	}

	@Override
	public void update(IntegralRecord i) {
		this.getHibernateTemplate().update(i);
	}

	@Override
	public void delete(IntegralRecord i) {
		this.getHibernateTemplate().delete(i);
	}

	@Override
	public IntegralRecord getById(int id) {
		return this.getHibernateTemplate().get(IntegralRecord.class, id);
	}
	@Override
	public List<IntegralRecord> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<IntegralRecord> getAll() {
		String hql = "from IntegralRecord";
		return this.getHibernateTemplate().find(hql);
	}
}
