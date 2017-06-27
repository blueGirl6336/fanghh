package hitwh.fanghh.manage.module.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hitwh.fanghh.manage.module.base.dao.BrokerDao;
import hitwh.fanghh.manage.module.base.service.BrokerService;
import hitwh.fanghh.manage.pojo.building.Broker;

@Service
public class BrokerServiceImpl implements BrokerService{

	@Autowired
	private BrokerDao brokerDao;
	@Override
	public void add(Broker b) {
		// TODO Auto-generated method stub
		brokerDao.add(b);
	}

	@Override
	public void update(Broker b) {
		// TODO Auto-generated method stub
		brokerDao.update(b);
	}

	@Override
	public void delete(Broker b) {
		// TODO Auto-generated method stub
		brokerDao.delete(b);
	}
	@Override
	public List<Broker> searchByHql(String hql) {
		
		return brokerDao.searchByHql(hql);
	}
	@Override
	public Broker getById(int id) {
		return brokerDao.getById(id);
	}
	@Override
	public List<Broker> getAll() {
		return brokerDao.getAll();
	}

}
