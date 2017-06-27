
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Invitationcode;

public interface InvitationcodeDao {
    int deleteByPrimaryKey(Integer icId);

    int insert(Invitationcode record);

    int insertSelective(Invitationcode record);

    Invitationcode selectByPrimaryKey(Integer icId);

    int updateByPrimaryKeySelective(Invitationcode record);

    int updateByPrimaryKey(Invitationcode record);
}