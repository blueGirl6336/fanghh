package hitwh.fanghh.pojo;

import java.math.BigDecimal;

public class Activity {
    private Integer activityId;

    private String activityName;

    private String picture;

    private String url;

    private Integer buildingId;

    private BigDecimal totalCash;

    private Integer totalTimes;

    private Integer limitTimes;

    private String startDate;

    private String endDate;

    private Integer currentTimes;

    private BigDecimal leftCash;

    private String state;
    
    private String modifiedTime;
    
    private String activityType;

    private String activityApplicationStatus;
    
    private String auditNotPassReason;
    
    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    
    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }
    
    public String getActivityApplicationStatus() {
        return activityApplicationStatus;
    }

    public void setActivityApplicationStatus(String activityApplicationStatus) {
        this.activityApplicationStatus = activityApplicationStatus == null ? null : activityApplicationStatus.trim();
    }
    
    public String getAuditNotPassReason() {
        return auditNotPassReason;
    }

    public void setAuditNotPassReason(String auditNotPassReason) {
        this.auditNotPassReason = auditNotPassReason == null ? null : auditNotPassReason.trim();
    }
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }
    
    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime == null ? null : modifiedTime.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public BigDecimal getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(BigDecimal totalCash) {
        this.totalCash = totalCash;
    }

    public Integer getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(Integer totalTimes) {
        this.totalTimes = totalTimes;
    }

    public Integer getLimitTimes() {
        return limitTimes;
    }

    public void setLimitTimes(Integer limitTimes) {
        this.limitTimes = limitTimes;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public Integer getCurrentTimes() {
        return currentTimes;
    }

    public void setCurrentTimes(Integer currentTimes) {
        this.currentTimes = currentTimes;
    }

    public BigDecimal getLeftCash() {
        return leftCash;
    }

    public void setLeftCash(BigDecimal leftCash) {
        this.leftCash = leftCash;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}