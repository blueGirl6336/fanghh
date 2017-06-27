
package hitwh.fanghh.dao;

import org.apache.ibatis.annotations.Param;

import hitwh.fanghh.pojo.Unit;

public interface UnitDao {
    int deleteByPrimaryKey(Integer unitId);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer unitId);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);
    
    String getUnitCodeById(@Param("unitId") Integer unitId);
    
    int getRoofIdById(@Param("unitId") Integer unitId);
}