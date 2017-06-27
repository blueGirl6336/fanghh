
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Brokercommissionrecord;

public interface BrokercommissionrecordDao {
    int deleteByPrimaryKey(Integer bcrId);

    int insert(Brokercommissionrecord record);

    int insertSelective(Brokercommissionrecord record);

    Brokercommissionrecord selectByPrimaryKey(Integer bcrId);

    int updateByPrimaryKeySelective(Brokercommissionrecord record);

    int updateByPrimaryKey(Brokercommissionrecord record);
}