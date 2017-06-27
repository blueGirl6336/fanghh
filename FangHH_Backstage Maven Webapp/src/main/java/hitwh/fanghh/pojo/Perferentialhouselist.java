package hitwh.fanghh.pojo;

public class Perferentialhouselist {
    private Integer phlId;

    private Integer houseId;

    private Integer activityId;

    private String childOrderId;

    private Boolean isPurchased;

    private String childOrderStatus;

    public Integer getPhlId() {
        return phlId;
    }

    public void setPhlId(Integer phlId) {
        this.phlId = phlId;
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
        this.activityId = activityId ;
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