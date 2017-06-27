package hitwh.fanghh.manage.module.base.service;


import java.util.List;

import hitwh.fanghh.manage.pojo.building.BuildingPropertyType;

public interface BuildingPropertyTypeService {
	public void add(BuildingPropertyType b);
	
	public void update(BuildingPropertyType b);
	
	public void delete(BuildingPropertyType b);

	public List<BuildingPropertyType> getAll();

	public List<BuildingPropertyType> searchByHql(String hql);
}
