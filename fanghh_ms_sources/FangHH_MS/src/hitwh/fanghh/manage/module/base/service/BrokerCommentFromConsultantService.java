package hitwh.fanghh.manage.module.base.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.BrokerCommentFromConsultant;

public interface BrokerCommentFromConsultantService {
	public void update(BrokerCommentFromConsultant b);
	
	public void delete(BrokerCommentFromConsultant b);

	public List<BrokerCommentFromConsultant> searchByHql(String hql);

	public BrokerCommentFromConsultant getById(int id);

	public List<BrokerCommentFromConsultant> getAll();
	
}
