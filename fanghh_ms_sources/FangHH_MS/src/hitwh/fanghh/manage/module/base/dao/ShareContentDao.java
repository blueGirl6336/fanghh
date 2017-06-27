package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.ShareContent;

import java.util.List;

public interface ShareContentDao {
	public void add(ShareContent s);
	
	public void update(ShareContent s);
	
	public void delete(ShareContent s);
	
	public ShareContent getById(int id);

	public List<ShareContent> searchByHql(String hql);

	public List<ShareContent> getAll();
}
