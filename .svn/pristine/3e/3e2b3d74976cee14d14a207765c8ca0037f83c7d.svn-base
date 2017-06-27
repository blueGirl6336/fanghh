package hitwh.fanghh.manage.module.base.service.impl;

import hitwh.fanghh.manage.module.base.dao.PicTalkDao;
import hitwh.fanghh.manage.module.base.service.PicTalkService;
import hitwh.fanghh.manage.pojo.building.PicTalk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PicTalkServiceImpl implements PicTalkService{
	@Autowired
	private PicTalkDao picTalkDao;
	@Override
	public void add(PicTalk p) {
		// TODO Auto-generated method stub
		picTalkDao.add(p);
	}

	@Override
	public void update(PicTalk p) {
		// TODO Auto-generated method stub
		picTalkDao.update(p);
	}

	@Override
	public void delete(PicTalk p) {
		// TODO Auto-generated method stub
		picTalkDao.delete(p);
	}

	@Override
	public List<PicTalk> searchByHql(String hql) {
		// TODO Auto-generated method stub
		return picTalkDao.searchByHql(hql);
	}

	@Override
	public PicTalk getById(int id) {
		// TODO Auto-generated method stub
		return picTalkDao.getById(id);
	}

	@Override
	public List<PicTalk> getAll() {
		// TODO Auto-generated method stub
		return picTalkDao.getAll();
	}

}
