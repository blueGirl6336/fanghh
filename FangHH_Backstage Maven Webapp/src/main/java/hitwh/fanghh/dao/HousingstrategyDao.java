
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Housingstrategy;

public interface HousingstrategyDao {
    int deleteByPrimaryKey(Integer hsId);

    int insert(Housingstrategy record);

    int insertSelective(Housingstrategy record);

    Housingstrategy selectByPrimaryKey(Integer hsId);

    int updateByPrimaryKeySelective(Housingstrategy record);

    int updateByPrimaryKey(Housingstrategy record);
}