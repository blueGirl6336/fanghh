package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.ShareInfo;

import java.util.List;

public interface ShareInfoService {
	public void add( ShareInfo s);
	
	public void update( ShareInfo s);
	
	public void delete( ShareInfo s);

	public List< ShareInfo> searchByHql(String hql);

	public ShareInfo getById(int id);

	 public List< ShareInfo> getAll();
}
