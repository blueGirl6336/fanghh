
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Grouporderstatus;

public interface GrouporderstatusDao {
    int deleteByPrimaryKey(Integer statusId);

    int insert(Grouporderstatus record);

    int insertSelective(Grouporderstatus record);

    Grouporderstatus selectByPrimaryKey(Integer statusId);

    int updateByPrimaryKeySelective(Grouporderstatus record);

    int updateByPrimaryKey(Grouporderstatus record);
}