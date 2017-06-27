
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Financenews;

public interface FinancenewsDao {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Financenews record);

    int insertSelective(Financenews record);

    Financenews selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Financenews record);

    int updateByPrimaryKey(Financenews record);
}