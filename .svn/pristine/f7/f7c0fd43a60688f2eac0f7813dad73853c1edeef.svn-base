package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.TalksPlacardDao;
import hitwh.fanghh.manage.module.base.service.TalksPlacardService;
import hitwh.fanghh.manage.pojo.building.TalksPlacard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalksPlacardServiceImpl implements TalksPlacardService{
	@Autowired
	private TalksPlacardDao talksPlacardDao;
	@Override
	public void add(TalksPlacard t) {
		// TODO Auto-generated method stub
		talksPlacardDao.add(t);
	}

	@Override
	public void update(TalksPlacard t) {
		// TODO Auto-generated method stub
		talksPlacardDao.update(t);
	}

	@Override
	public void delete(TalksPlacard t) {
		// TODO Auto-generated method stub
		talksPlacardDao.delete(t);
	}
	@Override
	public List<TalksPlacard> searchByHql(String hql) {
		
		return talksPlacardDao.searchByHql(hql);
	}
	@Override
	public TalksPlacard getById(int id) {
		return talksPlacardDao.getById(id);
		
	}
	@Override
	public List<TalksPlacard> getAll() {
		return talksPlacardDao.getAll();
	}
}
