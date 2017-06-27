package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.FourDoubleZeroPhoneDao;
import hitwh.fanghh.manage.pojo.building.Broker;
import hitwh.fanghh.manage.pojo.building.FourDoubleZeroPhone;
@Repository
public class FourDoubleZeroPhoneDaoImpl extends BaseDaoImpl implements FourDoubleZeroPhoneDao{

	@Override
	public void add(FourDoubleZeroPhone fourDoubleZeroPhone) {
		this.getHibernateTemplate().save(fourDoubleZeroPhone);
	}

	@SuppressWarnings("unchecked")
	@Override
	public FourDoubleZeroPhone havingFourDOuble(String targetPhoneNum) {
		List<FourDoubleZeroPhone> list = null;
		Session session = this.getSessionFactory().openSession();
		Transaction tc=session.beginTransaction();
		String hql = "from FourDoubleZeroPhone as f where f.targetPhoneNum =:targetPhoneNum";
		try {
			Query query = session.createQuery(hql);
			query.setString("targetPhoneNum", targetPhoneNum);
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
	public FourDoubleZeroPhone getFourDOuble(String orginalPhoneNum) {
		List<FourDoubleZeroPhone> list = null;
		Session session = this.getSessionFactory().openSession();
		Transaction tc=session.beginTransaction();
		String hql = "from FourDoubleZeroPhone as f where f.orginalPhoneNum =:orginalPhoneNum";
		try {
			Query query = session.createQuery(hql);
			query.setString("orginalPhoneNum", orginalPhoneNum);
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
	public void update(FourDoubleZeroPhone fourDoubleZeroPhone) {
		this.getHibernateTemplate().update(fourDoubleZeroPhone);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FourDoubleZeroPhone> getUnCheckedFourDoublePhone() {
		List<FourDoubleZeroPhone> list = null;
		Session session = this.getSessionFactory().openSession();
		Transaction tc=session.beginTransaction();
		String hql = "from FourDoubleZeroPhone as f where f.status =:status";
		try {
			Query query = session.createQuery(hql);
			query.setBoolean("status", false);
			list = query.list();
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
			return list;
		}
		return null;
	}

}
