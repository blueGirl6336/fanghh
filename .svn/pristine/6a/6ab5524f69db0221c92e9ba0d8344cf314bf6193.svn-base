package hitwh.fanghh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hitwh.fanghh.pojo.Housestyle;
import hitwh.fanghh.util.PageCalculate;

public interface HousestyleDao
{
	int deleteByPrimaryKey(Integer styleId);

	int insert(Housestyle record);

	int insertSelective(Housestyle record);

	Housestyle selectByPrimaryKey(Integer styleId);

	int updateByPrimaryKeySelective(Housestyle record);

	int updateByPrimaryKeyWithBLOBs(Housestyle record);

	int updateByPrimaryKey(Housestyle record);

	int countHouseStyleByBuildingId(int buildingId);

	List<Housestyle> selectByBuildingId(@Param("buildingId") int buildingId, @Param("page") PageCalculate pageCalculate,
			@Param("applicationStatus") String applicationStatus);// applicationStatus要排除的状态

	int updateApplicationStatus(@Param("styleId") int styleId, @Param("applicationStatus") String applicationStatus);

	int updateAuditStatus(@Param("styleId") int styleId, @Param("auditStatus") String auditStatus,
			@Param("auditNotPassReason") String auditNotPassReason);
}