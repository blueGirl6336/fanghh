
package hitwh.fanghh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hitwh.fanghh.pojo.Store;
import hitwh.fanghh.util.PageCalculate;

public interface StoreDao
{
	int deleteByPrimaryKey(Integer storeId);

	int insert(Store record);

	int insertSelective(Store record);

	Store selectByPrimaryKey(Integer storeId);

	int updateByPrimaryKeySelective(Store record);

	int updateByPrimaryKeyWithBLOBs(Store record);

	int updateByPrimaryKey(Store record);

	int countStore();

	List<Store> selectAll(@Param("page") PageCalculate pageCalculate);

	List<Store> selectByKeyStoreName(@Param("keyStoreName") String keyStoreName,
			@Param("page") PageCalculate pageCalculate);

	int updateAuthenticationStatus(@Param("storeId") int storeId, @Param("status") String status,
			@Param("failedReason") String failedReason);

}