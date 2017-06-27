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
 * PerferentialHouseInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PerferentialHouseInfo", schema = "dbo")
public class PerferentialHouseInfo implements java.io.Serializable {

	// Fields

	private Integer phiId;
	private Building building;
	private String buildingName;
	private String activityId;
	private String activityPic;
	private Date startTime;
	private Date endTime;
	private String purchaseNote;
	private String remark;

	// Constructors

	/** default constructor */
	public PerferentialHouseInfo() {
	}

	/** full constructor */
	public PerferentialHouseInfo(Building building, String activityId,
			String activityPic, Date startTime, Date endTime,
			String purchaseNote, String remark) {
		this.building = building;
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
	@Column(name = "phi_id", unique = true, nullable = false)
	public Integer getPhiId() {
		return this.phiId;
	}

	public void setPhiId(Integer phiId) {
		this.phiId = phiId;
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
		return this.building.getBuildingName();
	}

	public void setBuildingName(String buildingName) {
		this.building.setBuildingName(buildingName);
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

}