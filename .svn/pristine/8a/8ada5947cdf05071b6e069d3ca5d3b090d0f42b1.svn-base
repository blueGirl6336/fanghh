package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ShareBackDao;
import hitwh.fanghh.manage.module.base.dao.ShareInfoDao;
import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.ShareInfo;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ShareInfoDaoImpl extends BaseDaoImpl implements  ShareInfoDao{

	
	@Override
	public void add(ShareInfo s) {
		this.getHibernateTemplate().save(s);
	}

	@Override
	public void update(ShareInfo s) {
		this.getHibernateTemplate().update(s);
	}

	@Override
	public void delete(ShareInfo s) {
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public ShareInfo getById(int id) {
		return this.getHibernateTemplate().get(ShareInfo.class, id);
	}
	@Override
	public List<ShareInfo> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<ShareInfo> getAll() {
		String hql = "from ShareInfo";
		return this.getHibernateTemplate().find(hql);
	}

}
