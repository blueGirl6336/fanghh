
package hitwh.fanghh.dao;

import java.util.List;

import hitwh.fanghh.pojo.Region;

public interface RegionDao {
    int deleteByPrimaryKey(Integer regionId);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Integer regionId);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

	  
	    /**     
	     * @discription {在此输入一句话描述作用}
	     * @author wangxinjie       
	     * @created 2016年12月14日 下午3:59:53 
	     * @param cityId
	     * @return     
	     */
	List<Region> selectByCityId(Integer cityId);
}