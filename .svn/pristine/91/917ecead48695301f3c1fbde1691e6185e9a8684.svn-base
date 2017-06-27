// default package
package hitwh.fanghh.manage.pojo.building;
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

/**
 * Unit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Unit", schema = "dbo")
public class Unit implements java.io.Serializable {

	// Fields

	private Integer unitId;
	private RoofBeam roofBeam;
	private String unitCode;
	//private Set<House> houses = new HashSet<House>(0);

	// Constructors

	/** default constructor */
	public Unit() {
	}

	/** full constructor */
	public Unit(RoofBeam roofBeam, String unitCode) {
		this.roofBeam = roofBeam;
		this.unitCode = unitCode;
		//this.houses = houses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "unit_id", unique = true, nullable = false)
	public Integer getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roof_id")
	public RoofBeam getRoofBeam() {
		return this.roofBeam;
	}

	public void setRoofBeam(RoofBeam roofBeam) {
		this.roofBeam = roofBeam;
	}

	@Column(name = "unit_code")
	public String getUnitCode() {
		return this.unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "unit")
	public Set<House> getHouses() {
		return this.houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}*/

}