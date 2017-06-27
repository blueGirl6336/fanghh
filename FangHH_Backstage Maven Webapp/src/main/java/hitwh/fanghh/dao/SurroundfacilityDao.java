
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Surroundfacility;

public interface SurroundfacilityDao {
    int deleteByPrimaryKey(Integer sfId);

    int insert(Surroundfacility record);

    int insertSelective(Surroundfacility record);

    Surroundfacility selectByPrimaryKey(Integer sfId);

    int updateByPrimaryKeySelective(Surroundfacility record);

    int updateByPrimaryKey(Surroundfacility record);
    
    Surroundfacility selectByBuildingId(Integer buildingId);
}