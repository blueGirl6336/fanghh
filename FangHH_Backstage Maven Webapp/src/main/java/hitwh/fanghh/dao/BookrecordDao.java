
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Bookrecord;

public interface BookrecordDao {
    int insert(Bookrecord record);

    int insertSelective(Bookrecord record);
}