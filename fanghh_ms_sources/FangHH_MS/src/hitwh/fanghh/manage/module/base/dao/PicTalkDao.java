package hitwh.fanghh.manage.module.base.dao;

import hitwh.fanghh.manage.pojo.building.PicTalk;
import hitwh.fanghh.manage.pojo.building.Property;

import java.util.List;

public interface PicTalkDao {
	public void add(PicTalk p);
	
	public void update(PicTalk p);
	
	public void delete(PicTalk p);
	
	public PicTalk getById(int id);

	public List<PicTalk> searchByHql(String hql);

	public List<PicTalk> getAll();
}
