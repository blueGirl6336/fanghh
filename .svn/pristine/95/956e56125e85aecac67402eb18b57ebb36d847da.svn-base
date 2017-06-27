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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * City entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "City", schema = "dbo")
public class City implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private String cityName;
	//private Set<Region> regions = new HashSet<Region>(0);

	// Constructors

	/** default constructor */
	public City() {
	}

	/** full constructor */
	public City(String cityName) {
		this.cityName = cityName;
		//this.regions = regions;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "city_id", unique = true, nullable = false)
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "city_name", length = 1024)
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
	public Set<Region> getRegions() {
		return this.regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}*/

}