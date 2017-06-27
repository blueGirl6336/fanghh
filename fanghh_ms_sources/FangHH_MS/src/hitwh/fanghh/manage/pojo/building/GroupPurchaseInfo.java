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
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * GroupPurchaseInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GroupPurchaseInfo", schema = "dbo")
public class GroupPurchaseInfo implements java.io.Serializable {

	// Fields

	private Integer gpId;
	private Building building;
	private String buildingName;
	private String activityId;
	private String activityPic;
	private Integer personNumInFavor;
	private Integer minPersonNumStandard;
	private Date startTime;
	private Date endTime;
	private Integer totalOfferNum;
	private Integer currentPurchasedNum;
	private long orginalPricePerSquareMeter;
	private long orginalHousePrice;
	private long currentPricePerSquareMetre;
	private long currentHouse;
	private String purchaseNote;
	private boolean isSuccess;

	// Constructors

	/** default constructor */
	public GroupPurchaseInfo() {
	}

	/** full constructor */
	public GroupPurchaseInfo(Building building, String activityId,
			String activityPic, Integer personNumInFavor,
			Integer minPersonNumStandard, Date startTime, Date endTime,
			Integer totalOfferNum, Integer currentPurchasedNum,
			long orginalPricePerSquareMeter, long orginalHousePrice,
			long currentPricePerSquareMetre, long currentHouse,
			String purchaseNote, boolean isSuccess) {
		this.building = building;
		this.activityId = activityId;
		this.activityPic = activityPic;
		this.personNumInFavor = personNumInFavor;
		this.minPersonNumStandard = minPersonNumStandard;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalOfferNum = totalOfferNum;
		this.currentPurchasedNum = currentPurchasedNum;
		this.orginalPricePerSquareMeter = orginalPricePerSquareMeter;
		this.orginalHousePrice = orginalHousePrice;
		this.currentPricePerSquareMetre = currentPricePerSquareMetre;
		this.currentHouse = currentHouse;
		this.purchaseNote = purchaseNote;
		this.isSuccess = isSuccess;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "gp_id", unique = true, nullable = false)
	public Integer getGpId() {
		return this.gpId;
	}

	public void setGpId(Integer gpId) {
		this.gpId = gpId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
	
	@Transient
	public String getBuildingName() {
		return this.getBuilding().getBuildingName();
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Column(name = "activity_id")
	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Column(name = "activity_pic")
	public String getActivityPic() {
		return this.activityPic;
	}

	public void setActivityPic(String activityPic) {
		this.activityPic = activityPic;
	}

	@Column(name = "person_num_in_favor")
	public Integer getPersonNumInFavor() {
		return this.personNumInFavor;
	}

	public void setPersonNumInFavor(Integer personNumInFavor) {
		this.personNumInFavor = personNumInFavor;
	}

	@Column(name = "min_person_num_standard")
	public Integer getMinPersonNumStandard() {
		return this.minPersonNumStandard;
	}

	public void setMinPersonNumStandard(Integer minPersonNumStandard) {
		this.minPersonNumStandard = minPersonNumStandard;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time", length = 23)
	public Date getStartTime() {
		return this.startTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time", length = 23)
	public Date getEndTime() {
		return this.endTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "total_offer_num")
	public Integer getTotalOfferNum() {
		return this.totalOfferNum;
	}

	public void setTotalOfferNum(Integer totalOfferNum) {
		this.totalOfferNum = totalOfferNum;
	}

	@Column(name = "current_purchased_num")
	public Integer getCurrentPurchasedNum() {
		return this.currentPurchasedNum;
	}

	public void setCurrentPurchasedNum(Integer currentPurchasedNum) {
		this.currentPurchasedNum = currentPurchasedNum;
	}

	@Column(name = "orginal_price_per_square_meter", precision = 18, scale = 0)
	public long getOrginalPricePerSquareMeter() {
		return this.orginalPricePerSquareMeter;
	}

	public void setOrginalPricePerSquareMeter(long orginalPricePerSquareMeter) {
		this.orginalPricePerSquareMeter = orginalPricePerSquareMeter;
	}

	@Column(name = "orginal_house_price", precision = 18, scale = 0)
	public long getOrginalHousePrice() {
		return this.orginalHousePrice;
	}

	public void setOrginalHousePrice(long orginalHousePrice) {
		this.orginalHousePrice = orginalHousePrice;
	}

	@Column(name = "current_price_per_square_metre", precision = 18, scale = 0)
	public long getCurrentPricePerSquareMetre() {
		return this.currentPricePerSquareMetre;
	}

	public void setCurrentPricePerSquareMetre(long currentPricePerSquareMetre) {
		this.currentPricePerSquareMetre = currentPricePerSquareMetre;
	}

	@Column(name = "current_house_price", precision = 18, scale = 0)
	public long getCurrentHouse() {
		return this.currentHouse;
	}

	public void setCurrentHouse(long currentHouse) {
		this.currentHouse = currentHouse;
	}

	@Column(name = "purchase_note")
	public String getPurchaseNote() {
		return this.purchaseNote;
	}

	public void setPurchaseNote(String purchaseNote) {
		this.purchaseNote = purchaseNote;
	}

	@Column(name = "is_success")
	public boolean getIsSuccess() {
		return this.isSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}