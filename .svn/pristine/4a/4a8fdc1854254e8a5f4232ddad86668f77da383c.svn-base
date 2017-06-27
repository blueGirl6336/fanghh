package hitwh.fanghh.manage.module.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import hitwh.fanghh.manage.dao.impl.BaseDaoImpl;
import hitwh.fanghh.manage.module.base.dao.BuildingCommentDao;
import hitwh.fanghh.manage.pojo.building.BuildingComment;
@Repository
public class BuildingCommentDaoImpl extends BaseDaoImpl implements BuildingCommentDao{

	@Override
	public void update(BuildingComment b) {
		this.getHibernateTemplate().update(b);
	}

	@Override
	public void delete(BuildingComment b) {
		this.getHibernateTemplate().delete(b);
	}

	@Override
	public BuildingComment getById(int id) {
		return this.getHibernateTemplate().get(BuildingComment.class, id);
	}
	@Override
	public List<BuildingComment> searchByHql(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}
	@Override
	public List<BuildingComment> getAll() {
		String hql = "from BuildingComment";
		return this.getHibernateTemplate().find(hql);
	}


}
