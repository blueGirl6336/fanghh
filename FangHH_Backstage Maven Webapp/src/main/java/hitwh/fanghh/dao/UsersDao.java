
package hitwh.fanghh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hitwh.fanghh.pojo.Store;
import hitwh.fanghh.pojo.Users;
import hitwh.fanghh.util.PageCalculate;

public interface UsersDao
{
	int deleteByPrimaryKey(Integer userId);

	int insert(Users record);

	int insertSelective(Users record);

	Users selectByPrimaryKey(Integer userId);

	int updateByPrimaryKeySelective(Users record);

	int updateByPrimaryKey(Users record);

	Users selectByUserName(String userName);
	int countUser();

	List<Users> selectAll(@Param("page") PageCalculate pageCalculate);

	List<Users> selectByKeyUserName(@Param("keyUserName") String keyUserName,
			@Param("page") PageCalculate pageCalculate);

	
	int updateUserAuthentation(@Param("userId")Integer userId , @Param("isAuthenticated")boolean isAuthenticated);
}