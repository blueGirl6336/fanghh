
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Voucher;

public interface VoucherDao {
    int deleteByPrimaryKey(Integer voucherId);

    int insert(Voucher record);

    int insertSelective(Voucher record);

    Voucher selectByPrimaryKey(Integer voucherId);

    int updateByPrimaryKeySelective(Voucher record);

    int updateByPrimaryKey(Voucher record);
}