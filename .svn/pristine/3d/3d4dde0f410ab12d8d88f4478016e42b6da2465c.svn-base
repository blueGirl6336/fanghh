package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.manage.module.base.dao.BrokerCommentFromConsultantDao;
import hitwh.fanghh.manage.module.base.service.BrokerCommentFromConsultantService;
import hitwh.fanghh.manage.pojo.building.BrokerCommentFromConsultant;
@Service
public class BrokerCommentFromConsultantServiceImpl implements BrokerCommentFromConsultantService{

	@Autowired
	private BrokerCommentFromConsultantDao brokerCommentFromConsultantDao;


	@Override
	public void update(BrokerCommentFromConsultant b) {
		// TODO Auto-generated method stub
		brokerCommentFromConsultantDao.update(b);
	}

	@Override
	public void delete(BrokerCommentFromConsultant b) {
		// TODO Auto-generated method stub
		brokerCommentFromConsultantDao.delete(b);
	}
	@Override
	public List<BrokerCommentFromConsultant> searchByHql(String hql) {
		
		return brokerCommentFromConsultantDao.searchByHql(hql);
	}
	@Override
	public BrokerCommentFromConsultant getById(int id) {
		return brokerCommentFromConsultantDao.getById(id);
	}
	@Override
	public List<BrokerCommentFromConsultant> getAll() {
		return brokerCommentFromConsultantDao.getAll();
	}
}
