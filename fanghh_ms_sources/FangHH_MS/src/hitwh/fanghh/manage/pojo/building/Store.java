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
import javax.persistence.Transient;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Store", schema = "dbo")
public class Store implements java.io.Serializable {

	// Fields

	private Integer storeId;
	private Broker broker;
	private String brokerName;
	private String storeName;
	private String storePortrait;
	private Integer customerNum;
	private Integer dealNum;
	private Long saleProfit;
	private Long totalCommission;
	private Integer buildingNum;
	private String invitationCode;
	private Integer storeNum;
	private String status;
	private String failedReason;

	/** default constructor */
	public Store() {
	}

	/** full constructor */
	public Store(Broker broker, String storeName, String storePortrait,
			Integer customerNum, Integer dealNum, Long saleProfit,
			Long totalCommission, Integer buildingNum, String invitationCode,
			Integer storeNum) {
		this.broker = broker;
		this.storeName = storeName;
		this.storePortrait = storePortrait;
		this.customerNum = customerNum;
		this.dealNum = dealNum;
		this.saleProfit = saleProfit;
		this.totalCommission = totalCommission;
		this.buildingNum = buildingNum;
		this.invitationCode = invitationCode;
		this.storeNum = storeNum;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "store_id", unique = true, nullable = false)
	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "store_leader")
	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	@Transient
	public String getBrokerName() {
		return broker.getBrokerName();
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	@Column(name = "store_name")
	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Column(name = "store_portrait")
	public String getStorePortrait() {
		return this.storePortrait;
	}

	public void setStorePortrait(String storePortrait) {
		this.storePortrait = storePortrait;
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
	public Long getSaleProfit() {
		return this.saleProfit;
	}

	public void setSaleProfit(Long saleProfit) {
		this.saleProfit = saleProfit;
	}

	@Column(name = "total_commission", precision = 18, scale = 0)
	public Long getTotalCommission() {
		return this.totalCommission;
	}

	public void setTotalCommission(Long totalCommission) {
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

	@Column(name = "store_num")
	public Integer getStoreNum() {
		return this.storeNum;
	}

	public void setStoreNum(Integer storeNum) {
		this.storeNum = storeNum;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "failed_reason")
	public String getFailedReason() {
		return this.failedReason;
	}

	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}

}