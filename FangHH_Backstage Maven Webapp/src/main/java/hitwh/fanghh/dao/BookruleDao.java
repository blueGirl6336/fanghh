
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Bookrule;

public interface BookruleDao {
    int deleteByPrimaryKey(Integer ruleId);

    int insert(Bookrule record);

    int insertSelective(Bookrule record);

    Bookrule selectByPrimaryKey(Integer ruleId);

    int updateByPrimaryKeySelective(Bookrule record);

    int updateByPrimaryKey(Bookrule record);
}