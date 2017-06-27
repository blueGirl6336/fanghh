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
 * HomeConsultant entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HomeConsultant", schema = "dbo")
public class HomeConsultant implements java.io.Serializable {

	// Fields

	private Integer consultantId;
	private User user;
	private Building building;
	private String consultantName;
	private String consultantIdcard;
	private boolean isAgent;
	private boolean isStopped;
	/*private Set<ConsultantBuildingRel> consultantBuildingRels = new HashSet<ConsultantBuildingRel>(
			0);
	private Set<BrokerCommentFromConsultant> brokerCommentFromConsultants = new HashSet<BrokerCommentFromConsultant>(
			0);
	private Set<ConsultantCustomer> consultantCustomers = new HashSet<ConsultantCustomer>(
			0);
	private Set<HomeConsultantAchv> homeConsultantAchvs = new HashSet<HomeConsultantAchv>(
			0);
	private Set<ConsultantMessage> consultantMessages = new HashSet<ConsultantMessage>(
			0);
	private Set<ConsultantCommentFromBroker> consultantCommentFromBrokers = new HashSet<ConsultantCommentFromBroker>(
			0);
	private Set<BuildingComment> buildingComments = new HashSet<BuildingComment>(
			0);
	private Set<DistributionOrder> distributionOrders = new HashSet<DistributionOrder>(
			0);
	private Set<ConsultantAchvRecord> consultantAchvRecords = new HashSet<ConsultantAchvRecord>(
			0);*/

	// Constructors

	/** default constructor */
	public HomeConsultant() {
	}

	/** full constructor */
	public HomeConsultant(User user, Building building,
			String consultantName, String consultantIdcard, boolean isAgent,
			boolean isStopped) {
		this.user = user;
		this.building = building;
		this.consultantName = consultantName;
		this.consultantIdcard = consultantIdcard;
		this.isAgent = isAgent;
		this.isStopped = isStopped;
		/*this.consultantBuildingRels = consultantBuildingRels;
		this.brokerCommentFromConsultants = brokerCommentFromConsultants;
		this.consultantCustomers = consultantCustomers;
		this.homeConsultantAchvs = homeConsultantAchvs;
		this.consultantMessages = consultantMessages;
		this.consultantCommentFromBrokers = consultantCommentFromBrokers;
		this.buildingComments = buildingComments;
		this.distributionOrders = distributionOrders;
		this.consultantAchvRecords = consultantAchvRecords;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "consultant_id", unique = true, nullable = false)
	public Integer getConsultantId() {
		return this.consultantId;
	}

	public void setConsultantId(Integer consultantId) {
		this.consultantId = consultantId;
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
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "consultant_name")
	public String getConsultantName() {
		return this.consultantName;
	}

	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}

	@Column(name = "consultant_idcard")
	public String getConsultantIdcard() {
		return this.consultantIdcard;
	}

	public void setConsultantIdcard(String consultantIdcard) {
		this.consultantIdcard = consultantIdcard;
	}

	@Column(name = "is_agent")
	public boolean getIsAgent() {
		return this.isAgent;
	}

	public void setIsAgent(boolean isAgent) {
		this.isAgent = isAgent;
	}

	@Column(name = "is_stopped")
	public boolean getIsStopped() {
		return this.isStopped;
	}

	public void setIsStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "homeConsultant")
	public Set<ConsultantBuildingRel> getConsultantBuildingRels() {
		return this.consultantBuildingRels;
	}

	public void setConsultantBuildingRels(
			Set<ConsultantBuildingRel> consultantBuildingRels) {
		this.consultantBuildingRels = consultantBuildingRels;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "homeConsultant")
	public Set<BrokerCommentFromConsultant> getBrokerCommentFromConsultants() {
		return this.brokerCommentFromConsultants;
	}

	public void setBrokerCommentFromConsultants(
			Set<BrokerCommentFromConsultant> brokerCommentFromConsultants) {
		this.brokerCommentFromConsultants = brokerCommentFromConsultants;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "homeConsultant")
	public Set<ConsultantCustomer> getConsultantCustomers() {
		return this.consultantCustomers;
	}

	public void setConsultantCustomers(
			Set<ConsultantCustomer> consultantCustomers) {
		this.consultantCustomers = consultantCustomers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "homeConsultant")
	public Set<HomeConsultantAchv> getHomeConsultantAchvs() {
		return this.homeConsultantAchvs;
	}

	public void setHomeConsultantAchvs(
			Set<HomeConsultantAchv> homeConsultantAchvs) {
		this.homeConsultantAchvs = homeConsultantAchvs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "homeConsultant")
	public Set<ConsultantMessage> getConsultantMessages() {
		return this.consultantMessages;
	}

	public void setConsultantMessages(Set<ConsultantMessage> consultantMessages) {
		this.consultantMessages = consultantMessages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "homeConsultant")
	public Set<ConsultantCommentFromBroker> getConsultantCommentFromBrokers() {
		return this.consultantCommentFromBrokers;
	}

	public void setConsultantCommentFromBrokers(
			Set<ConsultantCommentFromBroker> consultantCommentFromBrokers) {
		this.consultantCommentFromBrokers = consultantCommentFromBrokers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "homeConsultant")
	public Set<BuildingComment> getBuildingComments() {
		return this.buildingComments;
	}

	public void setBuildingComments(Set<BuildingComment> buildingComments) {
		this.buildingComments = buildingComments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "homeConsultant")
	public Set<DistributionOrder> getDistributionOrders() {
		return this.distributionOrders;
	}

	public void setDistributionOrders(Set<DistributionOrder> distributionOrders) {
		this.distributionOrders = distributionOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "homeConsultant")
	public Set<ConsultantAchvRecord> getConsultantAchvRecords() {
		return this.consultantAchvRecords;
	}

	public void setConsultantAchvRecords(
			Set<ConsultantAchvRecord> consultantAchvRecords) {
		this.consultantAchvRecords = consultantAchvRecords;
	}*/

}