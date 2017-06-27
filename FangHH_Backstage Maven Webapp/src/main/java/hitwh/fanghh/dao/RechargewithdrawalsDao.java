
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Rechargewithdrawals;

public interface RechargewithdrawalsDao {
    int deleteByPrimaryKey(Integer rwId);

    int insert(Rechargewithdrawals record);

    int insertSelective(Rechargewithdrawals record);

    Rechargewithdrawals selectByPrimaryKey(Integer rwId);

    int updateByPrimaryKeySelective(Rechargewithdrawals record);

    int updateByPrimaryKey(Rechargewithdrawals record);
}