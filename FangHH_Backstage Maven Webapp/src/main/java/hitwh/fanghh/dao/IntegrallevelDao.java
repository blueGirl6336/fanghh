
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Integrallevel;

public interface IntegrallevelDao {
    int deleteByPrimaryKey(Integer ilId);

    int insert(Integrallevel record);

    int insertSelective(Integrallevel record);

    Integrallevel selectByPrimaryKey(Integer ilId);

    int updateByPrimaryKeySelective(Integrallevel record);

    int updateByPrimaryKey(Integrallevel record);
}