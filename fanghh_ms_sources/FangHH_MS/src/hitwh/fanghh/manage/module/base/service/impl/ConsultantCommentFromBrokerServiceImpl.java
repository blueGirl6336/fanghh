package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.ConsultantCommentFromBrokerDao;
import hitwh.fanghh.manage.module.base.service.ConsultantCommentFromBrokerService;
import hitwh.fanghh.manage.pojo.building.ConsultantCommentFromBroker;
@Service
public class ConsultantCommentFromBrokerServiceImpl implements ConsultantCommentFromBrokerService{

	@Autowired
	private ConsultantCommentFromBrokerDao consultantCommentFromBrokerDao;


	@Override
	public void update(ConsultantCommentFromBroker b) {
		consultantCommentFromBrokerDao.update(b);
	}

	@Override
	public void delete(ConsultantCommentFromBroker b) {
		consultantCommentFromBrokerDao.delete(b);
	}
	@Override
	public List<ConsultantCommentFromBroker> searchByHql(String hql) {
		
		return consultantCommentFromBrokerDao.searchByHql(hql);
	}
	@Override
	public ConsultantCommentFromBroker getById(int id) {
		return consultantCommentFromBrokerDao.getById(id);
	}
	@Override
	public List<ConsultantCommentFromBroker> getAll() {
		return consultantCommentFromBrokerDao.getAll();
	}
}
