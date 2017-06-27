
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Buildingsellingpoint;

public interface BuildingsellingpointDao {
    int deleteByPrimaryKey(Integer bspId);

    int insert(Buildingsellingpoint record);

    int insertSelective(Buildingsellingpoint record);

    Buildingsellingpoint selectByPrimaryKey(Integer bspId);

    int updateByPrimaryKeySelective(Buildingsellingpoint record);

    int updateByPrimaryKey(Buildingsellingpoint record);
}