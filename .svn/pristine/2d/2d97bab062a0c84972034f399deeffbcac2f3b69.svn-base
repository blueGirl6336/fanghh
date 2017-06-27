
package hitwh.fanghh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hitwh.fanghh.pojo.Clearancehouselist;
import hitwh.fanghh.pojo.Perferentialhouselist;

public interface ClearancehouselistDao {
    int deleteByPrimaryKey(Integer chlId);
    int deleteByActivityId(Integer activityId);
    int insert(Clearancehouselist record);

    int insertSelective(Clearancehouselist record);

    Clearancehouselist selectByPrimaryKey(Integer chlId);

    int updateByPrimaryKeySelective(Clearancehouselist record);

    int updateByPrimaryKey(Clearancehouselist record);
    
    List<Clearancehouselist> selectByActivityId(@Param("activityId")Integer activityId);
    
    int selectIdByHouseId(@Param("houseId") Integer houseId);
}