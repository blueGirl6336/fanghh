package hitwh.fanghh.manage.module.base.dao;


import hitwh.fanghh.manage.pojo.building.ConsultantCommentFromBroker;

import java.util.List;


public interface ConsultantCommentFromBrokerDao {
	public void update(ConsultantCommentFromBroker ccfb);
	
	public void delete(ConsultantCommentFromBroker ccfb);
	
	public ConsultantCommentFromBroker getById(int id);

	public List<ConsultantCommentFromBroker> searchByHql(String hql);

	public List<ConsultantCommentFromBroker> getAll();
}
