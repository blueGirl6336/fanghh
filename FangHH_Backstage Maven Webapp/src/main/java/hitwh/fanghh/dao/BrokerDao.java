
package hitwh.fanghh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import org.apache.ibatis.annotations.Param;


import hitwh.fanghh.pojo.Broker;
import hitwh.fanghh.pojo.Users;
import hitwh.fanghh.util.PageCalculate;

public interface BrokerDao
{
	int deleteByPrimaryKey(Integer brokerId);

	int insert(Broker record);

	int insertSelective(Broker record);

	Broker selectByPrimaryKey(Integer brokerId);
	Broker selectByUserId(Integer userId);

	int updateByPrimaryKeySelective(Broker record);

	int updateByPrimaryKey(Broker record);

	int updateBrokerTypeByBrokerId(@Param("brokerId") int brokerId, @Param("brokerType") String brokerType);
    
    Broker selectByRealName(String brokerName);
    Broker selectByIdNum(@Param("brokerIdcard")String brokerIdcard);
    
	int countUser(String applicateAuthentication);

	List<Broker> selectAllApplicatedUser(@Param("page") PageCalculate pageCalculate ,@Param("applicateAuthentication") String applicateAuthentication);

	List<Broker> selectByKeyBrokerName(@Param("keyBrokerName") String keyBrokerName,
			@Param("page") PageCalculate pageCalculate);

	
	int updateUserAuthentation(@Param("userId")Integer userId , @Param("brokerType")String brokerType , @Param("failedReason")String failedReason , @Param("status")String status);
	
	List<Broker> selectByKeyUserNameAndKeyRealNameAndIdNum(@Param("keyBrokerName") String keyBrokerName, @Param("keyUserName") String keyUserName,@Param("brokerIdcard") String brokerIdcard ,@Param("page") PageCalculate pageCalculate ,@Param("applicateAuthentication") String applicateAuthentication);
}