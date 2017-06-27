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
 * BuildingPropertyType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BuildingPropertyType", schema = "dbo")
public class BuildingPropertyType implements java.io.Serializable {

	// Fields

	private Integer bptId;
	private Building building;
	private String propertyType;

	// Constructors

	/** default constructor */
	public BuildingPropertyType() {
	}

	/** full constructor */
	public BuildingPropertyType(Building building, String propertyType) {
		this.building = building;
		this.propertyType = propertyType;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bpt_id", unique = true, nullable = false)
	public Integer getBptId() {
		return this.bptId;
	}

	public void setBptId(Integer bptId) {
		this.bptId = bptId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "property_type")
	public String getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

}