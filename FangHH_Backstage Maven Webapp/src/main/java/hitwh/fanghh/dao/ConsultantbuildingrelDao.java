
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Consultantbuildingrel;

public interface ConsultantbuildingrelDao {
    int deleteByPrimaryKey(Integer reId);

    int insert(Consultantbuildingrel record);

    int insertSelective(Consultantbuildingrel record);

    Consultantbuildingrel selectByPrimaryKey(Integer reId);

    int updateByPrimaryKeySelective(Consultantbuildingrel record);

    int updateByPrimaryKey(Consultantbuildingrel record);
}