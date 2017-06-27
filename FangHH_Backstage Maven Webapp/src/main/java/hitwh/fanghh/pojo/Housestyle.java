package hitwh.fanghh.pojo;

import java.math.BigDecimal;

public class Housestyle {
    private Integer styleId;

    private Integer buildingId;

    private String houseStyle;

    private String styleDescription;

    private String stylePic;

    private String recommendReason;

    private Integer room;

    private Integer hall;

    private Integer restroom;

    private BigDecimal referencePrice;

    private BigDecimal referenceMonthlyPayments;

    private BigDecimal downPayment;

    private Boolean isCooperated;

    private String auditStatus;

    private String specialitiesPic;

    private BigDecimal styleArea;

    private String applicationStatus;

    private String auditNotPassReason;

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getHouseStyle() {
        return houseStyle;
    }

    public void setHouseStyle(String houseStyle) {
        this.houseStyle = houseStyle == null ? null : houseStyle.trim();
    }

    public String getStyleDescription() {
        return styleDescription;
    }

    public void setStyleDescription(String styleDescription) {
        this.styleDescription = styleDescription == null ? null : styleDescription.trim();
    }

    public String getStylePic() {
        return stylePic;
    }

    public void setStylePic(String stylePic) {
        this.stylePic = stylePic == null ? null : stylePic.trim();
    }

    public String getRecommendReason() {
        return recommendReason;
    }

    public void setRecommendReason(String recommendReason) {
        this.recommendReason = recommendReason == null ? null : recommendReason.trim();
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Integer getRestroom() {
        return restroom;
    }

    public void setRestroom(Integer restroom) {
        this.restroom = restroom;
    }

    public BigDecimal getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(BigDecimal referencePrice) {
        this.referencePrice = referencePrice;
    }

    public BigDecimal getReferenceMonthlyPayments() {
        return referenceMonthlyPayments;
    }

    public void setReferenceMonthlyPayments(BigDecimal referenceMonthlyPayments) {
        this.referenceMonthlyPayments = referenceMonthlyPayments;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public Boolean getIsCooperated() {
        return isCooperated;
    }

    public void setIsCooperated(Boolean isCooperated) {
        this.isCooperated = isCooperated;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getSpecialitiesPic() {
        return specialitiesPic;
    }

    public void setSpecialitiesPic(String specialitiesPic) {
        this.specialitiesPic = specialitiesPic == null ? null : specialitiesPic.trim();
    }

    public BigDecimal getStyleArea() {
        return styleArea;
    }

    public void setStyleArea(BigDecimal styleArea) {
        this.styleArea = styleArea;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus == null ? null : applicationStatus.trim();
    }

    public String getAuditNotPassReason() {
        return auditNotPassReason;
    }

    public void setAuditNotPassReason(String auditNotPassReason) {
        this.auditNotPassReason = auditNotPassReason == null ? null : auditNotPassReason.trim();
    }
}