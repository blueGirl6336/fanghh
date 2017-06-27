package hitwh.fanghh.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Traderecord {
    private Integer tradeId;

    private Integer brokerId;

    private Date tradeTime;

    private String tradeCatg;

    private String tradeType;

    private String tradeObj;

    private BigDecimal tradeMoney;

    private Integer userId;

    private String orderId;

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTradeCatg() {
        return tradeCatg;
    }

    public void setTradeCatg(String tradeCatg) {
        this.tradeCatg = tradeCatg == null ? null : tradeCatg.trim();
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    public String getTradeObj() {
        return tradeObj;
    }

    public void setTradeObj(String tradeObj) {
        this.tradeObj = tradeObj == null ? null : tradeObj.trim();
    }

    public BigDecimal getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(BigDecimal tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
}