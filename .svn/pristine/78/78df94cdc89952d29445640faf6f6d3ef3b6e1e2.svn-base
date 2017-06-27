package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.DeveloperDao;

import hitwh.fanghh.manage.pojo.building.Developer;


import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class DeveloperDaoImpl extends BaseDaoImpl implements DeveloperDao{
		@Override
		public void add(Developer d) {
			this.getHibernateTemplate().save(d);
		}

		@Override
		public void update(Developer d) {
			this.getHibernateTemplate().update(d);
		}

		@Override
		public void delete(Developer d) {
			this.getHibernateTemplate().delete(d);
		}

		@Override
		public Developer getById(int id) {
			return this.getHibernateTemplate().get(Developer.class, id);
		}
		@SuppressWarnings("unchecked")
		@Override
		public List<Developer> searchByHql(String hql) {
			
			return this.getHibernateTemplate().find(hql);
		}
		@Override
		public List<Developer> getAll() {
			String hql = "from Developer";
			return this.getHibernateTemplate().find(hql);
		}
}
