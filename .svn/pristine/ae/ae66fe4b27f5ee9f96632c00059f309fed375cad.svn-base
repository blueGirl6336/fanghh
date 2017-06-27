// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * ReservationOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ReservationOrder", schema = "dbo")
public class ReservationOrder implements java.io.Serializable {

	// Fields

	private Integer roId;
	private Customer customer;
	private House house;
	private String orderId;
	private Date reservationTime;
	private Integer reservationNum;
	private Date typeTime;
	private String reservationStatus;
	private boolean isMatched;
	private boolean isChecked;
	private boolean isDistributed;
	private String reservationSource;
	private String remark;

	// Constructors

	/** default constructor */
	public ReservationOrder() {
	}

	/** full constructor */
	public ReservationOrder(Customer customer, House house, String orderId,
			Date reservationTime, Integer reservationNum, Date typeTime,
			String reservationStatus, boolean isMatched, boolean isChecked,
			boolean isDistributed, String reservationSource, String remark) {
		this.customer = customer;
		this.house = house;
		this.orderId = orderId;
		this.reservationTime = reservationTime;
		this.reservationNum = reservationNum;
		this.typeTime = typeTime;
		this.reservationStatus = reservationStatus;
		this.isMatched = isMatched;
		this.isChecked = isChecked;
		this.isDistributed = isDistributed;
		this.reservationSource = reservationSource;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ro_id", unique = true, nullable = false)
	public Integer getRoId() {
		return this.roId;
	}

	public void setRoId(Integer roId) {
		this.roId = roId;
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
	@Column(name = "reservation_time", length = 23)
	public Date getReservationTime() {
		return this.reservationTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}

	@Column(name = "reservation_num")
	public Integer getReservationNum() {
		return this.reservationNum;
	}

	public void setReservationNum(Integer reservationNum) {
		this.reservationNum = reservationNum;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "type_time", length = 23)
	public Date getTypeTime() {
		return this.typeTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setTypeTime(Date typeTime) {
		this.typeTime = typeTime;
	}

	@Column(name = "reservation_status")
	public String getReservationStatus() {
		return this.reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	@Column(name = "is_matched")
	public boolean getIsMatched() {
		return this.isMatched;
	}

	public void setIsMatched(boolean isMatched) {
		this.isMatched = isMatched;
	}

	@Column(name = "is_checked")
	public boolean getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	@Column(name = "is_distributed")
	public boolean getIsDistributed() {
		return this.isDistributed;
	}

	public void setIsDistributed(boolean isDistributed) {
		this.isDistributed = isDistributed;
	}

	@Column(name = "reservation_source")
	public String getReservationSource() {
		return this.reservationSource;
	}

	public void setReservationSource(String reservationSource) {
		this.reservationSource = reservationSource;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}