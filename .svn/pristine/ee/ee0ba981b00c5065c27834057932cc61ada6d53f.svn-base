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
 * BookingOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BookingOrder", schema = "dbo")
public class BookingOrder implements java.io.Serializable {

	// Fields

	private Integer boId;
	private Customer customer;
	private House house;
	private String orderId;
	private long predestinateValue;
	private Date predestinateTime;
	private String remark;

	// Constructors

	/** default constructor */
	public BookingOrder() {
	}

	/** full constructor */
	public BookingOrder(Customer customer, House house, String orderId,
			long predestinateValue, Date predestinateTime, String remark) {
		this.customer = customer;
		this.house = house;
		this.orderId = orderId;
		this.predestinateValue = predestinateValue;
		this.predestinateTime = predestinateTime;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bo_id", unique = true, nullable = false)
	public Integer getBoId() {
		return this.boId;
	}

	public void setBoId(Integer boId) {
		this.boId = boId;
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

	@Column(name = "predestinate_value", precision = 18, scale = 0)
	public long getPredestinateValue() {
		return this.predestinateValue;
	}

	public void setPredestinateValue(long predestinateValue) {
		this.predestinateValue = predestinateValue;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "predestinate_time", length = 23)
	public Date getPredestinateTime() {
		return this.predestinateTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setPredestinateTime(Date predestinateTime) {
		this.predestinateTime = predestinateTime;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}