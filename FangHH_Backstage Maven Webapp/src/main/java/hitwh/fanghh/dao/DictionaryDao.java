
package hitwh.fanghh.dao;

import java.util.List;

import hitwh.fanghh.pojo.Dictionary;

public interface DictionaryDao
{
	int deleteByPrimaryKey(Integer id);

	int insert(Dictionary record);

	int insertSelective(Dictionary record);

	Dictionary selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Dictionary record);

	int updateByPrimaryKey(Dictionary record);

	List<Dictionary> selectByDictCode(String dictcode);
}