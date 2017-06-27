
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Predestinationinfo;

public interface PredestinationinfoDao {
    int deleteByPrimaryKey(Integer piId);

    int insert(Predestinationinfo record);

    int insertSelective(Predestinationinfo record);

    Predestinationinfo selectByPrimaryKey(Integer piId);

    int updateByPrimaryKeySelective(Predestinationinfo record);

    int updateByPrimaryKey(Predestinationinfo record);
}