
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Housesourcepic;

public interface HousesourcepicDao {
    int deleteByPrimaryKey(Integer hspId);

    int insert(Housesourcepic record);

    int insertSelective(Housesourcepic record);

    Housesourcepic selectByPrimaryKey(Integer hspId);

    int updateByPrimaryKeySelective(Housesourcepic record);

    int updateByPrimaryKey(Housesourcepic record);
}