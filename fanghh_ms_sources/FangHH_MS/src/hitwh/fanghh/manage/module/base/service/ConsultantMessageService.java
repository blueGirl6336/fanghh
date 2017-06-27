package hitwh.fanghh.manage.module.base.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.ConsultantMessage;

public interface ConsultantMessageService {
	
	public void add(ConsultantMessage c);
	public void update(ConsultantMessage c);
	
	public void delete(ConsultantMessage c);

	public List<ConsultantMessage> searchByHql(String hql);

	public ConsultantMessage getById(int id);

	public List<ConsultantMessage> getAll();
	
}
