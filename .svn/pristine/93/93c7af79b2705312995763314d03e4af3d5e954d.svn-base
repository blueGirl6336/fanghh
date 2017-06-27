package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.ClearanceHouseListDao;
import hitwh.fanghh.manage.module.base.service.ClearanceHouseListService;
import hitwh.fanghh.manage.pojo.building.ClearanceHouseList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClearanceHouseListServiceImpl  implements ClearanceHouseListService{

	@Autowired
	private  ClearanceHouseListDao clearanceHouseListDao;
	@Override
	public void add( ClearanceHouseList p) {
		// TODO Auto-generated method stub
		clearanceHouseListDao.add(p);
	}

	@Override
	public void update( ClearanceHouseList p) {
		// TODO Auto-generated method stub
		clearanceHouseListDao.update(p);
	}

	@Override
	public void delete( ClearanceHouseList p) {
		// TODO Auto-generated method stub
		clearanceHouseListDao.delete(p);
	}
	@Override
	public List< ClearanceHouseList> searchByHql(String hql) {
		
		return clearanceHouseListDao.searchByHql(hql);
	}
	@Override
	public  ClearanceHouseList getById(int id) {
		return clearanceHouseListDao.getById(id);
	}
	@Override
	public List< ClearanceHouseList> getAll() {
		return clearanceHouseListDao.getAll();
	}

	@Override
	public List<ClearanceHouseList> searchByChlId(Integer chlId) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("select c from ClearanceHouseList as c where chlId = "  + chlId);
		return clearanceHouseListDao.searchByHql(hql.toString());
	}

}
