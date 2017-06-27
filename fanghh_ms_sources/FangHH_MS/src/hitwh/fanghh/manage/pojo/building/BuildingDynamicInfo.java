// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * BuildingDynamicInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BuildingDynamicInfo", schema = "dbo")
public class BuildingDynamicInfo implements java.io.Serializable {

	// Fields

	private Integer bdiId;
	private Building building;
	private String title;
	private Date issueTime;
	private boolean isLatest;
	//private Set<DynamicContent> dynamicContents = new HashSet<DynamicContent>(0);

	// Constructors

	/** default constructor */
	public BuildingDynamicInfo() {
	}

	/** full constructor */
	public BuildingDynamicInfo(Building building, String title, Date issueTime,
			boolean isLatest) {
		this.building = building;
		this.title = title;
		this.issueTime = issueTime;
		this.isLatest = isLatest;
		//this.dynamicContents = dynamicContents;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bdi_id", unique = true, nullable = false)
	public Integer getBdiId() {
		return this.bdiId;
	}

	public void setBdiId(Integer bdiId) {
		this.bdiId = bdiId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "issue_time", length = 23)
	public Date getIssueTime() {
		return this.issueTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}

	@Column(name = "is_latest")
	public boolean getIsLatest() {
		return this.isLatest;
	}

	public void setIsLatest(boolean isLatest) {
		this.isLatest = isLatest;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buildingDynamicInfo")
	public Set<DynamicContent> getDynamicContents() {
		return this.dynamicContents;
	}

	public void setDynamicContents(Set<DynamicContent> dynamicContents) {
		this.dynamicContents = dynamicContents;
	}*/

}