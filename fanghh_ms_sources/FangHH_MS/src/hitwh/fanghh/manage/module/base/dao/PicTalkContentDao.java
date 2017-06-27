package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.PicTalkContent;

import java.util.List;

public interface PicTalkContentDao {
	public void add(PicTalkContent p);
	
	public void update(PicTalkContent p);
	
	public void delete(PicTalkContent p);
	
	public PicTalkContent getById(int id);

	public List<PicTalkContent> searchByHql(String hql);

	public List<PicTalkContent> getAll();
}
