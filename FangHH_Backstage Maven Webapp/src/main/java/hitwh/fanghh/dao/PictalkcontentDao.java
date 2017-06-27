
package hitwh.fanghh.dao;

import java.util.List;

import hitwh.fanghh.pojo.Pictalkcontent;

public interface PictalkcontentDao {
    int deleteByPrimaryKey(Integer ptcId);

    int insert(Pictalkcontent record);

    int insertSelective(Pictalkcontent record);

    Pictalkcontent selectByPrimaryKey(Integer ptcId);

    int updateByPrimaryKeySelective(Pictalkcontent record);

    int updateByPrimaryKey(Pictalkcontent record);
    
    List<Pictalkcontent> getPicTalkContentByPtId(Integer ptId);
    
    int deleteByPtId(Integer ptId);
}