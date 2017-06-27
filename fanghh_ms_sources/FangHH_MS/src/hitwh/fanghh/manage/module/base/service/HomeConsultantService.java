package hitwh.fanghh.manage.module.base.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.HomeConsultant;

public interface HomeConsultantService {
	public void update(HomeConsultant h);
	
	public void delete(HomeConsultant h);

	public List<HomeConsultant> searchByHql(String hql);

	public HomeConsultant getById(int id);

	public List<HomeConsultant> getAll();
	
}
