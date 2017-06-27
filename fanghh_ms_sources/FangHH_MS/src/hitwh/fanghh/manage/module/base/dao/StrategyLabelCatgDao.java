package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.StrategyContent;
import hitwh.fanghh.manage.pojo.building.StrategyLabelCatg;

import java.util.List;

public interface StrategyLabelCatgDao {
	public void add(StrategyLabelCatg s);
	
	public void update(StrategyLabelCatg s);
	
	public void delete(StrategyLabelCatg s);
	
	public StrategyLabelCatg getById(int id);

	public List<StrategyLabelCatg> searchByHql(String hql);

	public List<StrategyLabelCatg> getAll();
}
