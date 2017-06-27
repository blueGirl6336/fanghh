package hitwh.fanghh.pojo;

import java.util.Date;

public class Housevisitrecord {
    private Integer hvrId;

    private String orderId;

    private Integer customerId;

    private Date admitTime;

    private String houseVisited;

    private String visitStatus;

    private String remark;

    public Integer getHvrId() {
        return hvrId;
    }

    public void setHvrId(Integer hvrId) {
        this.hvrId = hvrId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getAdmitTime() {
        return admitTime;
    }

    public void setAdmitTime(Date admitTime) {
        this.admitTime = admitTime;
    }

    public String getHouseVisited() {
        return houseVisited;
    }

    public void setHouseVisited(String houseVisited) {
        this.houseVisited = houseVisited == null ? null : houseVisited.trim();
    }

    public String getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(String visitStatus) {
        this.visitStatus = visitStatus == null ? null : visitStatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}