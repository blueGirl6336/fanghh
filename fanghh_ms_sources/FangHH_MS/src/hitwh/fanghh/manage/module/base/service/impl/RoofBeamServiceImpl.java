package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import hitwh.fanghh.manage.module.base.dao.RoofBeamDao;
import hitwh.fanghh.manage.module.base.service.RoofBeamService;
import hitwh.fanghh.manage.pojo.building.InfoForComb;
import hitwh.fanghh.manage.pojo.building.Region;
import hitwh.fanghh.manage.pojo.building.RoofBeam;
import hitwh.fanghh.manage.pojo.building.Unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoofBeamServiceImpl implements RoofBeamService{
	@Autowired
	private RoofBeamDao RoofBeamDao;
	@Override
	public void add(RoofBeam r) {
		// TODO Auto-generated method stub
		RoofBeamDao.add(r);
	}

	@Override
	public void update(RoofBeam r) {
		// TODO Auto-generated method stub
		RoofBeamDao.update(r);
	}

	@Override
	public void delete(RoofBeam r) {
		// TODO Auto-generated method stub
		RoofBeamDao.delete(r);
	}
	@Override
	public List<RoofBeam> searchByHql(String hql) {
		
		return RoofBeamDao.searchByHql(hql);
	}
	@Override
	public RoofBeam getById(int id) {
		return this.RoofBeamDao.getById(id);
	}
	@Override
	public List<RoofBeam> getAll() {
		return RoofBeamDao.getAll();
	}
	@Override
	public List<InfoForComb> getAllForCon() {
		// TODO Auto-generated method stub
		
		return RoofBeamDao.getAllForCon();
	}
}
