package hitwh.fanghh.pojo;

import java.util.Date;

public class Signationstatusrecord {
    private Integer ssrId;

    private Integer soId;

    private String signationStatus;

    private Long signationValue;

    private Date signationTime;

    private String typerId;

    private String orderId;

    public Integer getSsrId() {
        return ssrId;
    }

    public void setSsrId(Integer ssrId) {
        this.ssrId = ssrId;
    }

    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    public String getSignationStatus() {
        return signationStatus;
    }

    public void setSignationStatus(String signationStatus) {
        this.signationStatus = signationStatus == null ? null : signationStatus.trim();
    }

    public Long getSignationValue() {
        return signationValue;
    }

    public void setSignationValue(Long signationValue) {
        this.signationValue = signationValue;
    }

    public Date getSignationTime() {
        return signationTime;
    }

    public void setSignationTime(Date signationTime) {
        this.signationTime = signationTime;
    }

    public String getTyperId() {
        return typerId;
    }

    public void setTyperId(String typerId) {
        this.typerId = typerId == null ? null : typerId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
}