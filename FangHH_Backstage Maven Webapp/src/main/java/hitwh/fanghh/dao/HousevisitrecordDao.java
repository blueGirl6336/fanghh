
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Housevisitrecord;

public interface HousevisitrecordDao {
    int deleteByPrimaryKey(Integer hvrId);

    int insert(Housevisitrecord record);

    int insertSelective(Housevisitrecord record);

    Housevisitrecord selectByPrimaryKey(Integer hvrId);

    int updateByPrimaryKeySelective(Housevisitrecord record);

    int updateByPrimaryKey(Housevisitrecord record);
}