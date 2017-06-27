package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.ShareBackDao;
import hitwh.fanghh.manage.module.base.dao.ShareContentDao;
import hitwh.fanghh.manage.module.base.service.ShareBackService;
import hitwh.fanghh.manage.module.base.service.ShareContentService;
import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.ShareContent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareContentServiceImpl implements ShareContentService{
	@Autowired
	private ShareContentDao shareContentDao;
	@Override
	public void add(ShareContent s) {
		// TODO Auto-generated method stub
		shareContentDao.add(s);
	}

	@Override
	public void update(ShareContent s) {
		// TODO Auto-generated method stub
		shareContentDao.update(s);
	}

	@Override
	public void delete(ShareContent s) {
		// TODO Auto-generated method stub
		shareContentDao.delete(s);
	}
	@Override
	public List<ShareContent> searchByHql(String hql) {
		
		return shareContentDao.searchByHql(hql);
	}
	@Override
	public ShareContent getById(int id) {
		return shareContentDao.getById(id);
		
	}
	@Override
	public List<ShareContent> getAll() {
		return shareContentDao.getAll();
	}
}
