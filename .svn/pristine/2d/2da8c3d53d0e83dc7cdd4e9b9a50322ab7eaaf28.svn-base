package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.SalesDirectorDao;
import hitwh.fanghh.manage.module.base.service.SalesDirectorService;
import hitwh.fanghh.manage.pojo.building.SalesDirector;
@Service
public class SalesDirectorServiceImpl implements SalesDirectorService{

	@Autowired
	private SalesDirectorDao salesDirectorDao;


	@Override
	public void update(SalesDirector s) {
		salesDirectorDao.update(s);
	}

	@Override
	public void delete(SalesDirector s) {
		salesDirectorDao.delete(s);
	}
	@Override
	public List<SalesDirector> searchByHql(String hql) {
		
		return salesDirectorDao.searchByHql(hql);
	}
	@Override
	public SalesDirector getById(int id) {
		return salesDirectorDao.getById(id);
	}
	@Override
	public List<SalesDirector> getAll() {
		return salesDirectorDao.getAll();
	}
}
