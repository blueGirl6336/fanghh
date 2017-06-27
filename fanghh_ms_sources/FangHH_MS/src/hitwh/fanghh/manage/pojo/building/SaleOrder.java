// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * SaleOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SaleOrder", schema = "dbo")
public class SaleOrder implements java.io.Serializable {

	// Fields

	private Integer soId;
	private Customer customer;
	private House house;
	private String orderId;
	private Date receptionTime;
	private String orderStatus;
	private String remark;
	/*private Set<TransactionValueCheck> transactionValueChecks = new HashSet<TransactionValueCheck>(
			0);
	private Set<SignationStatusRecord> signationStatusRecords = new HashSet<SignationStatusRecord>(
			0);
	private Set<BrokerCommissionRecord> brokerCommissionRecords = new HashSet<BrokerCommissionRecord>(
			0);
*/
	// Constructors

	/** default constructor */
	public SaleOrder() {
	}

	/** full constructor */
	public SaleOrder(Customer customer, House house, String orderId,
			Date receptionTime, String orderStatus, String remark) {
		this.customer = customer;
		this.house = house;
		this.orderId = orderId;
		this.receptionTime = receptionTime;
		this.orderStatus = orderStatus;
		this.remark = remark;
		/*this.transactionValueChecks = transactionValueChecks;
		this.signationStatusRecords = signationStatusRecords;
		this.brokerCommissionRecords = brokerCommissionRecords;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "so_id", unique = true, nullable = false)
	public Integer getSoId() {
		return this.soId;
	}

	public void setSoId(Integer soId) {
		this.soId = soId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "house_id")
	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	@Column(name = "order_id")
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reception_time", length = 23)
	public Date getReceptionTime() {
		return this.receptionTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setReceptionTime(Date receptionTime) {
		this.receptionTime = receptionTime;
	}

	@Column(name = "order_status")
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOrder")
	public Set<TransactionValueCheck> getTransactionValueChecks() {
		return this.transactionValueChecks;
	}

	public void setTransactionValueChecks(
			Set<TransactionValueCheck> transactionValueChecks) {
		this.transactionValueChecks = transactionValueChecks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOrder")
	public Set<SignationStatusRecord> getSignationStatusRecords() {
		return this.signationStatusRecords;
	}

	public void setSignationStatusRecords(
			Set<SignationStatusRecord> signationStatusRecords) {
		this.signationStatusRecords = signationStatusRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleOrder")
	public Set<BrokerCommissionRecord> getBrokerCommissionRecords() {
		return this.brokerCommissionRecords;
	}

	public void setBrokerCommissionRecords(
			Set<BrokerCommissionRecord> brokerCommissionRecords) {
		this.brokerCommissionRecords = brokerCommissionRecords;
	}*/

}