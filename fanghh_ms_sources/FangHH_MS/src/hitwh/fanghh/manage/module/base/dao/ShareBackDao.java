package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.ShareBack;
import hitwh.fanghh.manage.pojo.building.SurroundFacility;

import java.util.List;

public interface ShareBackDao {
	public void add(ShareBack s);
	
	public void update(ShareBack s);
	
	public void delete(ShareBack s);
	
	public ShareBack getById(int id);

	public List<ShareBack> searchByHql(String hql);

	public List<ShareBack> getAll();	
}
