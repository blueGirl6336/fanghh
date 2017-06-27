package hitwh.fanghh.manage.module.base.dao.impl;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.PicTalkDao;
import hitwh.fanghh.manage.module.base.dao.PropertyDao;
import hitwh.fanghh.manage.pojo.building.PicTalk;
import hitwh.fanghh.manage.pojo.building.Property;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class PicTalkDaoImpl extends BaseDaoImpl implements PicTalkDao{
	@Override
	public void add(PicTalk p) {
		this.getHibernateTemplate().save(p);
	}

	@Override
	public void update(PicTalk p) {
		this.getHibernateTemplate().update(p);
	}

	@Override
	public void delete(PicTalk p) {
		this.getHibernateTemplate().delete(p);
	}

	@Override
	public PicTalk getById(int id) {
		return this.getHibernateTemplate().get(PicTalk.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PicTalk> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<PicTalk> getAll() {
		String hql = "from PicTalk";
		return this.getHibernateTemplate().find(hql);
	}

}
