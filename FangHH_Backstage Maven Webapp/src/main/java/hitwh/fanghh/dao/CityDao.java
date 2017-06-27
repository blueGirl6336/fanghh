
package hitwh.fanghh.dao;

import java.util.List;

import hitwh.fanghh.pojo.City;

public interface CityDao {
    int deleteByPrimaryKey(Integer cityId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer cityId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
    
    List<City> selectAllCity();
}