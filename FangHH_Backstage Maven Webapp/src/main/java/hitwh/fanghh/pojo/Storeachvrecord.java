package hitwh.fanghh.pojo;

import java.util.Date;

public class Storeachvrecord {
    private Integer barId;

    private Integer storeId;

    private Integer buildingId;

    private Integer customerNum;

    private Integer dealNum;

    private Long commission;

    private Date typeTime;

    private Long saleProfit;

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(Integer customerNum) {
        this.customerNum = customerNum;
    }

    public Integer getDealNum() {
        return dealNum;
    }

    public void setDealNum(Integer dealNum) {
        this.dealNum = dealNum;
    }

    public Long getCommission() {
        return commission;
    }

    public void setCommission(Long commission) {
        this.commission = commission;
    }

    public Date getTypeTime() {
        return typeTime;
    }

    public void setTypeTime(Date typeTime) {
        this.typeTime = typeTime;
    }

    public Long getSaleProfit() {
        return saleProfit;
    }

    public void setSaleProfit(Long saleProfit) {
        this.saleProfit = saleProfit;
    }
}