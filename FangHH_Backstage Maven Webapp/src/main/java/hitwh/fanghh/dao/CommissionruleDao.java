
package hitwh.fanghh.dao;

import java.util.List;

import hitwh.fanghh.pojo.Commissionrule;

public interface CommissionruleDao {
    int deleteByPrimaryKey(Integer ruleId);

    int insert(Commissionrule record);

    int insertSelective(Commissionrule record);

    Commissionrule selectByPrimaryKey(Integer ruleId);

    int updateByPrimaryKeySelective(Commissionrule record);

    int updateByPrimaryKey(Commissionrule record);
    
    List<Commissionrule> selectByBuildingId(Integer buildingId);
}