
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Discount;

public interface DiscountDao {
    int deleteByPrimaryKey(Integer discountId);

    int insert(Discount record);

    int insertSelective(Discount record);

    Discount selectByPrimaryKey(Integer discountId);

    int updateByPrimaryKeySelective(Discount record);

    int updateByPrimaryKey(Discount record);
}