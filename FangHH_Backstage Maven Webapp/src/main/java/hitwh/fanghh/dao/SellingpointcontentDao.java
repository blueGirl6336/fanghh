
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Sellingpointcontent;

public interface SellingpointcontentDao {
    int deleteByPrimaryKey(Integer spcId);

    int insert(Sellingpointcontent record);

    int insertSelective(Sellingpointcontent record);

    Sellingpointcontent selectByPrimaryKey(Integer spcId);

    int updateByPrimaryKeySelective(Sellingpointcontent record);

    int updateByPrimaryKeyWithBLOBs(Sellingpointcontent record);

    int updateByPrimaryKey(Sellingpointcontent record);
}