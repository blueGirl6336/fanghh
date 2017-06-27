package hitwh.fanghh.pojo;

public class Store {
    private Integer storeId;

    private String storeName;

    private Integer storeLeader;

    private Integer customerNum;

    private Integer dealNum;

    private Long saleProfit;

    private Long totalCommission;

    private Integer buildingNum;

    private String invitationCode;

    private Long storeNum;

    private String status;

    private String failedReason;

    private String storePortrait;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Integer getStoreLeader() {
        return storeLeader;
    }

    public void setStoreLeader(Integer storeLeader) {
        this.storeLeader = storeLeader;
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

    public Long getSaleProfit() {
        return saleProfit;
    }

    public void setSaleProfit(Long saleProfit) {
        this.saleProfit = saleProfit;
    }

    public Long getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Long totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Integer getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(Integer buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public Long getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(Long storeNum) {
        this.storeNum = storeNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason == null ? null : failedReason.trim();
    }

    public String getStorePortrait() {
        return storePortrait;
    }

    public void setStorePortrait(String storePortrait) {
        this.storePortrait = storePortrait == null ? null : storePortrait.trim();
    }
}