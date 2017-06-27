package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BrokerCommentFromConsultantDao;
import hitwh.fanghh.manage.pojo.building.BrokerCommentFromConsultant;
@Repository
public class BrokerCommentFromConsultantDaoImpl extends BaseDaoImpl implements BrokerCommentFromConsultantDao{

	@Override
	public void update(BrokerCommentFromConsultant b) {
		this.getHibernateTemplate().update(b);
	}

	@Override
	public void delete(BrokerCommentFromConsultant b) {
		this.getHibernateTemplate().delete(b);
	}

	@Override
	public BrokerCommentFromConsultant getById(int id) {
		return this.getHibernateTemplate().get(BrokerCommentFromConsultant.class, id);
	}
	@Override
	public List<BrokerCommentFromConsultant> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<BrokerCommentFromConsultant> getAll() {
		String hql = "from BrokerCommentFromConsultant";
		return this.getHibernateTemplate().find(hql);
	}


}
