package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.Developer;
import hitwh.fanghh.manage.pojo.building.Unit;

import java.util.List;

public interface DeveloperDao {
	public void add(Developer d);
	
	public void update(Developer d);
	
	public void delete(Developer d);
	
	public Developer getById(int id);

	public List<Developer> searchByHql(String hql);

	public List<Developer> getAll();
}
