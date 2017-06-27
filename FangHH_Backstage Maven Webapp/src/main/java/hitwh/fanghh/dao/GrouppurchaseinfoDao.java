
package hitwh.fanghh.dao;

import java.util.List;

import hitwh.fanghh.pojo.Grouppurchaseinfo;

public interface GrouppurchaseinfoDao
{
	int deleteByPrimaryKey(Integer gpId);

	int insert(Grouppurchaseinfo record);

	int insertSelective(Grouppurchaseinfo record);

	Grouppurchaseinfo selectByPrimaryKey(Integer gpId);

	int updateByPrimaryKeySelective(Grouppurchaseinfo record);

	int updateByPrimaryKeyWithBLOBs(Grouppurchaseinfo record);

	int updateByPrimaryKey(Grouppurchaseinfo record);

	List<Grouppurchaseinfo> selectByActivityId(Integer activityId);
}