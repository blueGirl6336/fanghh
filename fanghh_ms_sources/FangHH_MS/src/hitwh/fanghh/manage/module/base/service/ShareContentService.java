package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.ShareContent;

import java.util.List;

public interface ShareContentService {
	public void add( ShareContent s);
	
	public void update( ShareContent s);
	
	public void delete( ShareContent s);

	public List< ShareContent> searchByHql(String hql);

	public ShareContent getById(int id);

	 public List< ShareContent> getAll();
}
