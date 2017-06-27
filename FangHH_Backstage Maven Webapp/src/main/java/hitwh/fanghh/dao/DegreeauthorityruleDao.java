
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Degreeauthorityrule;

public interface DegreeauthorityruleDao {
    int deleteByPrimaryKey(Integer darId);

    int insert(Degreeauthorityrule record);

    int insertSelective(Degreeauthorityrule record);

    Degreeauthorityrule selectByPrimaryKey(Integer darId);

    int updateByPrimaryKeySelective(Degreeauthorityrule record);

    int updateByPrimaryKey(Degreeauthorityrule record);
}