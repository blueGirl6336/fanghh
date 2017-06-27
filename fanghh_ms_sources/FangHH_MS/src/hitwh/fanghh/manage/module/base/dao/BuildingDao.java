package hitwh.fanghh.manage.module.base.dao;


import java.util.List;

import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.InfoForComb;

public interface BuildingDao {
	public void add(Building b);
	
	public void update(Building b);
	
	public void delete(Building b);
	
	public Building getById(int id);

	public List<Building> searchByHql(String hql);

	public List<Building> getAll();
	public List<InfoForComb> getAllForCon();
}
