package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.ShareBackDao;
import hitwh.fanghh.manage.module.base.dao.ShareContentDao;
import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.ShareContent;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ShareContentDaoImpl extends BaseDaoImpl implements  ShareContentDao{

	
	@Override
	public void add(ShareContent s) {
		this.getHibernateTemplate().save(s);
	}

	@Override
	public void update(ShareContent s) {
		this.getHibernateTemplate().update(s);
	}

	@Override
	public void delete(ShareContent s) {
		this.getHibernateTemplate().delete(s);
	}

	@Override
	public ShareContent getById(int id) {
		return this.getHibernateTemplate().get(ShareContent.class, id);
	}
	@Override
	public List<ShareContent> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<ShareContent> getAll() {
		String hql = "from ShareContent";
		return this.getHibernateTemplate().find(hql);
	}
}
