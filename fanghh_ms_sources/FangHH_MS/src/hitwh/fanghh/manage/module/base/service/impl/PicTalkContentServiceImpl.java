package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.PicTalkContentDao;
import hitwh.fanghh.manage.module.base.dao.PicTalkDao;
import hitwh.fanghh.manage.module.base.service.PicTalkContentService;
import hitwh.fanghh.manage.module.base.service.PicTalkService;
import hitwh.fanghh.manage.pojo.building.PicTalk;
import hitwh.fanghh.manage.pojo.building.PicTalkContent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PicTalkContentServiceImpl implements PicTalkContentService{
	@Autowired
	private PicTalkContentDao picTalkContentDao;
	@Override
	public void add(PicTalkContent p) {
		// TODO Auto-generated method stub
		picTalkContentDao.add(p);
	}

	@Override
	public void update(PicTalkContent p) {
		// TODO Auto-generated method stub
		picTalkContentDao.update(p);
	}

	@Override
	public void delete(PicTalkContent p) {
		// TODO Auto-generated method stub
		picTalkContentDao.delete(p);
	}

	@Override
	public List<PicTalkContent> searchByHql(String hql) {
		// TODO Auto-generated method stub
		return picTalkContentDao.searchByHql(hql);
	}

	@Override
	public PicTalkContent getById(int id) {
		// TODO Auto-generated method stub
		return picTalkContentDao.getById(id);
	}

	@Override
	public List<PicTalkContent> getAll() {
		// TODO Auto-generated method stub
		return picTalkContentDao.getAll();
	}
}
