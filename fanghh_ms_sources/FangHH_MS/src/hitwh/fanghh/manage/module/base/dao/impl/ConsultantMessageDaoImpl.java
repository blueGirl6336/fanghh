package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ConsultantMessageDao;
import hitwh.fanghh.manage.pojo.building.ConsultantMessage;
@Repository
public class ConsultantMessageDaoImpl extends BaseDaoImpl implements ConsultantMessageDao{

	@Override
	public void update(ConsultantMessage c) {
		this.getHibernateTemplate().update(c);
	}

	@Override
	public void delete(ConsultantMessage c) {
		this.getHibernateTemplate().delete(c);
	}

	@Override
	public ConsultantMessage getById(int id) {
		return this.getHibernateTemplate().get(ConsultantMessage.class, id);
	}
	@Override
	public List<ConsultantMessage> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<ConsultantMessage> getAll() {
		String hql = "from ConsultantMessage";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public void add(ConsultantMessage c) {
		this.getHibernateTemplate().save(c);
	}


}
