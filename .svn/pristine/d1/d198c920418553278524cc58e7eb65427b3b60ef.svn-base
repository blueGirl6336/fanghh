package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.PushNewsDao;
import hitwh.fanghh.manage.module.base.service.PushNewsService;
import hitwh.fanghh.manage.pojo.building.PushNews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PushNewsServiceImpl implements PushNewsService{
	@Autowired
	private PushNewsDao pushNewsDao;
	@Override
	public void add(PushNews c) {
		// TODO Auto-generated method stub
		pushNewsDao.add(c);
	}

	@Override
	public void update(PushNews c) {
		pushNewsDao.update(c);
	}

	@Override
	public void delete(PushNews c) {
		pushNewsDao.delete(c);
	}
	@Override
	public List<PushNews> searchByHql(String hql) {
		
		return pushNewsDao.searchByHql(hql);
	}
	@Override
	public PushNews getById(int id) {
		return pushNewsDao.getById(id);
		
	}
	@Override
	public List<PushNews> getAll() {
		return pushNewsDao.getAll();
	}
}
