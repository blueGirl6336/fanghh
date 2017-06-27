
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.RPropertyBuilding;

public interface RPropertyBuildingDao {
    int deleteByPrimaryKey(Integer id);

    int insert(RPropertyBuilding record);

    int insertSelective(RPropertyBuilding record);

    RPropertyBuilding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RPropertyBuilding record);

    int updateByPrimaryKey(RPropertyBuilding record);
}