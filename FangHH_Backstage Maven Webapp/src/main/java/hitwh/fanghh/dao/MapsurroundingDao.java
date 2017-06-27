
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Mapsurrounding;

public interface MapsurroundingDao {
    int deleteByPrimaryKey(Integer msId);

    int insert(Mapsurrounding record);

    int insertSelective(Mapsurrounding record);

    Mapsurrounding selectByPrimaryKey(Integer msId);

    int updateByPrimaryKeySelective(Mapsurrounding record);

    int updateByPrimaryKey(Mapsurrounding record);
}