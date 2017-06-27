package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.HomeConsultant;

import java.util.List;

public interface HomeConsultantDao {
	public void update(HomeConsultant h);
	
	public void delete(HomeConsultant h);
	
	public HomeConsultant getById(int id);

	public List<HomeConsultant> searchByHql(String hql);

	public List<HomeConsultant> getAll();
}