// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.pojo.User;

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
 * SalesDirector entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SalesDirector", schema = "dbo")
public class SalesDirector implements java.io.Serializable {

	// Fields

	private Integer directorId;
	private User user;
	private RegionProxy regionProxy;
	private String directorName;
	private String directorIdcard;
	private boolean isAgent;
	/*private Set<SaleDirectorBuildingRel> saleDirectorBuildingRels = new HashSet<SaleDirectorBuildingRel>(
			0);
	private Set<ConsultantMessage> consultantMessages = new HashSet<ConsultantMessage>(
			0);
	private Set<DistributionOrder> distributionOrders = new HashSet<DistributionOrder>(
			0);
	private Set<Building> buildings = new HashSet<Building>(0);*/

	// Constructors

	/** default constructor */
	public SalesDirector() {
	}

	/** full constructor */

	

	public SalesDirector(User user, RegionProxy regionProxy,
			String directorName, String directorIdcard, boolean isAgent
			) {
		this.user = user;

		this.regionProxy = regionProxy;
		this.directorName = directorName;
		this.directorIdcard = directorIdcard;
		this.isAgent = isAgent;
		/*this.saleDirectorBuildingRels = saleDirectorBuildingRels;
		this.consultantMessages = consultantMessages;
		this.distributionOrders = distributionOrders;
		this.buildings = buildings;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "director_id", unique = true, nullable = false)
	public Integer getDirectorId() {
		return this.directorId;
	}

	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rp_id")
	public RegionProxy getRegionProxy() {
		return this.regionProxy;
	}

	public void setRegionProxy(RegionProxy regionProxy) {
		this.regionProxy = regionProxy;
	}

	@Column(name = "director_name")
	public String getDirectorName() {
		return this.directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	@Column(name = "director_idcard")
	public String getDirectorIdcard() {
		return this.directorIdcard;
	}

	public void setDirectorIdcard(String directorIdcard) {
		this.directorIdcard = directorIdcard;
	}

	@Column(name = "is_agent")
	public boolean getIsAgent() {
		return this.isAgent;
	}

	public void setIsAgent(boolean isAgent) {
		this.isAgent = isAgent;
	}
/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salesDirector")
	public Set<SaleDirectorBuildingRel> getSaleDirectorBuildingRels() {
		return this.saleDirectorBuildingRels;
	}

	public void setSaleDirectorBuildingRels(
			Set<SaleDirectorBuildingRel> saleDirectorBuildingRels) {
		this.saleDirectorBuildingRels = saleDirectorBuildingRels;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salesDirector")
	public Set<ConsultantMessage> getConsultantMessages() {
		return this.consultantMessages;
	}

	public void setConsultantMessages(Set<ConsultantMessage> consultantMessages) {
		this.consultantMessages = consultantMessages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salesDirector")
	public Set<DistributionOrder> getDistributionOrders() {
		return this.distributionOrders;
	}

	public void setDistributionOrders(Set<DistributionOrder> distributionOrders) {
		this.distributionOrders = distributionOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salesDirector")
	public Set<Building> getBuildings() {
		return this.buildings;
	}

	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}*/

}