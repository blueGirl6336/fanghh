package hitwh.fanghh.manage.module.base.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.BuildingComment;

public interface BuildingCommentService {
	public void update(BuildingComment b);
	
	public void delete(BuildingComment b);

	public List<BuildingComment> searchByHql(String hql);

	public BuildingComment getById(int id);

	public List<BuildingComment> getAll();
	
}
