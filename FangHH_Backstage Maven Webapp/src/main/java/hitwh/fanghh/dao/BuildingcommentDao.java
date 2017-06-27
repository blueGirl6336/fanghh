
package hitwh.fanghh.dao;

import java.util.List;

import hitwh.fanghh.pojo.Buildingcomment;
import hitwh.fanghh.pojo.Housepricetrend;

public interface BuildingcommentDao {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Buildingcomment record);

    int insertSelective(Buildingcomment record);

    Buildingcomment selectByPrimaryKey(Integer commentId);
    
    List<Buildingcomment> selectByBuildingId(Integer buildingId);
    
    List<Buildingcomment> getAllBuildingComment();

    int updateByPrimaryKeySelective(Buildingcomment record);

    int updateByPrimaryKey(Buildingcomment record);
}