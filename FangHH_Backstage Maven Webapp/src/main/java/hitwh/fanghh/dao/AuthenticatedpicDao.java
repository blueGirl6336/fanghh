
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Authenticatedpic;

public interface AuthenticatedpicDao {
    int deleteByPrimaryKey(Integer apId);

    int insert(Authenticatedpic record);

    int insertSelective(Authenticatedpic record);

    Authenticatedpic selectByPrimaryKey(Integer apId);

    int updateByPrimaryKeySelective(Authenticatedpic record);

    int updateByPrimaryKey(Authenticatedpic record);
}