//$Header:  $
/////////////////////////////////////////////////////////////////////////////
//PROPRIETARY RIGHTS STATEMENT
//The contents of this file represent confidential information that is the
//proprietary property of Active Endpoints, Inc.  Viewing or use of
//this information is prohibited without the express written consent of
//Active Endpoints, Inc. Removal of this PROPRIETARY RIGHTS STATEMENT
//is strictly forbidden. Copyright (c) 2002-2007 All rights reserved.
/////////////////////////////////////////////////////////////////////////////
package hitwh.fanghh.manage.dao.impl;

import hitwh.fanghh.manage.dao.BaseDao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {
	/**
	 * 设置sessionFactory
	 * 
	 * @param sessionFactory
	 */
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	// 提供基本增删改查功能
	public void add(Object o) {
		this.getHibernateTemplate().save(o);
	}

	public void update(Object o) {
		this.getHibernateTemplate().update(o);
	}

	public void delete(Object o) {
		this.getHibernateTemplate().delete(o);
	}

	public Object getById(Object o, int id) {
		return this.getHibernateTemplate().get(o.getClass(), id);
	}

	public <T extends Object> List<T> getByEmpNo(String empNo, T t) {
		String hql = "from " + t.getClass().getName() + "where empNo=?";
		List<T> tList = (List<T>) this.getHibernateTemplate().find(hql, empNo);
		return tList;
	}

	@Override
	public <T extends Object> List<T> getAll(T t, String order) {
		String hql = "from " + t.getClass().getName() + " order by empNo" + (StringUtils.isBlank(order) ? "" : (", " + order));
		List<T> tList = (List<T>) this.getHibernateTemplate().find(hql);
		return tList;
	}

	/**
	 * 使用criterion进行操作
	 * 
	 * @param arg
	 * @param criterions
	 * @param offset
	 *            , -1表示禁用该项
	 * @param length
	 *            , -1表示禁用该项
	 * @return List
	 */
	protected List getListByCriterionInPage(final Class arg, final Criterion[] criterions, final int offset, final int length) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(arg);
				// 循环遍历添加约束条件
				for (int i = 0; i < criterions.length; i++) {
					criteria.add(criterions[i]);
				}
				if (offset >= 0)
					criteria.setFirstResult(offset);
				if (length >= 0)
					criteria.setMaxResults(length);
				return criteria.list();
			}
		});
		return list;
	}

	/**
	 * 获取条件下的所有条目数
	 * 
	 * @param clz
	 * @return
	 */
	public Integer getTotalCountByCriterion(final Class clz, final Criterion[] criterions) {
		Integer result = null;
		result = (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria c = session.createCriteria(clz.getName());
				c.setProjection(Projections.rowCount());
				for (int i = 0; i < criterions.length; i++) {
					c.add(criterions[i]);
				}
				return Integer.parseInt(c.uniqueResult().toString());
			}

		});
		return result;
	}

	/**
	 * 通过HQL查询总数
	 * 
	 * @param hql
	 * @return
	 */
	public int getTotalCountByHql(String hql) {
		Iterator i = this.getHibernateTemplate().find(hql).listIterator();
		if (i.hasNext()) {
			Long count = (Long) i.next();
			return count.intValue();

		}
		return 0;
	}

	@Override
	public <T> void deleteByEmpNo(Class<T> clazz, String empNo) {
		String hql = "select t1 from " + clazz.getName() + " t1, PersonBaseInfo t2 where t2.empNo = ? and t1.baseinfo=t2 ";
		List<T> list = this.getHibernateTemplate().find(hql, empNo);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				this.delete(list.get(i));
			}
		}
	}

	@Override
	public <T> T getOneById(int id, T t) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(t.getClass(), id);
	}

	// update with sql example
	// public void updateAnswerResult(final int questionId, final char
	// rightAnswer) {
	// getHibernateTemplate().execute(new HibernateCallback() {
	// public Object doInHibernate(Session session)
	// throws HibernateException, SQLException {
	// final String hql1 =
	// "update ChoiceAnswer set result = true where questionId = ? and answer = ?";
	// Query query = session.createQuery(hql1);
	// query.setInteger(0, questionId);
	// query.setCharacter(0, rightAnswer);
	// query.executeUpdate();
	// }
	// });
	// }

	// search by sql in page
	// public List<NewsBean> findSpecificNews(int type, int office, int offset,
	// int pageSize) {
	// String hql =
	// "from NewsBean n where n.type=:type and n.office=:office order by n.top desc, n.editDate desc";
	// Session session = getSession();
	// Query query = session.createQuery(hql);
	// query.setParameter("type", type);
	// query.setParameter("office", office);
	// query.setFirstResult(offset);// 定义从第几条开始查询
	// query.setMaxResults(pageSize);// 定义返回的记录数
	// List<NewsBean> list = query.list();
	// return list;
	// }

}
