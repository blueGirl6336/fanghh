package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.TalksPlacard;

import java.util.List;

public interface TalksPlacardService {
	public void add(TalksPlacard t);
	
	public void update(TalksPlacard t);
	
	public void delete(TalksPlacard t);
	
	public TalksPlacard getById(int id);

	public List<TalksPlacard> searchByHql(String hql);

	public List<TalksPlacard> getAll();
}
