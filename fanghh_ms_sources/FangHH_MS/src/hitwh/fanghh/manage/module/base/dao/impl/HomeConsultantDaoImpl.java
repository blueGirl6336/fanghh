package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.HomeConsultantDao;
import hitwh.fanghh.manage.pojo.building.HomeConsultant;
@Repository
public class HomeConsultantDaoImpl extends BaseDaoImpl implements HomeConsultantDao{

	@Override
	public void update(HomeConsultant b) {
		this.getHibernateTemplate().update(b);
	}

	@Override
	public void delete(HomeConsultant b) {
		this.getHibernateTemplate().delete(b);
	}

	@Override
	public HomeConsultant getById(int id) {
		return this.getHibernateTemplate().get(HomeConsultant.class, id);
	}
	@Override
	public List<HomeConsultant> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<HomeConsultant> getAll() {
		String hql = "from HomeConsultant";
		return this.getHibernateTemplate().find(hql);
	}


}
