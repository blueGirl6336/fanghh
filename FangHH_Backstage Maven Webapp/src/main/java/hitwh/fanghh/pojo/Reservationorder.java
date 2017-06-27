package hitwh.fanghh.pojo;

import java.util.Date;

public class Reservationorder {
    private Integer roId;

    private String orderId;

    private Integer customerId;

    private Integer houseId;

    private Date reservationTime;

    private Integer reservationNum;

    private Date typeTime;

    private String reservationStatus;

    private Boolean isMatched;

    private Boolean isChecked;

    private Boolean isDistributed;

    private String reservationSource;

    private String remark;

    private Integer buildingId;

    private Boolean needPickUp;

    private String pickUpAddr;

    public Integer getRoId() {
        return roId;
    }

    public void setRoId(Integer roId) {
        this.roId = roId;
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

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Integer getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(Integer reservationNum) {
        this.reservationNum = reservationNum;
    }

    public Date getTypeTime() {
        return typeTime;
    }

    public void setTypeTime(Date typeTime) {
        this.typeTime = typeTime;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus == null ? null : reservationStatus.trim();
    }

    public Boolean getIsMatched() {
        return isMatched;
    }

    public void setIsMatched(Boolean isMatched) {
        this.isMatched = isMatched;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Boolean getIsDistributed() {
        return isDistributed;
    }

    public void setIsDistributed(Boolean isDistributed) {
        this.isDistributed = isDistributed;
    }

    public String getReservationSource() {
        return reservationSource;
    }

    public void setReservationSource(String reservationSource) {
        this.reservationSource = reservationSource == null ? null : reservationSource.trim();
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

    public Boolean getNeedPickUp() {
        return needPickUp;
    }

    public void setNeedPickUp(Boolean needPickUp) {
        this.needPickUp = needPickUp;
    }

    public String getPickUpAddr() {
        return pickUpAddr;
    }

    public void setPickUpAddr(String pickUpAddr) {
        this.pickUpAddr = pickUpAddr == null ? null : pickUpAddr.trim();
    }
}