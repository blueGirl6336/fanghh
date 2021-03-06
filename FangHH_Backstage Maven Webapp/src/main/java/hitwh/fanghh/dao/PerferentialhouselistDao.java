
package hitwh.fanghh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hitwh.fanghh.pojo.Perferentialhouselist;
import hitwh.fanghh.pojo.Perferentialrule;

public interface PerferentialhouselistDao {
    int deleteByPrimaryKey(Integer phlId);

    int insert(Perferentialhouselist record);

    int insertSelective(Perferentialhouselist record);

    Perferentialhouselist selectByPrimaryKey(Integer phlId);

    int updateByPrimaryKeySelective(Perferentialhouselist record);

    int updateByPrimaryKey(Perferentialhouselist record);
    
    
    List<Perferentialhouselist> selectByActivityId(@Param("activityId")Integer activityId);
    
    int selectIdByHouseId(@Param("houseId") Integer houseId);

	int deleteByActivityId(@Param("activityId")Integer activityId);
}