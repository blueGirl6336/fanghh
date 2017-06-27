package hitwh.fanghh.manage.dao.impl;

import hitwh.fanghh.manage.dao.UserDao;
import hitwh.fanghh.manage.pojo.User;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public void add(User u) {
		this.getHibernateTemplate().save(u);
	}

	@Override
	public void update(User u) {
		this.getHibernateTemplate().update(u);
	}

	@Override
	public void delete(User u) {
		this.getHibernateTemplate().delete(u);
	}

	@Override
	public User getById(int id) {
		return this.getHibernateTemplate().get(User.class, id);
	}

	@Override
	// 根据用户名查询用户
	public User getByUsername(String username) {
		String hql = "from User where username = ?";
		List<User> users = this.getHibernateTemplate().find(hql, username);
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	//提取出查询条件
	private Criterion[] extractCondition(User u) {
		ArrayList<Criterion> criteria = new ArrayList<Criterion>();

		if (u.getUsername() != null && u.getUsername().length() > 0)
			criteria.add(Restrictions.eq("username", u.getUsername()));

		/*if (u.getDepartment() != null && u.getDepartment().length() > 0) {
			criteria.add(Restrictions.eq("department", u.getDepartment()));
		}*/

		if (u.getRole() != null && u.getRole().length() > 0) {
			criteria.add(Restrictions.eq("role", u.getRole()));
		}

		/*if (u.getRealName() != null && u.getRealName().length() > 0) {
			criteria.add(Restrictions.like("realName", u.getRealName()));
		}*/

		return (Criterion[]) criteria.toArray(new Criterion[criteria.size()]);
	}

	public List<User> getByExample(User u, int offset, int pageSize) {
		return this.getListByCriterionInPage(User.class,
				this.extractCondition(u), offset, pageSize);
	}

	public int getCountByExample(User u) {
		return this.getTotalCountByCriterion(User.class,
				this.extractCondition(u));
	}

	@Override
	public List<User> getAll() {
		String hql = "from User";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public List<User> getByRealName(String realName) {
		String hql = "from User where realName like ?";
		return this.getHibernateTemplate().find(hql, realName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByPhoneNo(String phoneNo) {
		List<User> list = null;
		String hql = "from User as u where u.phoneNo =?";
//		Session session = this.getSessionFactory().openSession();
//		Transaction tc=session.beginTransaction();
//		String hql = "from User as u where u.phoneNo =:phoneNo";
//		try {
//			Query query = session.createQuery(hql);
//			query.setString("phoneNo", phoneNo);
//			list=query.list();
//			tc.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			if(null != tc){
//				tc.rollback();
//			}
//		} finally {
//			this.getSessionFactory().close();
//		}
//		if(list != null && list.size()>0){
//			return list.get(0);
//		}
//		return null;
		list = this.getHibernateTemplate().find(hql,phoneNo);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	

}
