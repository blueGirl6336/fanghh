package hitwh.fanghh.manage.module.base.dao;

import java.util.List;

import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.pojo.building.Broker;

public interface BrokerDao {

	List<Broker> getAll();

	void add(Broker c);

	void update(Broker c);

	void delete(Broker c);

	public Broker getById(int id);
	
	public Broker getByBrokerId(Integer brokerId);

	public List<Broker> searchByHql(String hql);
	
	public Broker getByUserId(User user);
	
}