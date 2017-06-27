package hitwh.fanghh.manage.module.base.service;

import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.SurroundFacility;

import java.util.List;

public interface ShareBackService {
	public void add( ShareBack s);
	
	public void update( ShareBack s);
	
	public void delete( ShareBack s);

	public List< ShareBack> searchByHql(String hql);

	public ShareBack getById(int id);

	 public List< ShareBack> getAll();
}
