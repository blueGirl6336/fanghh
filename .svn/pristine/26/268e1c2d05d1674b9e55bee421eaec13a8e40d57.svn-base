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

import org.apache.commons.codec.language.bm.Rule;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * ClearanceHouseInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ClearanceHouseInfo", schema = "dbo")
public class ClearanceHouseInfo implements java.io.Serializable {

	// Fields

	private Integer chiId;
	private Building building;
	private CommissionRule rule;
	private Integer buildingId;
	private String buildingName;
	private House house;
	private String activityId;
	private String activityPic;
	private Date startTime;
	private Date endTime;
	private String purchaseNote;
	private String remark;

	// Constructors

	/** default constructor */
	public ClearanceHouseInfo() {
	}

	public ClearanceHouseInfo(Building building, CommissionRule rule,
			String buildingName, House house, String activityId,
			String activityPic, Date startTime, Date endTime,
			String purchaseNote, String remark) {
		this.building = building;
		this.rule = rule;
		this.buildingName = buildingName;
		this.house = house;
		this.activityId = activityId;
		this.activityPic = activityPic;
		this.startTime = startTime;
		this.endTime = endTime;
		this.purchaseNote = purchaseNote;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "chi_id", unique = true, nullable = false)
	public Integer getChiId() {
		return this.chiId;
	}

	public void setChiId(Integer chiId) {
		this.chiId = chiId;
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
	public Integer getBuildingId() {
		return this.building.getBuildingId();
	}

	public void setBuildingId(Integer buildingId) {
		this.setBuildingId(buildingId);
	}

	@Transient
	public String getBuildingName() {
		return this.building.getBuildingName();
	}

	public void setBuildingName(String buildingName) {
		if(buildingName != null) {
			this.building.setBuildingName(buildingName);
		}
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "house_id")
	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
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

	@Column(name = "purchase_note")
	public String getPurchaseNote() {
		return this.purchaseNote;
	}

	public void setPurchaseNote(String purchaseNote) {
		this.purchaseNote = purchaseNote;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rule_id")
	public CommissionRule getRule() {
		return rule;
	}

	public void setRule(CommissionRule rule) {
		this.rule = rule;
	}

}