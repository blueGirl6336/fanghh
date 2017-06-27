package hitwh.fanghh.pojo;

import java.math.BigDecimal;

public class House {
    private Integer houseId;

    private Integer unitId;

    private Integer styleId;

    private Integer buildingId;

    private String houseType;

    private String maxFloor;

    private String floor;

    private String houseNum;

    private String houseStatus;

    private String face;

    private String decoration;

    private String remark;

    private BigDecimal highestCommission;

    private BigDecimal area;

    private BigDecimal orginalPricePerSquare;

    private BigDecimal currentPricePerSquare;

    private BigDecimal orginalPrice;

    private BigDecimal currentPrice;

    private Boolean haveBasement;

    private BigDecimal basementSquare;

    private BigDecimal basementPrice;

    private BigDecimal parkingPlaceArea;

    private Boolean hasParkingPlace;

    private String otherFacility;

    private String attachedHouseDescription;

    private String masterBedroomFace;

    private String recommendReason;

    private BigDecimal monthlyPayment;

    private BigDecimal downPayment;

    private String auditStatus;

    private String houseLabel;

    private Boolean hasParkingLot;

    private Long parkingLotPrice;

    private String housePic;
    private String houseApplicationStatus;

	private String auditNotPassReason;
	private Integer buildingNo;
	
	
	public Integer getBuildingNo()
	{
		return buildingNo;
	}

	public void setBuildingNo(Integer buildingNo)
	{
		this.buildingNo = buildingNo;
	}
	
    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

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

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public String getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(String maxFloor) {
        this.maxFloor = maxFloor == null ? null : maxFloor.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum == null ? null : houseNum.trim();
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus == null ? null : houseStatus.trim();
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face == null ? null : face.trim();
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration == null ? null : decoration.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getHighestCommission() {
        return highestCommission;
    }

    public void setHighestCommission(BigDecimal highestCommission) {
        this.highestCommission = highestCommission;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getOrginalPricePerSquare() {
        return orginalPricePerSquare;
    }

    public void setOrginalPricePerSquare(BigDecimal orginalPricePerSquare) {
        this.orginalPricePerSquare = orginalPricePerSquare;
    }

    public BigDecimal getCurrentPricePerSquare() {
        return currentPricePerSquare;
    }

    public void setCurrentPricePerSquare(BigDecimal currentPricePerSquare) {
        this.currentPricePerSquare = currentPricePerSquare;
    }

    public BigDecimal getOrginalPrice() {
        return orginalPrice;
    }

    public void setOrginalPrice(BigDecimal orginalPrice) {
        this.orginalPrice = orginalPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Boolean getHaveBasement() {
        return haveBasement;
    }

    public void setHaveBasement(Boolean haveBasement) {
        this.haveBasement = haveBasement;
    }

    public BigDecimal getBasementSquare() {
        return basementSquare;
    }

    public void setBasementSquare(BigDecimal basementSquare) {
        this.basementSquare = basementSquare;
    }

    public BigDecimal getBasementPrice() {
        return basementPrice;
    }

    public void setBasementPrice(BigDecimal basementPrice) {
        this.basementPrice = basementPrice;
    }

    public BigDecimal getParkingPlaceArea() {
        return parkingPlaceArea;
    }

    public void setParkingPlaceArea(BigDecimal parkingPlaceArea) {
        this.parkingPlaceArea = parkingPlaceArea;
    }

    public Boolean getHasParkingPlace() {
        return hasParkingPlace;
    }

    public void setHasParkingPlace(Boolean hasParkingPlace) {
        this.hasParkingPlace = hasParkingPlace;
    }

    public String getOtherFacility() {
        return otherFacility;
    }

    public void setOtherFacility(String otherFacility) {
        this.otherFacility = otherFacility == null ? null : otherFacility.trim();
    }

    public String getAttachedHouseDescription() {
        return attachedHouseDescription;
    }

    public void setAttachedHouseDescription(String attachedHouseDescription) {
        this.attachedHouseDescription = attachedHouseDescription == null ? null : attachedHouseDescription.trim();
    }

    public String getMasterBedroomFace() {
        return masterBedroomFace;
    }

    public void setMasterBedroomFace(String masterBedroomFace) {
        this.masterBedroomFace = masterBedroomFace == null ? null : masterBedroomFace.trim();
    }

    public String getRecommendReason() {
        return recommendReason;
    }

    public void setRecommendReason(String recommendReason) {
        this.recommendReason = recommendReason == null ? null : recommendReason.trim();
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getHouseLabel() {
        return houseLabel;
    }

    public void setHouseLabel(String houseLabel) {
        this.houseLabel = houseLabel == null ? null : houseLabel.trim();
    }

    public Boolean getHasParkingLot() {
        return hasParkingLot;
    }

    public void setHasParkingLot(Boolean hasParkingLot) {
        this.hasParkingLot = hasParkingLot;
    }

    public Long getParkingLotPrice() {
        return parkingLotPrice;
    }

    public void setParkingLotPrice(Long parkingLotPrice) {
        this.parkingLotPrice = parkingLotPrice;
    }

    public String getHousePic() {
        return housePic;
    }

    public void setHousePic(String housePic) {
        this.housePic = housePic == null ? null : housePic.trim();
    }
    
    public String getHouseApplicationStatus() {
        return houseApplicationStatus;
    }

    public void setHouseApplicationStatus(String houseApplicationStatus) {
        this.houseApplicationStatus = houseApplicationStatus == null ? null : houseApplicationStatus.trim();
    }
    
    public String getAuditNotPassReason()
	{
		return auditNotPassReason;
	}

	public void setAuditNotPassReason(String auditNotPassReason)
	{
		this.auditNotPassReason = auditNotPassReason;
	}
}