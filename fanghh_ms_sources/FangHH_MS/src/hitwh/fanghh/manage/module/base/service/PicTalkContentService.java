package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.PicTalkContent;

import java.util.List;

public interface PicTalkContentService {
	public void add(PicTalkContent p);
	
	public void update(PicTalkContent p);
	
	public void delete(PicTalkContent p);

	public List<PicTalkContent> searchByHql(String hql);

	public PicTalkContent getById(int id);

	public List<PicTalkContent> getAll();
}
