
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Ordersign;

public interface OrdersignDao {
    int deleteByPrimaryKey(Integer osId);

    int insert(Ordersign record);

    int insertSelective(Ordersign record);

    Ordersign selectByPrimaryKey(Integer osId);

    int updateByPrimaryKeySelective(Ordersign record);

    int updateByPrimaryKey(Ordersign record);
}