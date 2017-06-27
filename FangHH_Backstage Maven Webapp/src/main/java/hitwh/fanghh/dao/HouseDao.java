package hitwh.fanghh.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import hitwh.fanghh.pojo.House;
import hitwh.fanghh.util.PageCalculate;

public interface HouseDao
{
	int deleteByPrimaryKey(Integer houseId);

	int insert(House record);

	int insertSelective(House record);

	House selectByPrimaryKey(Integer houseId);

	int updateByPrimaryKeySelective(House record);

	int updateByPrimaryKey(House record);

	List<House> selectByBuildingId(@Param("buildingId") Integer buildingId, @Param("page") PageCalculate pageCalculate);

	int countHouseByBuildingId(Integer buildingId);

	int updateAuditStatusByHouseId(@Param("houseId") Integer houseId, @Param("auditStatus") String auditStatus);

	int updateHouseApplicationStatusByHouseId(@Param("houseId") Integer houseId,
			@Param("houseApplicationStatus") String houseApplicationStatus);

	String getAuditStatusByHouseId(@Param("houseId") Integer houseId);

	String getHouseApplicationStatusByHouseId(@Param("houseId") Integer houseId);

	int updateAuditNotPassReason(@Param("houseId") Integer houseId,
			@Param("auditNotPassReason") String auditNotPassReason);

	String getAuditNotPassReasonByHouseId(@Param("houseId") Integer houseId);

	int addPerferentialPrice(@Param("houseId") Integer houseId, @Param("currentPrice") BigDecimal currentPrice);

	List<House> selectNoActivityByBuildingId(@Param("buildingId") Integer buildingId,
			@Param("page") PageCalculate pageCalculate);

	int countNoActivityHouseByBuildingId(Integer buildingId);
}