package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.StoreDao;
import hitwh.fanghh.manage.pojo.building.Store;

@Repository
public class StoreDaoImpl extends BaseDaoImpl implements StoreDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Store> getAll() {
		String status = "06110100";
		List<Store> list = null;
		Session session = this.getSessionFactory().openSession();
		Transaction tc=session.beginTransaction();
		String hql = "from Store as s where s.status =:status";
		try {
			Query query = session.createQuery(hql);
			query.setString("status", status);
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
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Store getStorePortrait(int storeId) {
		List<Store> list = null;
		Session session = this.getSessionFactory().openSession();
		Transaction tc = session.beginTransaction();
		String hql = "from Store as s where s.storeId =:storeId";
		try {
			Query query = session.createQuery(hql);
			query.setInteger("storeId", storeId);
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
