package hitwh.fanghh.manage.module.base.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.Region;

public interface RegionService {
	public void add(Region r);
	
	public void update(Region r);
	
	public void delete(Region r);

	public List<Region> getAll();

	public List<Region> searchByHql(String hql);

	public Region getById(int id);
}
