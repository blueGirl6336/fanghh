
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Talksplacard;

public interface TalksplacardDao {
    int deleteByPrimaryKey(Integer tpId);

    int insert(Talksplacard record);

    int insertSelective(Talksplacard record);

    Talksplacard selectByPrimaryKey(Integer tpId);

    int updateByPrimaryKeySelective(Talksplacard record);

    int updateByPrimaryKey(Talksplacard record);
}