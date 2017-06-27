
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Clearancehouseinfo;

public interface ClearancehouseinfoDao {
    int deleteByPrimaryKey(Integer chiId);

    int insert(Clearancehouseinfo record);

    int insertSelective(Clearancehouseinfo record);

    Clearancehouseinfo selectByPrimaryKey(Integer chiId);

    int updateByPrimaryKeySelective(Clearancehouseinfo record);

    int updateByPrimaryKeyWithBLOBs(Clearancehouseinfo record);

    int updateByPrimaryKey(Clearancehouseinfo record);
}