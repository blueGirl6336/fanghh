package hitwh.fanghh.pojo;

import java.util.Date;

public class Orderstatusrecord {
    private Integer osrId;

    private String orderId;

    private Integer customerId;

    private Integer buildingId;

    private String orderStatus;

    private Date typeTime;

    private String remark;

    public Integer getOsrId() {
        return osrId;
    }

    public void setOsrId(Integer osrId) {
        this.osrId = osrId;
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

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getTypeTime() {
        return typeTime;
    }

    public void setTypeTime(Date typeTime) {
        this.typeTime = typeTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}