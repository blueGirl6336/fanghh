package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.GroupPurchaseInfoDao;
import hitwh.fanghh.manage.module.base.dao.PerferentialHouseInfoDao;
import hitwh.fanghh.manage.pojo.building.GroupPurchaseInfo;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseInfo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class GroupPurchaseInfoDaoImpl extends BaseDaoImpl implements GroupPurchaseInfoDao{

	@Override
	public GroupPurchaseInfo getById(int id) {
		return this.getHibernateTemplate().get(GroupPurchaseInfo.class, id);
	}
	@Override
	public List<GroupPurchaseInfo> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<GroupPurchaseInfo> getAll() {
		String hql = "from GroupPurchaseInfo";
		return this.getHibernateTemplate().find(hql);
	}


	@Override
	public void add(GroupPurchaseInfo g) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(g);
	}

	@Override
	public void update(GroupPurchaseInfo g) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(g);
	}

	@Override
	public void delete(Integer g) {
		// TODO Auto-generated method stub
		Session session = this.getSessionFactory().openSession();
		
		String hql="delete GroupPurchaseInfo as p where p.gpId=?";

		Query query=session.createQuery(hql);

		query.setInteger(0,g);

		query.executeUpdate();

		session.beginTransaction().commit();
	}

}
