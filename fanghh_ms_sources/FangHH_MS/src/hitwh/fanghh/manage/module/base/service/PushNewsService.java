package hitwh.fanghh.manage.module.base.service;

import java.util.List;

import hitwh.fanghh.manage.pojo.building.PushNews;

public interface PushNewsService {

	void add(PushNews c);

	void update(PushNews c);

	void delete(PushNews c);

	public List<PushNews> searchByHql(String hql);

	public List<PushNews> getAll();

	public PushNews getById(int id);

}
