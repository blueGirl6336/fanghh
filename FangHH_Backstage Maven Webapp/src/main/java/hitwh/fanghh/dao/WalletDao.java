
package hitwh.fanghh.dao;

import hitwh.fanghh.pojo.Wallet;

public interface WalletDao {
    int deleteByPrimaryKey(Integer walletId);

    int insert(Wallet record);

    int insertSelective(Wallet record);

    Wallet selectByPrimaryKey(Integer walletId);

    int updateByPrimaryKeySelective(Wallet record);

    int updateByPrimaryKey(Wallet record);
}