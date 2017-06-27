package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.PicTalkContentDao;
import hitwh.fanghh.manage.module.base.dao.PicTalkDao;
import hitwh.fanghh.manage.pojo.building.PicTalk;
import hitwh.fanghh.manage.pojo.building.PicTalkContent;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PicTalkContentDaoImpl extends BaseDaoImpl implements PicTalkContentDao{
	@Override
	public void add(PicTalkContent p) {
		this.getHibernateTemplate().save(p);
	}

	@Override
	public void update(PicTalkContent p) {
		this.getHibernateTemplate().update(p);
	}

	@Override
	public void delete(PicTalkContent p) {
		this.getHibernateTemplate().delete(p);
	}

	@Override
	public PicTalkContent getById(int id) {
		return this.getHibernateTemplate().get(PicTalkContent.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PicTalkContent> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<PicTalkContent> getAll() {
		String hql = "from PicTalkContent";
		return this.getHibernateTemplate().find(hql);
	}
}
