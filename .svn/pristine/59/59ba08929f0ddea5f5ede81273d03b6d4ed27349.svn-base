package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BrokerDao;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Broker;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
@Repository
public class BrokerDaoImpl extends BaseDaoImpl implements  BrokerDao{

	
	@Override
	public void add(Broker c) {
		this.getHibernateTemplate().save(c);
	}

	@Override
	public void update(Broker c) {
		this.getHibernateTemplate().update(c);
	}

	@Override
	public void delete(Broker c) {
		this.getHibernateTemplate().delete(c);
	}

	@Override
	public Broker getById(int id) {
		return this.getHibernateTemplate().get(Broker.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Broker> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Broker> getAll() {
		String hql = "from Broker";
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Broker getByBrokerId(Integer brokerId) {
		List<Broker> list = null;
		Session session = this.getSessionFactory().openSession();
		Transaction tc=session.beginTransaction();
		String hql = "from Broker as b where b.brokerId =:brokerId";
		try {
			Query query = session.createQuery(hql);
			query.setInteger("brokerId", brokerId);
			list=query.list();
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(null != tc){
				tc.rollback();
			}
		} finally {
			session.close();
		}
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Broker getByUserId(User user) {
		List<Broker> list = null;
		Session session = this.getSessionFactory().openSession();
		Transaction tc=session.beginTransaction();
		String hql = "from Broker as h where h.user =:user";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("user", user);
			list=query.list();
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(null != tc){
				tc.rollback();
			}
		} finally {
			session.close();
		}
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}	
	
}
