package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.BuildingCommentDao;
import hitwh.fanghh.manage.module.base.service.BuildingCommentService;
import hitwh.fanghh.manage.pojo.building.BuildingComment;
@Service
public class BuildingCommentServiceImpl implements BuildingCommentService{

	@Autowired
	private BuildingCommentDao buildingCommentDao;


	@Override
	public void update(BuildingComment b) {
		// TODO Auto-generated method stub
		buildingCommentDao.update(b);
	}

	@Override
	public void delete(BuildingComment b) {
		// TODO Auto-generated method stub
		buildingCommentDao.delete(b);
	}
	@Override
	public List<BuildingComment> searchByHql(String hql) {
		
		return buildingCommentDao.searchByHql(hql);
	}
	@Override
	public BuildingComment getById(int id) {
		return buildingCommentDao.getById(id);
	}
	@Override
	public List<BuildingComment> getAll() {
		return buildingCommentDao.getAll();
	}
}
