
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Reservationorder;

public interface ReservationorderDao {
    int deleteByPrimaryKey(Integer roId);

    int insert(Reservationorder record);

    int insertSelective(Reservationorder record);

    Reservationorder selectByPrimaryKey(Integer roId);

    int updateByPrimaryKeySelective(Reservationorder record);

    int updateByPrimaryKey(Reservationorder record);
}