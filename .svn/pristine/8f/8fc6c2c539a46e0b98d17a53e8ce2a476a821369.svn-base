package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.ShareBackDao;
import hitwh.fanghh.manage.module.base.dao.ShareInfoDao;
import hitwh.fanghh.manage.module.base.service.ShareBackService;
import hitwh.fanghh.manage.module.base.service.ShareInfoService;
import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.ShareInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareInfoServiceImpl implements ShareInfoService{
	@Autowired
	private ShareInfoDao shareInfoDao;
	@Override
	public void add(ShareInfo s) {
		// TODO Auto-generated method stub
		shareInfoDao.add(s);
	}

	@Override
	public void update(ShareInfo s) {
		// TODO Auto-generated method stub
		shareInfoDao.update(s);
	}

	@Override
	public void delete(ShareInfo s) {
		// TODO Auto-generated method stub
		shareInfoDao.delete(s);
	}
	@Override
	public List<ShareInfo> searchByHql(String hql) {
		
		return shareInfoDao.searchByHql(hql);
	}
	@Override
	public ShareInfo getById(int id) {
		return shareInfoDao.getById(id);
		
	}
	@Override
	public List<ShareInfo> getAll() {
		return shareInfoDao.getAll();
	}
}
