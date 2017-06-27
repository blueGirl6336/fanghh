
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Traderecord;

public interface TraderecordDao {
    int deleteByPrimaryKey(Integer tradeId);

    int insert(Traderecord record);

    int insertSelective(Traderecord record);

    Traderecord selectByPrimaryKey(Integer tradeId);

    int updateByPrimaryKeySelective(Traderecord record);

    int updateByPrimaryKey(Traderecord record);
}