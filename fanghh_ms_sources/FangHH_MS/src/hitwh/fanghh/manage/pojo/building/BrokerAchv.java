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
 * BrokerAchv entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BrokerAchv", schema = "dbo")
public class BrokerAchv implements java.io.Serializable {

	// Fields

	private Integer baId;
	private Broker broker;
	private Integer customerNum;
	private Integer dealNum;
	private long saleProfit;
	private long totalCommission;
	private Integer buildingNum;

	// Constructors

	/** default constructor */
	public BrokerAchv() {
	}

	/** full constructor */
	public BrokerAchv(Broker broker, Integer customerNum, Integer dealNum,
			long saleProfit, long totalCommission, Integer buildingNum) {
		this.broker = broker;
		this.customerNum = customerNum;
		this.dealNum = dealNum;
		this.saleProfit = saleProfit;
		this.totalCommission = totalCommission;
		this.buildingNum = buildingNum;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ba_id", unique = true, nullable = false)
	public Integer getBaId() {
		return this.baId;
	}

	public void setBaId(Integer baId) {
		this.baId = baId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "broker_id")
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

}