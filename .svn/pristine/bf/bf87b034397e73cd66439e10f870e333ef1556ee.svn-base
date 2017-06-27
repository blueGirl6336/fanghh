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
 * RegionProxy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RegionProxy", schema = "dbo")
public class RegionProxy implements java.io.Serializable {

	// Fields

	private Integer rpId;
	private Region region;
	private String proxyName;
	//private Set<SalesDirector> salesDirectors = new HashSet<SalesDirector>(0);

	// Constructors

	/** default constructor */
	public RegionProxy() {
	}

	/** full constructor */
	public RegionProxy(Region region, String proxyName) {
		this.region = region;
		this.proxyName = proxyName;
		//this.salesDirectors = salesDirectors;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "rp_id", unique = true, nullable = false)
	public Integer getRpId() {
		return this.rpId;
	}

	public void setRpId(Integer rpId) {
		this.rpId = rpId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "region_id")
	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Column(name = "proxy_name")
	public String getProxyName() {
		return this.proxyName;
	}

	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "regionProxy")
	public Set<SalesDirector> getSalesDirectors() {
		return this.salesDirectors;
	}

	public void setSalesDirectors(Set<SalesDirector> salesDirectors) {
		this.salesDirectors = salesDirectors;
	}*/

}