package hitwh.fanghh.pojo;

import java.util.Date;

public class Predestinationinfo {
    private Integer piId;

    private Integer customerId;

    private String childOrderId;

    private String predestinationType;

    private Date predestinationTime;

    private Long predestinationValue;

    private String predestinationStatus;

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getChildOrderId() {
        return childOrderId;
    }

    public void setChildOrderId(String childOrderId) {
        this.childOrderId = childOrderId == null ? null : childOrderId.trim();
    }

    public String getPredestinationType() {
        return predestinationType;
    }

    public void setPredestinationType(String predestinationType) {
        this.predestinationType = predestinationType == null ? null : predestinationType.trim();
    }

    public Date getPredestinationTime() {
        return predestinationTime;
    }

    public void setPredestinationTime(Date predestinationTime) {
        this.predestinationTime = predestinationTime;
    }

    public Long getPredestinationValue() {
        return predestinationValue;
    }

    public void setPredestinationValue(Long predestinationValue) {
        this.predestinationValue = predestinationValue;
    }

    public String getPredestinationStatus() {
        return predestinationStatus;
    }

    public void setPredestinationStatus(String predestinationStatus) {
        this.predestinationStatus = predestinationStatus == null ? null : predestinationStatus.trim();
    }
}