package hitwh.fanghh.pojo;

public class Clearancehouselist {
    private Integer chlId;

    private Integer houseId;

    private Integer activityId;

    private String childOrderId;

    private Boolean isPurchased;

    private String childOrderStatus;

    public Integer getChlId() {
        return chlId;
    }

    public void setChlId(Integer chlId) {
        this.chlId = chlId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(String childOrderId) {
        this.childOrderId = childOrderId == null ? null : childOrderId.trim();
    }

    public Boolean getIsPurchased() {
        return isPurchased;
    }

    public void setIsPurchased(Boolean isPurchased) {
        this.isPurchased = isPurchased;
    }

    public String getChildOrderStatus() {
        return childOrderStatus;
    }

    public void setChildOrderStatus(String childOrderStatus) {
        this.childOrderStatus = childOrderStatus == null ? null : childOrderStatus.trim();
    }
}