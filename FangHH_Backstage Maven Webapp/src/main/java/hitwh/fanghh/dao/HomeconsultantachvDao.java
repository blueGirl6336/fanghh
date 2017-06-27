
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Homeconsultantachv;

public interface HomeconsultantachvDao {
    int deleteByPrimaryKey(Integer hcaId);

    int insert(Homeconsultantachv record);

    int insertSelective(Homeconsultantachv record);

    Homeconsultantachv selectByPrimaryKey(Integer hcaId);

    int updateByPrimaryKeySelective(Homeconsultantachv record);

    int updateByPrimaryKey(Homeconsultantachv record);
}