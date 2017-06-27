package hitwh.fanghh.pojo;

import java.util.Date;

public class Clearancehouseinfo {
    private Integer chiId;

    private Integer activityId;

    private String activityPic;

    private Integer houseId;

    private Date startTime;

    private Date endTime;

    private String remark;

    private Integer buildingId;

    private Integer ruleId;

    private String purchaseNote;

    public Integer getChiId() {
        return chiId;
    }

    public void setChiId(Integer chiId) {
        this.chiId = chiId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId ;
    }

    public String getActivityPic() {
        return activityPic;
    }

    public void setActivityPic(String activityPic) {
        this.activityPic = activityPic == null ? null : activityPic.trim();
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getPurchaseNote() {
        return purchaseNote;
    }

    public void setPurchaseNote(String purchaseNote) {
        this.purchaseNote = purchaseNote == null ? null : purchaseNote.trim();
    }
}