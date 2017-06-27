
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Buildingfeature;

public interface BuildingfeatureDao {
    int deleteByPrimaryKey(Integer bfId);

    int insert(Buildingfeature record);

    int insertSelective(Buildingfeature record);

    Buildingfeature selectByPrimaryKey(Integer bfId);

    int updateByPrimaryKeySelective(Buildingfeature record);

    int updateByPrimaryKey(Buildingfeature record);
}