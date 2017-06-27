package hitwh.fanghh.pojo;

import java.math.BigDecimal;

public class Wallet {
    private Integer walletId;

    private Integer brokerId;

    private BigDecimal balance;

    private BigDecimal totalIncome;

    private BigDecimal totalPay;

    private BigDecimal commissionReceived;

    private BigDecimal commissionNotRecevied;

    private BigDecimal freezeMoney;

    private String password;

    private Integer userId;

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    public BigDecimal getCommissionReceived() {
        return commissionReceived;
    }

    public void setCommissionReceived(BigDecimal commissionReceived) {
        this.commissionReceived = commissionReceived;
    }

    public BigDecimal getCommissionNotRecevied() {
        return commissionNotRecevied;
    }

    public void setCommissionNotRecevied(BigDecimal commissionNotRecevied) {
        this.commissionNotRecevied = commissionNotRecevied;
    }

    public BigDecimal getFreezeMoney() {
        return freezeMoney;
    }

    public void setFreezeMoney(BigDecimal freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}