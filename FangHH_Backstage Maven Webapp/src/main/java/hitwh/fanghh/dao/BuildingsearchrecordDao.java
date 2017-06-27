
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Buildingsearchrecord;

public interface BuildingsearchrecordDao {
    int deleteByPrimaryKey(Integer bsrId);

    int insert(Buildingsearchrecord record);

    int insertSelective(Buildingsearchrecord record);

    Buildingsearchrecord selectByPrimaryKey(Integer bsrId);

    int updateByPrimaryKeySelective(Buildingsearchrecord record);

    int updateByPrimaryKey(Buildingsearchrecord record);
}