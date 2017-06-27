package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ShareBackDao;
import hitwh.fanghh.manage.module.base.dao.SurroundFacilityDao;
import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.SurroundFacility;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ShareBackDaoImpl extends BaseDaoImpl implements  ShareBackDao{

	
	@Override
	public void add(ShareBack s) {
		this.getHibernateTemplate().save(s);
	}

	@Override
	public void update(ShareBack s) {
		this.getHibernateTemplate().update(s);
	}

	@Override
	public void delete(ShareBack s) {
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public ShareBack getById(int id) {
		return this.getHibernateTemplate().get(ShareBack.class, id);
	}
	@Override
	public List<ShareBack> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<ShareBack> getAll() {
		String hql = "from ShareBack";
		return this.getHibernateTemplate().find(hql);
	}

}
