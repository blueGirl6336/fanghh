
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Cashbackrecord;

public interface CashbackrecordDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Cashbackrecord record);

    int insertSelective(Cashbackrecord record);

    Cashbackrecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(Cashbackrecord record);

    int updateByPrimaryKey(Cashbackrecord record);
}