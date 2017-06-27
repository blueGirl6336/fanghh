
package hitwh.fanghh.dao;

import org.apache.ibatis.annotations.Param;

import hitwh.fanghh.pojo.Roofbeam;

public interface RoofbeamDao {
    int deleteByPrimaryKey(Integer roofId);

    int insert(Roofbeam record);

    int insertSelective(Roofbeam record);

    Roofbeam selectByPrimaryKey(Integer roofId);

    int updateByPrimaryKeySelective(Roofbeam record);

    int updateByPrimaryKey(Roofbeam record);
    
    String getRoofNameById(@Param("roofId") Integer roofId);
}