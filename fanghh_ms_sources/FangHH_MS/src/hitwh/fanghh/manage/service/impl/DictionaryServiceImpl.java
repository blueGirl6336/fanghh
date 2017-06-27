package hitwh.fanghh.manage.service.impl;

import hitwh.fanghh.manage.dao.DictionaryDao;
import hitwh.fanghh.manage.pojo.Dictionary;
import hitwh.fanghh.manage.service.DictionaryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private DictionaryDao dictionaryDao;

	// 数据字典 map，用来缓存数据字典
	private ConcurrentHashMap<String, Dictionary> dicsInMem = new ConcurrentHashMap<String, Dictionary>();

	// 数据字典组map，按组code缓存
	private ConcurrentHashMap<String, List<Dictionary>> dicGroupInMem = new ConcurrentHashMap<String, List<Dictionary>>();

	/**
	 * 初始化缓存
	 */
	public void initCache(){
		List<Dictionary> dicList = this.dictionaryDao.getAll();
		if(dicList == null || dicList.size() ==0){
			return;
		}
		for(int i = 0; i < dicList.size(); i++){
			dicsInMem.put(dicList.get(i).getDictCode(), dicList.get(i));
		}
		
	}
	
	
	/*@Override
	public void fillBlankCache(List<PersonBaseInfo> personList) {
		//need do nothing
	}*/
	
	
	public void add(Dictionary d) {
		if (d.getDictCode() == null)
			return;
		// 是否缓存中已存在
		if (dicsInMem.containsKey(d.getDictCode()))
			dicsInMem.remove(d.getDictCode());
		this.dictionaryDao.add(d);
		this.dicsInMem.put(d.getDictCode(), d);
		// 数据字典组已经变化
		if (d.getDictParentCode() != null)
			this.dicGroupInMem.remove(d.getDictParentCode());
	}

	public void update(Dictionary d) {
		String code = d.getDictCode();
		dictionaryDao.update(d);
		if (code != null)
			this.dicsInMem.remove(code);
		if (d.getDictParentCode() != null)
			this.dicGroupInMem.remove(d.getDictParentCode());

	}

	public Dictionary getByCode(String code) {
		if (code == null)
			return null;
		if (this.dicsInMem.containsKey(code))
			return dicsInMem.get(code);
		Dictionary d = this.dictionaryDao.getByCode(code);
		if (d != null)
			this.dicsInMem.put(code, d);
		return d;
	}

	public String getNameByCode(String code) {
		if (code == null || code.length() == 0)
			return null;
		if (this.dicsInMem.containsKey(code)) {
			return this.dicsInMem.get(code).getDictName();
		}
		Dictionary d = this.getByCode(code);
		if (d == null)
			return code;
		else
			return d.getDictName();
	}

	public void delete(Dictionary d) {
		if (d.getDictCode() == null)
			this.dicsInMem.remove(d.getDictCode());
		if (d.getDictParentCode() != null)
			this.dicGroupInMem.remove(d.getDictParentCode());
		dictionaryDao.delete(d);
	}

	public List<Dictionary> getAllGroup(String module) {
		List<Dictionary> dList = this.dictionaryDao.getAllGroup(module);
		return dList;
	}

	public List<Dictionary> getItemsByGroupCode(String groupCode) {
		// 判断是否有效
		if (groupCode == null || groupCode.equals(""))
			return new ArrayList<Dictionary>();
		// 如果数据字典有，则从数据字典中获取
		if (dicGroupInMem.containsKey(groupCode)) {
			return dicGroupInMem.get(groupCode);
		}
		List<Dictionary> list = this.dictionaryDao.getItemsByGroupCode(groupCode);
		// 加入到数据字典
		dicGroupInMem.put(groupCode, list);
		return list;
	}

	public List<Dictionary> getItemsByGroupCodeAndValue(String groupCode, String value) {
		// 判断是否有效
		if (groupCode == null || groupCode.equals(""))
			return new ArrayList<Dictionary>();
		// 如果数据字典有，则从数据字典中获取
		if (dicGroupInMem.containsKey(groupCode)) {
			List<Dictionary> list = new ArrayList<Dictionary>();
			List<Dictionary> groupList = dicGroupInMem.get(groupCode);
			for (Dictionary d : groupList) {
				if (d.getDictValue().contains(value))
					list.add(d);
			}
			return list;
		}
		List<Dictionary> list = this.dictionaryDao.getItemsByGroupCodeAndValue(groupCode, value);
		return list;
	}

	public List<Dictionary> getItemsByModule(String module) {
		return this.dictionaryDao.getItemsByModule(module);
	}

	@Override
	public List<Dictionary> getAllDictionaryLikeModule(String module) {
		return this.dictionaryDao.getItemsLikeModule(module);
	}

}
