
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Consultantcustomer;

public interface ConsultantcustomerDao {
    int deleteByPrimaryKey(Integer ccId);

    int insert(Consultantcustomer record);

    int insertSelective(Consultantcustomer record);

    Consultantcustomer selectByPrimaryKey(Integer ccId);

    int updateByPrimaryKeySelective(Consultantcustomer record);

    int updateByPrimaryKey(Consultantcustomer record);
}