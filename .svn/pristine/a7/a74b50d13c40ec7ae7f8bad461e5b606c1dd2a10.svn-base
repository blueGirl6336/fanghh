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
 * BuildingSearchStatistics entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BuildingSearchStatistics", schema = "dbo")
public class BuildingSearchStatistics implements java.io.Serializable {

	// Fields

	private Integer bssId;
	private String buildingName;
	private long staticsticTimes;
	private Date startTime;
	private Date endTime;

	// Constructors

	/** default constructor */
	public BuildingSearchStatistics() {
	}

	/** full constructor */
	public BuildingSearchStatistics(String buildingName, long staticsticTimes,
			Date startTime, Date endTime) {
		this.buildingName = buildingName;
		this.staticsticTimes = staticsticTimes;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bss_id", unique = true, nullable = false)
	public Integer getBssId() {
		return this.bssId;
	}

	public void setBssId(Integer bssId) {
		this.bssId = bssId;
	}

	@Column(name = "building_name")
	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Column(name = "staticstic_times")
	public long getStaticsticTimes() {
		return this.staticsticTimes;
	}

	public void setStaticsticTimes(long staticsticTimes) {
		this.staticsticTimes = staticsticTimes;
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

}