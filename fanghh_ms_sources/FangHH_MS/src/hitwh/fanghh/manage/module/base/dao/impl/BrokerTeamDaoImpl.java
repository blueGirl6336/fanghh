package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BrokerTeamDao;
import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.pojo.building.BrokerTeam;
@Repository
public class BrokerTeamDaoImpl extends BaseDaoImpl implements BrokerTeamDao{

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkBrokerTeam(String invitationCode) {
		boolean flag = false;
		List<Broker> list = null;
		Session session = this.getSessionFactory().openSession();
		Transaction tc=session.beginTransaction();
		String hql = "from BrokerTeam as b where b.invitationCode =:invitationCode";
		try {
			Query query = session.createQuery(hql);
			query.setString("invitationCode", invitationCode);
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
			flag = true;
		}
		return flag;
	}

	@Override
	public void addBrokerTeam(BrokerTeam brokerTeam) {
		this.getHibernateTemplate().save(brokerTeam);
	}

}
