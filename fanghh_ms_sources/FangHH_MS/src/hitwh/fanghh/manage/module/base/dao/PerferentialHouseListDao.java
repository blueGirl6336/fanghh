package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.PerferentialHouseList;

import java.util.List;

public interface PerferentialHouseListDao {
	public void add(PerferentialHouseList p);
	
	public void update(PerferentialHouseList p);
	
	public void delete(PerferentialHouseList p);
	
	public PerferentialHouseList getById(int id);

	public List<PerferentialHouseList> searchByHql(String hql);

	public List<PerferentialHouseList> getAll();
}
