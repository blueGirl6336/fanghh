// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * BuildingSearchRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BuildingSearchRecord", schema = "dbo")
public class BuildingSearchRecord implements java.io.Serializable {

	// Fields

	private Integer bsrId;
	private String buildingName;
	private Date searchTime;

	// Constructors

	/** default constructor */
	public BuildingSearchRecord() {
	}

	/** full constructor */
	public BuildingSearchRecord(String buildingName, Date searchTime) {
		this.buildingName = buildingName;
		this.searchTime = searchTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bsr_id", unique = true, nullable = false)
	public Integer getBsrId() {
		return this.bsrId;
	}

	public void setBsrId(Integer bsrId) {
		this.bsrId = bsrId;
	}

	@Column(name = "building_name")
	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "search_time", length = 23)
	public Date getSearchTime() {
		return this.searchTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setSearchTime(Date searchTime) {
		this.searchTime = searchTime;
	}

}