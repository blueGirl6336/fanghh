package hitwh.fanghh.manage.pojo.building;

// default package

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
 * BrokerTeam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BrokerTeam", schema = "dbo")
public class BrokerTeam implements java.io.Serializable {

	// Fields

	private Integer teamId;
	private Broker broker;
	private Integer customerNum;
	private Integer dealNum;
	private long saleProfit;
	private long totalCommission;
	private Integer buildingNum;
	private String invitationCode;
	private Integer teamNum;
	/*private Set<TeamBrokerList> teamBrokerLists = new HashSet<TeamBrokerList>(0);
	private Set<Broker> brokers = new HashSet<Broker>(0);
	private Set<GroupCommissionRecord> groupCommissionRecords = new HashSet<GroupCommissionRecord>(
			0);*/

	// Constructors

	/** default constructor */
	public BrokerTeam() {
	}

	/** full constructor */
	public BrokerTeam(Broker broker, Integer customerNum, Integer dealNum,
			long saleProfit, long totalCommission, Integer buildingNum,
			String invitationCode, Integer teamNum) {
		this.broker = broker;
		this.customerNum = customerNum;
		this.dealNum = dealNum;
		this.saleProfit = saleProfit;
		this.totalCommission = totalCommission;
		this.buildingNum = buildingNum;
		this.invitationCode = invitationCode;
		this.teamNum = teamNum;
		/*this.teamBrokerLists = teamBrokerLists;
		this.brokers = brokers;
		this.groupCommissionRecords = groupCommissionRecords;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "team_id", unique = true, nullable = false)
	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_leader")
	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	@Column(name = "customer_num")
	public Integer getCustomerNum() {
		return this.customerNum;
	}

	public void setCustomerNum(Integer customerNum) {
		this.customerNum = customerNum;
	}

	@Column(name = "deal_num")
	public Integer getDealNum() {
		return this.dealNum;
	}

	public void setDealNum(Integer dealNum) {
		this.dealNum = dealNum;
	}

	@Column(name = "sale_profit", precision = 18, scale = 0)
	public long getSaleProfit() {
		return this.saleProfit;
	}

	public void setSaleProfit(long saleProfit) {
		this.saleProfit = saleProfit;
	}

	@Column(name = "total_commission", precision = 18, scale = 0)
	public long getTotalCommission() {
		return this.totalCommission;
	}

	public void setTotalCommission(long totalCommission) {
		this.totalCommission = totalCommission;
	}

	@Column(name = "building_num")
	public Integer getBuildingNum() {
		return this.buildingNum;
	}

	public void setBuildingNum(Integer buildingNum) {
		this.buildingNum = buildingNum;
	}

	@Column(name = "invitation_code")
	public String getInvitationCode() {
		return this.invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	@Column(name = "team_num")
	public Integer getTeamNum() {
		return this.teamNum;
	}

	public void setTeamNum(Integer teamNum) {
		this.teamNum = teamNum;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "brokerTeam")
	public Set<TeamBrokerList> getTeamBrokerLists() {
		return this.teamBrokerLists;
	}

	public void setTeamBrokerLists(Set<TeamBrokerList> teamBrokerLists) {
		this.teamBrokerLists = teamBrokerLists;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "brokerTeam")
	public Set<Broker> getBrokers() {
		return this.brokers;
	}

	public void setBrokers(Set<Broker> brokers) {
		this.brokers = brokers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "brokerTeam")
	public Set<GroupCommissionRecord> getGroupCommissionRecords() {
		return this.groupCommissionRecords;
	}

	public void setGroupCommissionRecords(
			Set<GroupCommissionRecord> groupCommissionRecords) {
		this.groupCommissionRecords = groupCommissionRecords;
	}
*/
}