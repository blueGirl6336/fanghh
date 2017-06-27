
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Commentpic;

public interface CommentpicDao {
    int deleteByPrimaryKey(Integer cpId);

    int insert(Commentpic record);

    int insertSelective(Commentpic record);

    Commentpic selectByPrimaryKey(Integer cpId);

    int updateByPrimaryKeySelective(Commentpic record);

    int updateByPrimaryKey(Commentpic record);
}