
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Integralrecord;

public interface IntegralrecordDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Integralrecord record);

    int insertSelective(Integralrecord record);

    Integralrecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(Integralrecord record);

    int updateByPrimaryKey(Integralrecord record);
}