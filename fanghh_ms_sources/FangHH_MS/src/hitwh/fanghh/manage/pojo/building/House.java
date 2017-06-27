// default package
package hitwh.fanghh.manage.pojo.building;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * House entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "House", schema = "dbo")
public class House implements java.io.Serializable {

	// Fields
	//房屋ID
	private Integer houseId;
	//房屋样式
	private HouseStyle houseStyle;
	//房屋样式字典码
	private String houseStyleCode;
	//所属楼盘
	private Building building;
	//单元
	private Unit unit;
	// 房屋类型
	private String houseType;
	// 楼层
	private String floor;
	// 房屋号
	private String houseNum;
	// 房屋状态
	private String houseStatus;
	// 朝向
	private String face;
	//装修情况
	private String decoration;
	// 备注
	private String remark;
	// 最高佣金
	private long highestCommission;
	// 区域
	private Integer area;
	//原来每平米价格
	private long orginalPricePerSquare;
	// 现每平米价格
	private long currentPricePerSquare;
	// 原价
	private long orginalPrice;
	// 现价
	private long currentPrice;
	// 是否有附房
	private boolean haveBasement;
	// 附房面积
	private Integer basementSquare;
	// 附房价格
	private long basementPrice;
	// 停车位
	private boolean hasParkingPlace;
	// 其他设施
	private String otherFacility;
	// 附房描述
	private String attachedHouseDescription;
	// 主卧朝向
	private String masterBedroomFace;
	//停车场大小
	private Integer parkingPlaceArea;
	/*private Set<RecommendOrder> recommendOrders = new HashSet<RecommendOrder>(0);
	private Set<ClearanceHouseInfo> clearanceHouseInfos = new HashSet<ClearanceHouseInfo>(
			0);
	private Set<GroupPurchaseHouseList> groupPurchaseHouseLists = new HashSet<GroupPurchaseHouseList>(
			0);
	private Set<ReservationOrder> reservationOrders = new HashSet<ReservationOrder>(
			0);
	private Set<PerferentialHouseList> perferentialHouseLists = new HashSet<PerferentialHouseList>(
			0);
	private Set<SaleOrder> saleOrders = new HashSet<SaleOrder>(0);
	private Set<ClearanceHouseList> clearanceHouseLists = new HashSet<ClearanceHouseList>(
			0);
	private Set<BookingOrder> bookingOrders = new HashSet<BookingOrder>(0);
*/
	// Constructors

	/** default constructor */
	public House() {
	}

	/** full constructor */
	public House(HouseStyle houseStyle, Building building, Unit unit,
			String houseType, String floor, String houseNum,
			String houseStatus, String face, String decoration, String remark,
			long highestCommission, Integer area, long orginalPricePerSquare,
			long currentPricePerSquare, long orginalPrice, long currentPrice,
			boolean haveBasement, Integer basementSquare, long basementPrice,
			boolean hasParkingPlace, String otherFacility,
			String attachedHouseDescription,String masterBedroomFace) {
		this.houseStyle = houseStyle;
		this.building = building;
		this.unit = unit;
		this.houseType = houseType;
		this.floor = floor;
		this.houseNum = houseNum;
		this.houseStatus = houseStatus;
		this.face = face;
		this.decoration = decoration;
		this.remark = remark;
		this.highestCommission = highestCommission;
		this.area = area;
		this.orginalPricePerSquare = orginalPricePerSquare;
		this.currentPricePerSquare = currentPricePerSquare;
		this.orginalPrice = orginalPrice;
		this.currentPrice = currentPrice;
		this.haveBasement = haveBasement;
		this.basementSquare = basementSquare;
		this.basementPrice = basementPrice;
		this.hasParkingPlace = hasParkingPlace;
		this.otherFacility = otherFacility;
		this.attachedHouseDescription = attachedHouseDescription;
		this.masterBedroomFace = masterBedroomFace;
		/*this.recommendOrders = recommendOrders;
		this.clearanceHouseInfos = clearanceHouseInfos;
		this.groupPurchaseHouseLists = groupPurchaseHouseLists;
		this.reservationOrders = reservationOrders;
		this.perferentialHouseLists = perferentialHouseLists;
		this.saleOrders = saleOrders;
		this.clearanceHouseLists = clearanceHouseLists;
		this.bookingOrders = bookingOrders;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "house_id", unique = true, nullable = false)
	public Integer getHouseId() {
		return this.houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "style_id")
	public HouseStyle getHouseStyle() {
		return this.houseStyle;
	}

	public void setHouseStyle(HouseStyle houseStyle) {
		this.houseStyle = houseStyle;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "unit_id")
	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Column(name = "house_type")
	public String getHouseType() {
		return this.houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	@Column(name = "floor")
	public String getFloor() {
		return this.floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Column(name = "house_num")
	public String getHouseNum() {
		return this.houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	@Column(name = "house_status")
	public String getHouseStatus() {
		return this.houseStatus;
	}

	public void setHouseStatus(String houseStatus) {
		this.houseStatus = houseStatus;
	}

	@Column(name = "face")
	public String getFace() {
		return this.face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	@Column(name = "decoration")
	public String getDecoration() {
		return this.decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "highest_commission", precision = 18, scale = 0)
	public long getHighestCommission() {
		return this.highestCommission;
	}

	public void setHighestCommission(long highestCommission) {
		this.highestCommission = highestCommission;
	}

	@Column(name = "area")
	public Integer getArea() {
		return this.area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	@Column(name = "orginal_price_per_square", precision = 18, scale = 0)
	public long getOrginalPricePerSquare() {
		return this.orginalPricePerSquare;
	}

	public void setOrginalPricePerSquare(long orginalPricePerSquare) {
		this.orginalPricePerSquare = orginalPricePerSquare;
	}

	@Column(name = "current_price_per_square", precision = 18, scale = 0)
	public long getCurrentPricePerSquare() {
		return this.currentPricePerSquare;
	}

	public void setCurrentPricePerSquare(long currentPricePerSquare) {
		this.currentPricePerSquare = currentPricePerSquare;
	}

	@Column(name = "orginal_price", precision = 18, scale = 0)
	public long getOrginalPrice() {
		return this.orginalPrice;
	}

	public void setOrginalPrice(long orginalPrice) {
		this.orginalPrice = orginalPrice;
	}

	@Column(name = "current_price", precision = 18, scale = 0)
	public long getCurrentPrice() {
		return this.currentPrice;
	}

	public void setCurrentPrice(long currentPrice) {
		this.currentPrice = currentPrice;
	}

	@Column(name = "have_basement")
	public boolean getHaveBasement() {
		return this.haveBasement;
	}

	public void setHaveBasement(boolean haveBasement) {
		this.haveBasement = haveBasement;
	}

	@Column(name = "basement_square")
	public Integer getBasementSquare() {
		return this.basementSquare;
	}

	public void setBasementSquare(Integer basementSquare) {
		this.basementSquare = basementSquare;
	}

	@Column(name = "basement_price", precision = 18, scale = 0)
	public long getBasementPrice() {
		return this.basementPrice;
	}

	public void setBasementPrice(long basementPrice) {
		this.basementPrice = basementPrice;
	}

	@Column(name = "has_parking_place")
	public boolean getHasParkingPlace() {
		return this.hasParkingPlace;
	}

	public void setHasParkingPlace(boolean hasParkingPlace) {
		this.hasParkingPlace = hasParkingPlace;
	}

	@Column(name = "other_facility")
	public String getOtherFacility() {
		return this.otherFacility;
	}

	public void setOtherFacility(String otherFacility) {
		this.otherFacility = otherFacility;
	}

	@Column(name = "attached_house_description")
	public String getAttachedHouseDescription() {
		return this.attachedHouseDescription;
	}

	public void setAttachedHouseDescription(String attachedHouseDescription) {
		this.attachedHouseDescription = attachedHouseDescription;
	}

	@Column(name = "master_bedroom_face")
	public String getMasterBedroomFace() {
		return masterBedroomFace;
	}

	public void setMasterBedroomFace(String masterBedroomFace) {
		this.masterBedroomFace = masterBedroomFace;
	}

	@Column(name = "parking_place_area")
	public Integer getParkingPlaceArea() {
		return parkingPlaceArea;
	}

	public void setParkingPlaceArea(Integer parkingPlaceArea) {
		this.parkingPlaceArea = parkingPlaceArea;
	}

	@Transient
	public String getHouseStyleCode() {
		return this.houseStyleCode;
	}

	public void setHouseStyleCode(String houseStyleCode) {
		this.houseStyleCode = houseStyleCode;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "house")
	public Set<RecommendOrder> getRecommendOrders() {
		return this.recommendOrders;
	}

	public void setRecommendOrders(Set<RecommendOrder> recommendOrders) {
		this.recommendOrders = recommendOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "house")
	public Set<ClearanceHouseInfo> getClearanceHouseInfos() {
		return this.clearanceHouseInfos;
	}

	public void setClearanceHouseInfos(
			Set<ClearanceHouseInfo> clearanceHouseInfos) {
		this.clearanceHouseInfos = clearanceHouseInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "house")
	public Set<GroupPurchaseHouseList> getGroupPurchaseHouseLists() {
		return this.groupPurchaseHouseLists;
	}

	public void setGroupPurchaseHouseLists(
			Set<GroupPurchaseHouseList> groupPurchaseHouseLists) {
		this.groupPurchaseHouseLists = groupPurchaseHouseLists;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "house")
	public Set<ReservationOrder> getReservationOrders() {
		return this.reservationOrders;
	}

	public void setReservationOrders(Set<ReservationOrder> reservationOrders) {
		this.reservationOrders = reservationOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "house")
	public Set<PerferentialHouseList> getPerferentialHouseLists() {
		return this.perferentialHouseLists;
	}

	public void setPerferentialHouseLists(
			Set<PerferentialHouseList> perferentialHouseLists) {
		this.perferentialHouseLists = perferentialHouseLists;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "house")
	public Set<SaleOrder> getSaleOrders() {
		return this.saleOrders;
	}

	public void setSaleOrders(Set<SaleOrder> saleOrders) {
		this.saleOrders = saleOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "house")
	public Set<ClearanceHouseList> getClearanceHouseLists() {
		return this.clearanceHouseLists;
	}

	public void setClearanceHouseLists(
			Set<ClearanceHouseList> clearanceHouseLists) {
		this.clearanceHouseLists = clearanceHouseLists;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "house")
	public Set<BookingOrder> getBookingOrders() {
		return this.bookingOrders;
	}

	public void setBookingOrders(Set<BookingOrder> bookingOrders) {
		this.bookingOrders = bookingOrders;
	}*/

}