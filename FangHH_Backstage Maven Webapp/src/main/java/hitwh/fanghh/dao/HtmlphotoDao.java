
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Htmlphoto;

public interface HtmlphotoDao {
    int deleteByPrimaryKey(Integer photoId);

    int insert(Htmlphoto record);

    int insertSelective(Htmlphoto record);

    Htmlphoto selectByPrimaryKey(Integer photoId);

    int updateByPrimaryKeySelective(Htmlphoto record);

    int updateByPrimaryKey(Htmlphoto record);
}