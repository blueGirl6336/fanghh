package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.Developer;
import hitwh.fanghh.manage.pojo.building.House;

import java.util.List;

public interface DeveloperService {
	public void add(Developer d);
	
	public void update(Developer d);
	
	public void delete(Developer d);

	public List<Developer> searchByHql(String hql);

	public Developer getById(int id);

	public List<Developer> getAll();
}
