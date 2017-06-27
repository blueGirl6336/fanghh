
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Pictalk;

public interface PictalkDao {
    int deleteByPrimaryKey(Integer ptId);

    int insert(Pictalk record);

    int insertSelective(Pictalk record);

    Pictalk selectByPrimaryKey(Integer ptId);

    int updateByPrimaryKeySelective(Pictalk record);

    int updateByPrimaryKey(Pictalk record);
    
	/**
	 * @discription 
	 * @author fengben
	 * @created 2016年12月27日下午2:28:56
	 * @param 
	 * @return
	 */
	int getPictalkId();
	
	Pictalk getPictalkByBuildingId(Integer buildingId);
	int getPictalkIdByBuildingId(Integer buildingId);
}