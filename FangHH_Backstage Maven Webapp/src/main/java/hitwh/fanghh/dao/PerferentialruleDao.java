
package hitwh.fanghh.dao;

import java.util.List;

import hitwh.fanghh.pojo.Perferentialrule;

public interface PerferentialruleDao {
    int deleteByPrimaryKey(Integer ruleId);

    int insert(Perferentialrule record);

    int insertSelective(Perferentialrule record);

    Perferentialrule selectByPrimaryKey(Integer ruleId);

    int updateByPrimaryKeySelective(Perferentialrule record);

    int updateByPrimaryKey(Perferentialrule record);
    
    List<Perferentialrule> selectByActivityId(Integer activityId);
    
    int deleteByActivityId(Integer activityId);
}