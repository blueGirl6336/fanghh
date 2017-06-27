package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.ConsultantMessageDao;
import hitwh.fanghh.manage.module.base.service.ConsultantMessageService;
import hitwh.fanghh.manage.pojo.building.ConsultantMessage;
@Service
public class ConsultantMessageServiceImpl implements ConsultantMessageService{

	@Autowired
	private ConsultantMessageDao consultantMessageDao;


	@Override
	public void update(ConsultantMessage c) {
		consultantMessageDao.update(c);
	}

	@Override
	public void delete(ConsultantMessage c) {
		consultantMessageDao.delete(c);
	}
	@Override
	public List<ConsultantMessage> searchByHql(String hql) {
		
		return consultantMessageDao.searchByHql(hql);
	}
	@Override
	public ConsultantMessage getById(int id) {
		return consultantMessageDao.getById(id);
	}
	@Override
	public List<ConsultantMessage> getAll() {
		return consultantMessageDao.getAll();
	}

	@Override
	public void add(ConsultantMessage c) {
		consultantMessageDao.add(c);
	}
}
