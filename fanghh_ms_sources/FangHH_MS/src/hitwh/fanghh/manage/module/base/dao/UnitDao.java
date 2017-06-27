package hitwh.fanghh.manage.module.base.dao;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.Building;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
import hitwh.fanghh.manage.pojo.building.Unit;

public interface UnitDao {
	public void add(Unit u);
	
	public void update(Unit u);
	
	public void delete(Unit u);
	
	public Unit getById(int id);

	public List<Unit> searchByHql(String hql);

	public List<Unit> getAll();

	public List<InfoForComb> getAllForCon();	
}
