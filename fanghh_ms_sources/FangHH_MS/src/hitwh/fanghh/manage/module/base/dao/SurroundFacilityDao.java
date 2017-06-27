package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.SurroundFacility;
import hitwh.fanghh.manage.pojo.building.Unit;

import java.util.List;

public interface SurroundFacilityDao {
	public void add(SurroundFacility s);
	
	public void update(SurroundFacility s);
	
	public void delete(SurroundFacility s);
	
	public SurroundFacility getById(int id);

	public List<SurroundFacility> searchByHql(String hql);

	public List<SurroundFacility> getAll();	
}
