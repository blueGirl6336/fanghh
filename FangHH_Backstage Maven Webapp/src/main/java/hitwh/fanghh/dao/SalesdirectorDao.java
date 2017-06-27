
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Salesdirector;

public interface SalesdirectorDao {
    int deleteByPrimaryKey(Integer directorId);

    int insert(Salesdirector record);

    int insertSelective(Salesdirector record);

    Salesdirector selectByPrimaryKey(Integer directorId);

    int updateByPrimaryKeySelective(Salesdirector record);

    int updateByPrimaryKey(Salesdirector record);
}