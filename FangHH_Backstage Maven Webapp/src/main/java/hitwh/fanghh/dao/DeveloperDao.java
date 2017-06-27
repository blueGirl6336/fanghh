
package hitwh.fanghh.dao;

import java.util.List;

import hitwh.fanghh.pojo.Developer;

public interface DeveloperDao {
    int deleteByPrimaryKey(Integer developerId);

    int insert(Developer record);

    int insertSelective(Developer record);

    Developer selectByPrimaryKey(Integer developerId);

    int updateByPrimaryKeySelective(Developer record);

    int updateByPrimaryKey(Developer record);

	  
	    /**     
	     * @discription {在此输入一句话描述作用}
	     * @author wangxinjie       
	     * @created 2016年12月22日 下午1:40:09 
	     * @return     
	     */
	List<Developer> selectAll();
}