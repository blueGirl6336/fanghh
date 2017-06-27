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
 * OrderStatusRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "OrderStatusRecord", schema = "dbo")
public class OrderStatusRecord implements java.io.Serializable {

	// Fields

	private Integer osrId;
	private Customer customer;
	private Building building;
	private String orderId;
	private String orderStatus;
	private Date typeTime;
	private String remark;

	// Constructors

	/** default constructor */
	public OrderStatusRecord() {
	}

	/** full constructor */
	public OrderStatusRecord(Customer customer, Building building,
			String orderId, String orderStatus, Date typeTime, String remark) {
		this.customer = customer;
		this.building = building;
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.typeTime = typeTime;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "osr_id", unique = true, nullable = false)
	public Integer getOsrId() {
		return this.osrId;
	}

	public void setOsrId(Integer osrId) {
		this.osrId = osrId;
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
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "order_id")
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(name = "order_status")
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}