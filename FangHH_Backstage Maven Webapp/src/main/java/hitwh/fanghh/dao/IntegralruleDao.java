
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Integralrule;

public interface IntegralruleDao {
    int deleteByPrimaryKey(Integer ruleId);

    int insert(Integralrule record);

    int insertSelective(Integralrule record);

    Integralrule selectByPrimaryKey(Integer ruleId);

    int updateByPrimaryKeySelective(Integralrule record);

    int updateByPrimaryKey(Integralrule record);
}