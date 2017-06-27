package hitwh.fanghh.manage.dao.impl;

import hitwh.fanghh.manage.dao.DictionaryDao;
import hitwh.fanghh.manage.pojo.Dictionary;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class DictionaryDaoImpl extends BaseDaoImpl implements DictionaryDao {
	
	@Override
	public List<Dictionary> getAll() {
		String hql = "from Dictionary";
		return this.getHibernateTemplate().find(hql);
	}

	public List<Dictionary> getAllGroup(String module) {
		String hql = "from Dictionary where (dictParentCode = null or dictParentCode ='') and dictModuleCode = ?";
		return this.getHibernateTemplate().find(hql, module);
	}

	public List<Dictionary> getItemsByGroupCode(String groupCode) {

		String hql = "from Dictionary where dictParentCode=? order by dictDetailgroup, dictCode";
		return this.getHibernateTemplate().find(hql, groupCode);

	}

	public List<Dictionary> getItemsByGroupCodeAndValue(String groupCode,
			String value) {
		String hql = "from Dictionary where dictParentCode=:parentCode and dictValue like %:value%";
		Query q = this.getSessionFactory().openSession().createQuery(hql);
		q.setParameter("parentCode", groupCode);
		q.setParameter("value", value);
		return q.list();
	}

	public List<Dictionary> getItemsByModule(String module) {
		String hql = "from Dictionary where dictModuleCode = ? ";
		return this.getHibernateTemplate().find(hql, module);
	}

	public Dictionary getByCode(String code) {
		String hql = "from Dictionary where dictCode = ?";
		List<Dictionary> dicList = this.getHibernateTemplate().find(hql, code);
		if (dicList.size() > 0) {

			return dicList.get(0);
		} else
			return null;
	}

	@Override
	public List<Dictionary> getItemsLikeModule(String module) {
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		String hql = "from Dictionary where dictModuleCode like :module ";

		Query query = session.createQuery(hql); 
		query.setString("module", module+"%");
		return query.list();
	}
}
