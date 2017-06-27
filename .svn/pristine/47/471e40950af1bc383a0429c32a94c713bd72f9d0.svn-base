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
 * Region entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Region", schema = "dbo")
public class Region implements java.io.Serializable {

	// Fields

	private Integer regionId;
	private City city;
	private String regionName;
	/*private Set<RegionProxy> regionProxies = new HashSet<RegionProxy>(0);
	private Set<Building> buildings = new HashSet<Building>(0);*/

	// Constructors

	/** default constructor */
	public Region() {
	}

	/** full constructor */
	public Region(City city, String regionName) {
		this.city = city;
		this.regionName = regionName;
		/*this.regionProxies = regionProxies;
		this.buildings = buildings;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "region_id", unique = true, nullable = false)
	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id")
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "region_name")
	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

/*	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "region")
	public Set<RegionProxy> getRegionProxies() {
		return this.regionProxies;
	}

	public void setRegionProxies(Set<RegionProxy> regionProxies) {
		this.regionProxies = regionProxies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "region")
	public Set<Building> getBuildings() {
		return this.buildings;
	}

	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}*/

}