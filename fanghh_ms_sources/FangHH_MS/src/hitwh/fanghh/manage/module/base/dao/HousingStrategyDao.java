package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.HouseStyle;
import hitwh.fanghh.manage.pojo.building.HousingStrategy;

import java.util.List;

public interface HousingStrategyDao {
	public void add(HousingStrategy h);
	
	public void update(HousingStrategy h);
	
	public void delete(HousingStrategy h);
	
	public HousingStrategy getById(int id);

	public List<HousingStrategy> getAll();

	public List<HousingStrategy> searchByHql(String hql);
}
