
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Logmessage;

public interface LogmessageDao {
    int deleteByPrimaryKey(Integer logId);

    int insert(Logmessage record);

    int insertSelective(Logmessage record);

    Logmessage selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(Logmessage record);

    int updateByPrimaryKey(Logmessage record);
}