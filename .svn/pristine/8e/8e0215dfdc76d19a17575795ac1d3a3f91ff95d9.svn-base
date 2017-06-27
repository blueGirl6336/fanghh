// default package
package hitwh.fanghh.manage.pojo.building;

import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Building entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Building", schema = "dbo")
public class Building implements java.io.Serializable {

	// Fields

	private Integer buildingId;
	private Region region;
	private SalesDirector salesDirector;
	private String buildingName;
	private String buildingPortrait;
	private Date openingTime;
	private long averagePrice;
	private Date launchTime;
	private String buildingAddr;
	private String buildingLocation;
	private String buildingPic;
	private String videoLink;
	private String saleSiteLocation;
	private long highestCommission;
	private long cautionMoney;
	private Integer duration;
	private String purchaseNote;
	private double planArea;
	private double constructionArea;
	private String constructionKind;
	private String constructionUse;
	private double plotRate;
	private double greeningRate;
	private Integer householdNum;
	private Integer parkingspaceNum;
	private Date createTime;
	private boolean isCopartner;
	private boolean isActivited;
	private Date estimatedOpeningDate;
	private CommissionRule rule;
	private Developer developer;
	private Property property;
	private String saleSitePhone;
	private Integer sellingHotSort;
	private Integer buildingType;
	private Integer sellingHotlabel;
	private String buildingLabel;
	private Boolean paidCautionMoney;
	private String remark;

	/*
	 * private Set<BuildingPropertyType> buildingPropertyTypes = new
	 * HashSet<BuildingPropertyType>( 0); private Set<BuildingDynamicInfo>
	 * buildingDynamicInfos = new HashSet<BuildingDynamicInfo>( 0); private
	 * Set<Property> properties = new HashSet<Property>(0); private
	 * Set<HousePriceTrend> housePriceTrends = new HashSet<HousePriceTrend>( 0);
	 * private Set<HousingStrategy> housingStrategies = new
	 * HashSet<HousingStrategy>( 0); private Set<PerferentialHouseInfo>
	 * perferentialHouseInfos = new HashSet<PerferentialHouseInfo>( 0); private
	 * Set<SurroundFacility> surroundFacilities = new HashSet<SurroundFacility>(
	 * 0); private Set<BuildingSellingPoint> buildingSellingPoints = new
	 * HashSet<BuildingSellingPoint>( 0); private Set<PicTalk> picTalks = new
	 * HashSet<PicTalk>(0); private Set<House> houses = new HashSet<House>(0);
	 * private Set<ConsultantBuildingRel> consultantBuildingRels = new
	 * HashSet<ConsultantBuildingRel>( 0); private Set<CustomerRemark>
	 * customerRemarks = new HashSet<CustomerRemark>(0); private Set<ShareInfo>
	 * shareInfos = new HashSet<ShareInfo>(0); private Set<GroupPurchaseInfo>
	 * groupPurchaseInfos = new HashSet<GroupPurchaseInfo>( 0); private
	 * Set<RoofBeam> roofBeams = new HashSet<RoofBeam>(0); private
	 * Set<SaleDirectorBuildingRel> saleDirectorBuildingRels = new
	 * HashSet<SaleDirectorBuildingRel>( 0); private Set<HomeConsultant>
	 * homeConsultants = new HashSet<HomeConsultant>(0); private
	 * Set<AdvertisementSpace> advertisementSpaces = new
	 * HashSet<AdvertisementSpace>( 0); private Set<OrderStatusRecord>
	 * orderStatusRecords = new HashSet<OrderStatusRecord>( 0); private
	 * Set<BuildingPic> buildingPics = new HashSet<BuildingPic>(0); private
	 * Set<BuildingComment> buildingComments = new HashSet<BuildingComment>( 0);
	 * private Set<HouseStyle> houseStyles = new HashSet<HouseStyle>(0); private
	 * Set<StoreAchvRecord> storeAchvRecords = new HashSet<StoreAchvRecord>( 0);
	 * private Set<BrokerAchvRecord> brokerAchvRecords = new
	 * HashSet<BrokerAchvRecord>( 0); private Set<CommissionRule>
	 * commissionRules = new HashSet<CommissionRule>(0); private Set<Developer>
	 * developers = new HashSet<Developer>(0);
	 */
	// Constructors

	/** default constructor */
	public Building() {
	}

	public Building(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Building(Integer buildingId, Region region,
			SalesDirector salesDirector, String buildingName,
			String buildingPortrait, Date openingTime, long averagePrice,
			Date launchTime, String buildingAddr, String buildingLocation,
			String buildingPic, String videoLink, String saleSiteLocation,
			long highestCommission, long cautionMoney, Integer duration,
			String purchaseNote, double planArea, double constructionArea,
			String constructionKind, String constructionUse, double plotRate,
			double greeningRate, Integer householdNum, Integer parkingspaceNum,
			Date createTime, boolean isCopartner, boolean isActivited,
			Date estimatedOpeningDate, CommissionRule rule,
			Developer developer, Property property, String saleSitePhone) {
		this.buildingId = buildingId;
		this.region = region;
		this.salesDirector = salesDirector;
		this.buildingName = buildingName;
		this.buildingPortrait = buildingPortrait;
		this.openingTime = openingTime;
		this.averagePrice = averagePrice;
		this.launchTime = launchTime;
		this.buildingAddr = buildingAddr;
		this.buildingLocation = buildingLocation;
		this.buildingPic = buildingPic;
		this.videoLink = videoLink;
		this.saleSiteLocation = saleSiteLocation;
		this.highestCommission = highestCommission;
		this.cautionMoney = cautionMoney;
		this.duration = duration;
		this.purchaseNote = purchaseNote;
		this.planArea = planArea;
		this.constructionArea = constructionArea;
		this.constructionKind = constructionKind;
		this.constructionUse = constructionUse;
		this.plotRate = plotRate;
		this.greeningRate = greeningRate;
		this.householdNum = householdNum;
		this.parkingspaceNum = parkingspaceNum;
		this.createTime = createTime;
		this.isCopartner = isCopartner;
		this.isActivited = isActivited;
		this.estimatedOpeningDate = estimatedOpeningDate;
		this.rule = rule;
		this.developer = developer;
		this.property = property;
		this.saleSitePhone = saleSitePhone;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "building_id", unique = true, nullable = false)
	public Integer getBuildingId() {
		return this.buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "region_id")
	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "director_id")
	public SalesDirector getSalesDirector() {
		return this.salesDirector;
	}

	public void setSalesDirector(SalesDirector salesDirector) {
		this.salesDirector = salesDirector;
	}

	@Column(name = "building_name")
	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Column(name = "building_portrait")
	public String getBuildingPortrait() {
		return this.buildingPortrait;
	}

	public void setBuildingPortrait(String buildingPortrait) {
		this.buildingPortrait = buildingPortrait;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "opening_time", length = 23)
	public Date getOpeningTime() {
		return this.openingTime;
	}

	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}

	@Column(name = "average_price", precision = 18, scale = 0)
	public long getAveragePrice() {
		return this.averagePrice;
	}

	public void setAveragePrice(long averagePrice) {
		this.averagePrice = averagePrice;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "launch_time", length = 23)
	public Date getLaunchTime() {
		return this.launchTime;
	}

	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
	}

	@Column(name = "building_addr")
	public String getBuildingAddr() {
		return this.buildingAddr;
	}

	public void setBuildingAddr(String buildingAddr) {
		this.buildingAddr = buildingAddr;
	}

	@Column(name = "building_location")
	public String getBuildingLocation() {
		return this.buildingLocation;
	}

	public void setBuildingLocation(String buildingLocation) {
		this.buildingLocation = buildingLocation;
	}

	@Column(name = "building_pic")
	public String getBuildingPic() {
		return this.buildingPic;
	}

	public void setBuildingPic(String buildingPic) {
		this.buildingPic = buildingPic;
	}

	@Column(name = "video_link")
	public String getVideoLink() {
		return this.videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	@Column(name = "sale_site_location")
	public String getSaleSiteLocation() {
		return this.saleSiteLocation;
	}

	public void setSaleSiteLocation(String saleSiteLocation) {
		this.saleSiteLocation = saleSiteLocation;
	}

	@Column(name = "highest_commission", precision = 18, scale = 0)
	public long getHighestCommission() {
		return this.highestCommission;
	}

	public void setHighestCommission(long highestCommission) {
		this.highestCommission = highestCommission;
	}

	@Column(name = "caution_money", precision = 18, scale = 0)
	public long getCautionMoney() {
		return this.cautionMoney;
	}

	public void setCautionMoney(long cautionMoney) {
		this.cautionMoney = cautionMoney;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "purchase_note")
	public String getPurchaseNote() {
		return this.purchaseNote;
	}

	public void setPurchaseNote(String purchaseNote) {
		this.purchaseNote = purchaseNote;
	}

	@Column(name = "plan_area", precision = 53, scale = 0)
	public double getPlanArea() {
		return this.planArea;
	}

	public void setPlanArea(double planArea) {
		this.planArea = planArea;
	}

	@Column(name = "construction_area", precision = 53, scale = 0)
	public double getConstructionArea() {
		return this.constructionArea;
	}

	public void setConstructionArea(double constructionArea) {
		this.constructionArea = constructionArea;
	}

	@Column(name = "construction_kind")
	public String getConstructionKind() {
		return this.constructionKind;
	}

	public void setConstructionKind(String constructionKind) {
		this.constructionKind = constructionKind;
	}

	@Column(name = "construction_use")
	public String getConstructionUse() {
		return this.constructionUse;
	}

	public void setConstructionUse(String constructionUse) {
		this.constructionUse = constructionUse;
	}

	@Column(name = "plot_rate", precision = 18)
	public double getPlotRate() {
		return this.plotRate;
	}

	public void setPlotRate(double plotRate) {
		this.plotRate = plotRate;
	}

	@Column(name = "greening_rate", precision = 18)
	public double getGreeningRate() {
		return this.greeningRate;
	}

	public void setGreeningRate(double greeningRate) {
		this.greeningRate = greeningRate;
	}

	@Column(name = "household_num")
	public Integer getHouseholdNum() {
		return this.householdNum;
	}

	public void setHouseholdNum(Integer householdNum) {
		this.householdNum = householdNum;
	}

	@Column(name = "parkingspace_num")
	public Integer getParkingspaceNum() {
		return this.parkingspaceNum;
	}

	public void setParkingspaceNum(Integer parkingspaceNum) {
		this.parkingspaceNum = parkingspaceNum;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 23)
	public Date getCreateTime() {
		return this.createTime;
	}

	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "is_copartner")
	public boolean getIsCopartner() {
		return this.isCopartner;
	}

	public void setIsCopartner(boolean isCopartner) {
		this.isCopartner = isCopartner;
	}

	@Column(name = "is_activited")
	public boolean getIsActivited() {
		return this.isActivited;
	}

	public void setIsActivited(boolean isActivited) {
		this.isActivited = isActivited;
	}

	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<BuildingPropertyType> getBuildingPropertyTypes() {
	 * return this.buildingPropertyTypes; }
	 * 
	 * public void setBuildingPropertyTypes( Set<BuildingPropertyType>
	 * buildingPropertyTypes) { this.buildingPropertyTypes =
	 * buildingPropertyTypes; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<BuildingDynamicInfo> getBuildingDynamicInfos() {
	 * return this.buildingDynamicInfos; }
	 * 
	 * public void setBuildingDynamicInfos( Set<BuildingDynamicInfo>
	 * buildingDynamicInfos) { this.buildingDynamicInfos = buildingDynamicInfos;
	 * }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<Property> getProperties() { return
	 * this.properties; }
	 * 
	 * public void setProperties(Set<Property> properties) { this.properties =
	 * properties; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<HousePriceTrend> getHousePriceTrends() { return
	 * this.housePriceTrends; }
	 * 
	 * public void setHousePriceTrends(Set<HousePriceTrend> housePriceTrends) {
	 * this.housePriceTrends = housePriceTrends; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<HousingStrategy> getHousingStrategies() { return
	 * this.housingStrategies; }
	 * 
	 * public void setHousingStrategies(Set<HousingStrategy> housingStrategies)
	 * { this.housingStrategies = housingStrategies; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<PerferentialHouseInfo> getPerferentialHouseInfos()
	 * { return this.perferentialHouseInfos; }
	 * 
	 * public void setPerferentialHouseInfos( Set<PerferentialHouseInfo>
	 * perferentialHouseInfos) { this.perferentialHouseInfos =
	 * perferentialHouseInfos; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<SurroundFacility> getSurroundFacilities() { return
	 * this.surroundFacilities; }
	 * 
	 * public void setSurroundFacilities(Set<SurroundFacility>
	 * surroundFacilities) { this.surroundFacilities = surroundFacilities; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<BuildingSellingPoint> getBuildingSellingPoints() {
	 * return this.buildingSellingPoints; }
	 * 
	 * public void setBuildingSellingPoints( Set<BuildingSellingPoint>
	 * buildingSellingPoints) { this.buildingSellingPoints =
	 * buildingSellingPoints; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<PicTalk> getPicTalks() { return this.picTalks; }
	 * 
	 * public void setPicTalks(Set<PicTalk> picTalks) { this.picTalks =
	 * picTalks; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<House> getHouses() { return this.houses; }
	 * 
	 * public void setHouses(Set<House> houses) { this.houses = houses; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<ConsultantBuildingRel> getConsultantBuildingRels()
	 * { return this.consultantBuildingRels; }
	 * 
	 * public void setConsultantBuildingRels( Set<ConsultantBuildingRel>
	 * consultantBuildingRels) { this.consultantBuildingRels =
	 * consultantBuildingRels; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<CustomerRemark> getCustomerRemarks() { return
	 * this.customerRemarks; }
	 * 
	 * public void setCustomerRemarks(Set<CustomerRemark> customerRemarks) {
	 * this.customerRemarks = customerRemarks; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<ShareInfo> getShareInfos() { return
	 * this.shareInfos; }
	 * 
	 * public void setShareInfos(Set<ShareInfo> shareInfos) { this.shareInfos =
	 * shareInfos; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<GroupPurchaseInfo> getGroupPurchaseInfos() {
	 * return this.groupPurchaseInfos; }
	 * 
	 * public void setGroupPurchaseInfos(Set<GroupPurchaseInfo>
	 * groupPurchaseInfos) { this.groupPurchaseInfos = groupPurchaseInfos; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<RoofBeam> getRoofBeams() { return this.roofBeams;
	 * }
	 * 
	 * public void setRoofBeams(Set<RoofBeam> roofBeams) { this.roofBeams =
	 * roofBeams; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<SaleDirectorBuildingRel>
	 * getSaleDirectorBuildingRels() { return this.saleDirectorBuildingRels; }
	 * 
	 * public void setSaleDirectorBuildingRels( Set<SaleDirectorBuildingRel>
	 * saleDirectorBuildingRels) { this.saleDirectorBuildingRels =
	 * saleDirectorBuildingRels; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<HomeConsultant> getHomeConsultants() { return
	 * this.homeConsultants; }
	 * 
	 * public void setHomeConsultants(Set<HomeConsultant> homeConsultants) {
	 * this.homeConsultants = homeConsultants; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<AdvertisementSpace> getAdvertisementSpaces() {
	 * return this.advertisementSpaces; }
	 * 
	 * public void setAdvertisementSpaces( Set<AdvertisementSpace>
	 * advertisementSpaces) { this.advertisementSpaces = advertisementSpaces; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<OrderStatusRecord> getOrderStatusRecords() {
	 * return this.orderStatusRecords; }
	 * 
	 * public void setOrderStatusRecords(Set<OrderStatusRecord>
	 * orderStatusRecords) { this.orderStatusRecords = orderStatusRecords; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<BuildingPic> getBuildingPics() { return
	 * this.buildingPics; }
	 * 
	 * public void setBuildingPics(Set<BuildingPic> buildingPics) {
	 * this.buildingPics = buildingPics; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<BuildingComment> getBuildingComments() { return
	 * this.buildingComments; }
	 * 
	 * public void setBuildingComments(Set<BuildingComment> buildingComments) {
	 * this.buildingComments = buildingComments; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<HouseStyle> getHouseStyles() { return
	 * this.houseStyles; }
	 * 
	 * public void setHouseStyles(Set<HouseStyle> houseStyles) {
	 * this.houseStyles = houseStyles; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<StoreAchvRecord> getStoreAchvRecords() { return
	 * this.storeAchvRecords; }
	 * 
	 * public void setStoreAchvRecords(Set<StoreAchvRecord> storeAchvRecords) {
	 * this.storeAchvRecords = storeAchvRecords; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<BrokerAchvRecord> getBrokerAchvRecords() { return
	 * this.brokerAchvRecords; }
	 * 
	 * public void setBrokerAchvRecords(Set<BrokerAchvRecord> brokerAchvRecords)
	 * { this.brokerAchvRecords = brokerAchvRecords; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<CommissionRule> getCommissionRules() { return
	 * this.commissionRules; }
	 * 
	 * public void setCommissionRules(Set<CommissionRule> commissionRules) {
	 * this.commissionRules = commissionRules; }
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
	 * "building") public Set<Developer> getDevelopers() { return
	 * this.developers; }
	 * 
	 * public void setDevelopers(Set<Developer> developers) { this.developers =
	 * developers; }
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "estimated_opening_date")
	public Date getEstimatedOpeningDate() {
		return estimatedOpeningDate;
	}

	public void setEstimatedOpeningDate(Date estimatedOpeningDate) {
		this.estimatedOpeningDate = estimatedOpeningDate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rule_id")
	public CommissionRule getRule() {
		return rule;
	}

	public void setRule(CommissionRule rule) {
		this.rule = rule;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "developer_id")
	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "property_id")
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Column(name = "sale_site_phone")
	public String getSaleSitePhone() {
		return saleSitePhone;
	}

	public void setSaleSitePhone(String saleSitePhone) {
		this.saleSitePhone = saleSitePhone;
	}

	@Column(name = "selling_hot_lable")
	public Integer getSellingHotlabel() {
		return sellingHotlabel;
	}

	public void setSellingHotlabel(Integer sellingHotlabel) {
		this.sellingHotlabel = sellingHotlabel;
	}

	@Column(name = "selling_hot_sort")
	public int getSellingHotSort() {
		return sellingHotSort;
	}

	public void setSellingHotSort(int sellingHotSort) {
		this.sellingHotSort = sellingHotSort;
	}

	@Column(name = "building_type")
	public int getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(int buildingType) {
		this.buildingType = buildingType;
	}

	@Column(name = "building_label")
	public String getBuildingLabel() {
		return buildingLabel;
	}

	public void setBuildingLabel(String buildingLabel) {
		this.buildingLabel = buildingLabel;
	}

	@Column(name = "paid_caution_money")
	public Boolean getPaidCautionMoney() {
		return paidCautionMoney;
	}

	public void setPaidCautionMoney(Boolean paidCautionMoney) {
		this.paidCautionMoney = paidCautionMoney;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}