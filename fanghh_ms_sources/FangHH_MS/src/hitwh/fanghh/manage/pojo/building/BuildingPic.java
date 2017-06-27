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

/**
 * BuildingPic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BuildingPic", schema = "dbo")
public class BuildingPic implements java.io.Serializable {

	// Fields

	private Integer bpId;
	private Building building;
	private String picType;
	private String picLocation;
	private String picDescription;

	// Constructors

	/** default constructor */
	public BuildingPic() {
	}

	/** full constructor */
	public BuildingPic(Building building, String picType, String picLocation,
			String picDescription) {
		this.building = building;
		this.picType = picType;
		this.picLocation = picLocation;
		this.picDescription = picDescription;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bp_id", unique = true, nullable = false)
	public Integer getBpId() {
		return this.bpId;
	}

	public void setBpId(Integer bpId) {
		this.bpId = bpId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "pic_type")
	public String getPicType() {
		return this.picType;
	}

	public void setPicType(String picType) {
		this.picType = picType;
	}

	@Column(name = "pic_location")
	public String getPicLocation() {
		return this.picLocation;
	}

	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}

	@Column(name = "pic_description")
	public String getPicDescription() {
		return this.picDescription;
	}

	public void setPicDescription(String picDescription) {
		this.picDescription = picDescription;
	}

}