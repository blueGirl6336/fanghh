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
 * BuildingSellingPoint entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BuildingSellingPoint", schema = "dbo")
public class BuildingSellingPoint implements java.io.Serializable {

	// Fields

	private Integer bspId;
	private Building building;
	private String title;
	private Date issueTime;
	/*private Set<SellingPointContent> sellingPointContents = new HashSet<SellingPointContent>(
			0);*/

	// Constructors

	/** default constructor */
	public BuildingSellingPoint() {
	}

	/** full constructor */
	public BuildingSellingPoint(Building building, String title,
			Date issueTime) {
		this.building = building;
		this.title = title;
		this.issueTime = issueTime;
		//this.sellingPointContents = sellingPointContents;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bsp_id", unique = true, nullable = false)
	public Integer getBspId() {
		return this.bspId;
	}

	public void setBspId(Integer bspId) {
		this.bspId = bspId;
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

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buildingSellingPoint")
	public Set<SellingPointContent> getSellingPointContents() {
		return this.sellingPointContents;
	}

	public void setSellingPointContents(
			Set<SellingPointContent> sellingPointContents) {
		this.sellingPointContents = sellingPointContents;
	}*/

}