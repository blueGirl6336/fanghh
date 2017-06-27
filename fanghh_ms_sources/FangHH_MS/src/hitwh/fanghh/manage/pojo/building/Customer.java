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
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Customer", schema = "dbo")
public class Customer implements java.io.Serializable {

	// Fields

	private Integer customerId;
	private String customerName;
	private String customerPhone;
	private String customerGender;
	private String customerSource;
	private String remark;
	/*private Set<SaleOrder> saleOrders = new HashSet<SaleOrder>(0);
	private Set<OrderStatusRecord> orderStatusRecords = new HashSet<OrderStatusRecord>(
			0);
	private Set<CustomerRemark> customerRemarks = new HashSet<CustomerRemark>(0);
	private Set<PredestinationInfo> predestinationInfos = new HashSet<PredestinationInfo>(
			0);
	private Set<DistributionOrder> distributionOrders = new HashSet<DistributionOrder>(
			0);
	private Set<BookingOrder> bookingOrders = new HashSet<BookingOrder>(0);
	private Set<RecommendOrder> recommendOrders = new HashSet<RecommendOrder>(0);
	private Set<ReservationOrder> reservationOrders = new HashSet<ReservationOrder>(
			0);
	private Set<HouseVisitRecord> houseVisitRecords = new HashSet<HouseVisitRecord>(
			0);*/

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String customerName, String customerPhone,
			String customerGender, String customerSource, String remark) {
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerGender = customerGender;
		this.customerSource = customerSource;
		this.remark = remark;
		/*this.saleOrders = saleOrders;
		this.orderStatusRecords = orderStatusRecords;
		this.customerRemarks = customerRemarks;
		this.predestinationInfos = predestinationInfos;
		this.distributionOrders = distributionOrders;
		this.bookingOrders = bookingOrders;
		this.recommendOrders = recommendOrders;
		this.reservationOrders = reservationOrders;
		this.houseVisitRecords = houseVisitRecords;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "customer_id", unique = true, nullable = false)
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "customer_name")
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "customer_phone")
	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Column(name = "customer_gender")
	public String getCustomerGender() {
		return this.customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	@Column(name = "customer_source")
	public String getCustomerSource() {
		return this.customerSource;
	}

	public void setCustomerSource(String customerSource) {
		this.customerSource = customerSource;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

/*	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<SaleOrder> getSaleOrders() {
		return this.saleOrders;
	}

	public void setSaleOrders(Set<SaleOrder> saleOrders) {
		this.saleOrders = saleOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<OrderStatusRecord> getOrderStatusRecords() {
		return this.orderStatusRecords;
	}

	public void setOrderStatusRecords(Set<OrderStatusRecord> orderStatusRecords) {
		this.orderStatusRecords = orderStatusRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<CustomerRemark> getCustomerRemarks() {
		return this.customerRemarks;
	}

	public void setCustomerRemarks(Set<CustomerRemark> customerRemarks) {
		this.customerRemarks = customerRemarks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<PredestinationInfo> getPredestinationInfos() {
		return this.predestinationInfos;
	}

	public void setPredestinationInfos(
			Set<PredestinationInfo> predestinationInfos) {
		this.predestinationInfos = predestinationInfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<DistributionOrder> getDistributionOrders() {
		return this.distributionOrders;
	}

	public void setDistributionOrders(Set<DistributionOrder> distributionOrders) {
		this.distributionOrders = distributionOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<BookingOrder> getBookingOrders() {
		return this.bookingOrders;
	}

	public void setBookingOrders(Set<BookingOrder> bookingOrders) {
		this.bookingOrders = bookingOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<RecommendOrder> getRecommendOrders() {
		return this.recommendOrders;
	}

	public void setRecommendOrders(Set<RecommendOrder> recommendOrders) {
		this.recommendOrders = recommendOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<ReservationOrder> getReservationOrders() {
		return this.reservationOrders;
	}

	public void setReservationOrders(Set<ReservationOrder> reservationOrders) {
		this.reservationOrders = reservationOrders;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<HouseVisitRecord> getHouseVisitRecords() {
		return this.houseVisitRecords;
	}

	public void setHouseVisitRecords(Set<HouseVisitRecord> houseVisitRecords) {
		this.houseVisitRecords = houseVisitRecords;
	}
*/
}