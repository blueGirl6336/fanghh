
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Pushnews;

public interface PushnewsDao {
    int deleteByPrimaryKey(Integer newsId);

    int insert(Pushnews record);

    int insertSelective(Pushnews record);

    Pushnews selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(Pushnews record);

    int updateByPrimaryKey(Pushnews record);
}