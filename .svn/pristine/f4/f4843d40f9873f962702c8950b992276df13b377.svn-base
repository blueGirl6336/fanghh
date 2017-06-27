package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ConsultantCommentFromBrokerDao;
import hitwh.fanghh.manage.pojo.building.ConsultantCommentFromBroker;
@Repository
public class ConsultantCommentFromBrokerDaoImpl extends BaseDaoImpl implements ConsultantCommentFromBrokerDao{

	@Override
	public void update(ConsultantCommentFromBroker b) {
		this.getHibernateTemplate().update(b);
	}

	@Override
	public void delete(ConsultantCommentFromBroker b) {
		this.getHibernateTemplate().delete(b);
	}

	@Override
	public ConsultantCommentFromBroker getById(int id) {
		return this.getHibernateTemplate().get(ConsultantCommentFromBroker.class, id);
	}
	@Override
	public List<ConsultantCommentFromBroker> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<ConsultantCommentFromBroker> getAll() {
		String hql = "from ConsultantCommentFromBroker";
		return this.getHibernateTemplate().find(hql);
	}


}
