package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.PerferentialHouseListDao;
import hitwh.fanghh.manage.module.base.service.PerferentialHouseListService;
import hitwh.fanghh.manage.pojo.building.PerferentialHouseList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PerferentialHouseListServiceImpl  implements PerferentialHouseListService{

	@Autowired
	private  PerferentialHouseListDao perferentialHouseListDao;
	@Override
	public void add( PerferentialHouseList c) {
		// TODO Auto-generated method stub
		perferentialHouseListDao.add(c);
	}

	@Override
	public void update( PerferentialHouseList c) {
		// TODO Auto-generated method stub
		perferentialHouseListDao.update(c);
	}

	@Override
	public void delete( PerferentialHouseList c) {
		// TODO Auto-generated method stub
		perferentialHouseListDao.delete(c);
	}
	@Override
	public List< PerferentialHouseList> searchByHql(String hql) {
		
		return perferentialHouseListDao.searchByHql(hql);
	}
	@Override
	public  PerferentialHouseList getById(int id) {
		return perferentialHouseListDao.getById(id);
	}
	@Override
	public List< PerferentialHouseList> getAll() {
		return perferentialHouseListDao.getAll();
	}

	@Override
	public List<PerferentialHouseList> searchByPhlId(Integer phlId) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("select p from PerferentialHouseList as p where phlId = "  + phlId);
		return perferentialHouseListDao.searchByHql(hql.toString());
	}
}
