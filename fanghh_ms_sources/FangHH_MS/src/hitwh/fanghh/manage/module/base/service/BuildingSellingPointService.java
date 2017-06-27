package hitwh.fanghh.manage.module.base.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.BuildingSellingPoint;

public interface BuildingSellingPointService {
	public void add(BuildingSellingPoint b);
	
	public void update(BuildingSellingPoint b);
	
	public void delete(BuildingSellingPoint b);

	public List<BuildingSellingPoint> getAll();

	public List<BuildingSellingPoint> searchByHql(String hql);
}
