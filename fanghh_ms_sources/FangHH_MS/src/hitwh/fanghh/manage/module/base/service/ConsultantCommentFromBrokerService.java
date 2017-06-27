package hitwh.fanghh.manage.module.base.service;
import java.util.List;

import hitwh.fanghh.manage.pojo.building.ConsultantCommentFromBroker;

public interface ConsultantCommentFromBrokerService {
	public void update(ConsultantCommentFromBroker ccfb);
	
	public void delete(ConsultantCommentFromBroker ccfb);
	
	public List<ConsultantCommentFromBroker> searchByHql(String hql);

	public ConsultantCommentFromBroker  getById(int id);

	public List<ConsultantCommentFromBroker> getAll();
		
}
