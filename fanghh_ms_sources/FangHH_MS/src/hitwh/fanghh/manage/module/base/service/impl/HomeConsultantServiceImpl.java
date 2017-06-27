package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.HomeConsultantDao;
import hitwh.fanghh.manage.module.base.service.HomeConsultantService;
import hitwh.fanghh.manage.pojo.building.HomeConsultant;
@Service
public class HomeConsultantServiceImpl implements HomeConsultantService{

	@Autowired
	private HomeConsultantDao homeConsultantDao;


	@Override
	public void update(HomeConsultant b) {
		homeConsultantDao.update(b);
	}

	@Override
	public void delete(HomeConsultant b) {
		homeConsultantDao.delete(b);
	}
	@Override
	public List<HomeConsultant> searchByHql(String hql) {
		
		return homeConsultantDao.searchByHql(hql);
	}
	@Override
	public HomeConsultant getById(int id) {
		return homeConsultantDao.getById(id);
	}
	@Override
	public List<HomeConsultant> getAll() {
		return homeConsultantDao.getAll();
	}
}
