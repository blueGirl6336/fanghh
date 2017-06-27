package hitwh.fanghh.manage.service;

import hitwh.fanghh.manage.pojo.Dictionary;

import java.util.List;

public interface DictionaryService  extends CacheService {
	
	public void add(Dictionary d);
	
	public Dictionary getByCode(String code);
	
	public String getNameByCode(String code);
	
	public List<Dictionary> getAllGroup(String module);

	public List<Dictionary> getItemsByGroupCode(String groupCode);
	
	public List<Dictionary> getItemsByGroupCodeAndValue(String groupCode,String value);
	
	public List<Dictionary> getItemsByModule(String module);
	
	public void update(Dictionary d);
	
	public void delete(Dictionary d);

	public List<Dictionary> getAllDictionaryLikeModule(String string);
	
}
