package hitwh.fanghh.pojo;

public class Grouppurchasehouselist {
    private Integer gphId;

    private Integer houseId;

    private String childOrderId;

    private Boolean isPurchased;

    private String childOrderStatus;

    private String activityId;

    public Integer getGphId() {
        return gphId;
    }

    public void setGphId(Integer gphId) {
        this.gphId = gphId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
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

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }
}