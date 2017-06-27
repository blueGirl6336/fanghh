
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Bankcardbond;

public interface BankcardbondDao {
    int deleteByPrimaryKey(Integer bcbId);

    int insert(Bankcardbond record);

    int insertSelective(Bankcardbond record);

    Bankcardbond selectByPrimaryKey(Integer bcbId);

    int updateByPrimaryKeySelective(Bankcardbond record);

    int updateByPrimaryKey(Bankcardbond record);
}