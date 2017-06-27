package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import hitwh.fanghh.manage.module.base.dao.UnitDao;
import hitwh.fanghh.manage.module.base.service.UnitService;
import hitwh.fanghh.manage.pojo.building.House;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
import hitwh.fanghh.manage.pojo.building.Unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UnitServiceImpl implements UnitService{
	@Autowired
	private UnitDao UnitDao;
	@Override
	public void add(Unit u) {
		// TODO Auto-generated method stub
		UnitDao.add(u);
	}

	@Override
	public void update(Unit u) {
		// TODO Auto-generated method stub
		UnitDao.update(u);
	}

	@Override
	public void delete(Unit u) {
		// TODO Auto-generated method stub
		UnitDao.delete(u);
	}
	@Override
	public List<Unit> searchByHql(String hql) {
		
		return UnitDao.searchByHql(hql);
	}
	@Override
	public Unit getById(int id) {
		return UnitDao.getById(id);
		
	}
	@Override
	public List<Unit> getAll() {
		return UnitDao.getAll();
	}
	@Override
	public List<InfoForComb> getAllForCon() {
		
		return UnitDao.getAllForCon();
	}
}
