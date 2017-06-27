
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Fundflowrecord;

public interface FundflowrecordDao {
    int deleteByPrimaryKey(Integer fundId);

    int insert(Fundflowrecord record);

    int insertSelective(Fundflowrecord record);

    Fundflowrecord selectByPrimaryKey(Integer fundId);

    int updateByPrimaryKeySelective(Fundflowrecord record);

    int updateByPrimaryKey(Fundflowrecord record);
}