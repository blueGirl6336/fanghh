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
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Broker entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Broker", schema = "dbo")
@JsonIgnoreProperties(value={"brokerTeam"}) 
public class Broker implements java.io.Serializable {

	// Fields

	private Integer brokerId;
	private User user;
	private String username;
	private String phoneNo;
	private BrokerTeam brokerTeam;
	private Store store;
	private String brokerName;
	private String brokerIdcard;
	private String brokerType;
	private String invitationCode;
	private String idcardPic;
	private String failedReason;
	/*private Set<GroupCommissionRecord> groupCommissionRecords = new HashSet<GroupCommissionRecord>(
			0);
	private Set<BrokerCommentFromConsultant> brokerCommentFromConsultants = new HashSet<BrokerCommentFromConsultant>(
			0);
	private Set<TeamBrokerList> teamBrokerLists = new HashSet<TeamBrokerList>(0);
	private Set<BrokerCommissionRecord> brokerCommissionRecords = new HashSet<BrokerCommissionRecord>(
			0);
	private Set<ConsultantCommentFromBroker> consultantCommentFromBrokers = new HashSet<ConsultantCommentFromBroker>(
			0);
	private Set<TradeRecord> tradeRecords = new HashSet<TradeRecord>(0);
	private Set<RecommendOrder> recommendOrders = new HashSet<RecommendOrder>(0);
	private Set<BrokerAchv> brokerAchvs = new HashSet<BrokerAchv>(0);
	private Set<Wallet> wallets = new HashSet<Wallet>(0);
	private Set<BrokerTeam> brokerTeams = new HashSet<BrokerTeam>(0);
	private Set<BrokerAchvRecord> brokerAchvRecords = new HashSet<BrokerAchvRecord>(
			0);
	private Set<PushNews> pushNewses = new HashSet<PushNews>(0);
	private Set<Store> stores = new HashSet<Store>(0);
	private Set<Voucher> vouchers = new HashSet<Voucher>(0);*/

	// Constructors

	/** default constructor */
	public Broker() {
	}

	/** full constructor */
	public Broker(User user, BrokerTeam brokerTeam, Store store,
			String brokerName, String brokerIdcard, String brokerType,
			String invitationCode
			) {
		this.user = user;
		this.brokerTeam = brokerTeam;
		this.store = store;
		this.brokerName = brokerName;
		this.brokerIdcard = brokerIdcard;
		this.brokerType = brokerType;
		this.invitationCode = invitationCode;
		/*this.groupCommissionRecords = groupCommissionRecords;
		this.brokerCommentFromConsultants = brokerCommentFromConsultants;
		this.teamBrokerLists = teamBrokerLists;
		this.brokerCommissionRecords = brokerCommissionRecords;
		this.consultantCommentFromBrokers = consultantCommentFromBrokers;
		this.tradeRecords = tradeRecords;
		this.recommendOrders = recommendOrders;
		this.brokerAchvs = brokerAchvs;
		this.wallets = wallets;
		this.brokerTeams = brokerTeams;
		this.brokerAchvRecords = brokerAchvRecords;
		this.pushNewses = pushNewses;
		this.stores = stores;
		this.vouchers = vouchers;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "broker_id", unique = true, nullable = false)
	public Integer getBrokerId() {
		return this.brokerId;
	}

	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	@Transient
	public String getUsername() {
		return user.getUsername();
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Transient
	public String getPhoneNo() {
		return user.getPhoneNo();
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id")
	public BrokerTeam getBrokerTeam() {
		return this.brokerTeam;
	}

	public void setBrokerTeam(BrokerTeam brokerTeam) {
		this.brokerTeam = brokerTeam;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "store_id")
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "broker_name")
	public String getBrokerName() {
		return this.brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	@Column(name = "broker_idcard")
	public String getBrokerIdcard() {
		return this.brokerIdcard;
	}

	public void setBrokerIdcard(String brokerIdcard) {
		this.brokerIdcard = brokerIdcard;
	}

	@Column(name = "broker_type")
	public String getBrokerType() {
		return this.brokerType;
	}

	public void setBrokerType(String brokerType) {
		this.brokerType = brokerType;
	}

	@Column(name = "invitation_code")
	public String getInvitationCode() {
		return this.invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	@Column(name = "idcard_pic")
	public String getIdcardPic() {
		return idcardPic;
	}

	public void setIdcardPic(String idcardPic) {
		this.idcardPic = idcardPic;
	}

	@Column(name = "failed_reason")
	public String getFailedReason() {
		return failedReason;
	}

	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}

	
	

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<GroupCommissionRecord> getGroupCommissionRecords() {
		return this.groupCommissionRecords;
	}

	public void setGroupCommissionRecords(
			Set<GroupCommissionRecord> groupCommissionRecords) {
		this.groupCommissionRecords = groupCommissionRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<BrokerCommentFromConsultant> getBrokerCommentFromConsultants() {
		return this.brokerCommentFromConsultants;
	}

	public void setBrokerCommentFromConsultants(
			Set<BrokerCommentFromConsultant> brokerCommentFromConsultants) {
		this.brokerCommentFromConsultants = brokerCommentFromConsultants;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<TeamBrokerList> getTeamBrokerLists() {
		return this.teamBrokerLists;
	}

	public void setTeamBrokerLists(Set<TeamBrokerList> teamBrokerLists) {
		this.teamBrokerLists = teamBrokerLists;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<BrokerCommissionRecord> getBrokerCommissionRecords() {
		return this.brokerCommissionRecords;
	}

	public void setBrokerCommissionRecords(
			Set<BrokerCommissionRecord> brokerCommissionRecords) {
		this.brokerCommissionRecords = brokerCommissionRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<ConsultantCommentFromBroker> getConsultantCommentFromBrokers() {
		return this.consultantCommentFromBrokers;
	}

	public void setConsultantCommentFromBrokers(
			Set<ConsultantCommentFromBroker> consultantCommentFromBrokers) {
		this.consultantCommentFromBrokers = consultantCommentFromBrokers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<TradeRecord> getTradeRecords() {
		return this.tradeRecords;
	}

	public void setTradeRecords(Set<TradeRecord> tradeRecords) {
		this.tradeRecords = tradeRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<RecommendOrder> getRecommendOrders() {
		return this.recommendOrders;
	}

	public void setRecommendOrders(Set<RecommendOrder> recommendOrders) {
		this.recommendOrders = recommendOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<BrokerAchv> getBrokerAchvs() {
		return this.brokerAchvs;
	}

	public void setBrokerAchvs(Set<BrokerAchv> brokerAchvs) {
		this.brokerAchvs = brokerAchvs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<Wallet> getWallets() {
		return this.wallets;
	}

	public void setWallets(Set<Wallet> wallets) {
		this.wallets = wallets;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<BrokerTeam> getBrokerTeams() {
		return this.brokerTeams;
	}

	public void setBrokerTeams(Set<BrokerTeam> brokerTeams) {
		this.brokerTeams = brokerTeams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<BrokerAchvRecord> getBrokerAchvRecords() {
		return this.brokerAchvRecords;
	}

	public void setBrokerAchvRecords(Set<BrokerAchvRecord> brokerAchvRecords) {
		this.brokerAchvRecords = brokerAchvRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<PushNews> getPushNewses() {
		return this.pushNewses;
	}

	public void setPushNewses(Set<PushNews> pushNewses) {
		this.pushNewses = pushNewses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<Store> getStores() {
		return this.stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "broker")
	public Set<Voucher> getVouchers() {
		return this.vouchers;
	}

	public void setVouchers(Set<Voucher> vouchers) {
		this.vouchers = vouchers;
	}
*/
}