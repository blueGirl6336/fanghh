
package hitwh.fanghh.dao;

import org.apache.ibatis.annotations.Param;

import hitwh.fanghh.pojo.Houserealpic;

public interface HouserealpicDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Houserealpic record);

    int insertSelective(Houserealpic record);

    Houserealpic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Houserealpic record);

    int updateByPrimaryKey(Houserealpic record);
    
    Houserealpic selectByHouseId(@Param("houseId") Integer houseId);
    
    int selectIdByHouseId(@Param("houseId") Integer houseId);
    
}