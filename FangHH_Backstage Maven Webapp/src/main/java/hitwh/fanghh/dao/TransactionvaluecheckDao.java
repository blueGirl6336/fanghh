
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Transactionvaluecheck;

public interface TransactionvaluecheckDao {
    int deleteByPrimaryKey(Integer checkId);

    int insert(Transactionvaluecheck record);

    int insertSelective(Transactionvaluecheck record);

    Transactionvaluecheck selectByPrimaryKey(Integer checkId);

    int updateByPrimaryKeySelective(Transactionvaluecheck record);

    int updateByPrimaryKey(Transactionvaluecheck record);
}