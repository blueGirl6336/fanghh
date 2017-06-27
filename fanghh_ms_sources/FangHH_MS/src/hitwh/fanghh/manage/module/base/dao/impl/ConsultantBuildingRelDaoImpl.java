package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ConsultantBuildingRelDao;
import hitwh.fanghh.manage.pojo.building.ConsultantBuildingRel;
import hitwh.fanghh.manage.pojo.building.HomeConsultant;
@Repository
public class ConsultantBuildingRelDaoImpl extends BaseDaoImpl implements ConsultantBuildingRelDao {

	@Override
	public void add(ConsultantBuildingRel h) {
		this.getHibernateTemplate().save(h);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ConsultantBuildingRel getConsultantBuildingRelByhomeConsultant(
			HomeConsultant homeConsultant) {
		List<ConsultantBuildingRel> list = null;
		Session session = this.getSessionFactory().openSession();
		Transaction tc=session.beginTransaction();
		String hql = "from ConsultantBuildingRel as c where c.homeConsultant =:homeConsultant";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("homeConsultant", homeConsultant);
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

	@Override
	public void update(ConsultantBuildingRel c) {
		this.getHibernateTemplate().update(c);
	}

}
