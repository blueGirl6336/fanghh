
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Feedbackmess;

public interface FeedbackmessDao {
    int deleteByPrimaryKey(Integer fmId);

    int insert(Feedbackmess record);

    int insertSelective(Feedbackmess record);

    Feedbackmess selectByPrimaryKey(Integer fmId);

    int updateByPrimaryKeySelective(Feedbackmess record);

    int updateByPrimaryKey(Feedbackmess record);
}