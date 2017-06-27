package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.ShareBackDao;
import hitwh.fanghh.manage.module.base.dao.SurroundFacilityDao;
import hitwh.fanghh.manage.module.base.service.ShareBackService;
import hitwh.fanghh.manage.module.base.service.SurroundFacilityService;
import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.SurroundFacility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareBackServiceImpl implements ShareBackService{
	@Autowired
	private ShareBackDao shareBackDao;
	@Override
	public void add(ShareBack s) {
		// TODO Auto-generated method stub
		shareBackDao.add(s);
	}

	@Override
	public void update(ShareBack s) {
		// TODO Auto-generated method stub
		shareBackDao.update(s);
	}

	@Override
	public void delete(ShareBack s) {
		// TODO Auto-generated method stub
		shareBackDao.delete(s);
	}
	@Override
	public List<ShareBack> searchByHql(String hql) {
		
		return shareBackDao.searchByHql(hql);
	}
	@Override
	public ShareBack getById(int id) {
		return shareBackDao.getById(id);
		
	}
	@Override
	public List<ShareBack> getAll() {
		return shareBackDao.getAll();
	}

}
