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
 * HouseVisitRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HouseVisitRecord", schema = "dbo")
public class HouseVisitRecord implements java.io.Serializable {

	// Fields

	private Integer hvrId;
	private Customer customer;
	private String orderId;
	private Date admitTime;
	private String houseVisited;
	private String visitStatus;
	private String remark;

	// Constructors

	/** default constructor */
	public HouseVisitRecord() {
	}

	/** full constructor */
	public HouseVisitRecord(Customer customer, String orderId, Date admitTime,
			String houseVisited, String visitStatus, String remark) {
		this.customer = customer;
		this.orderId = orderId;
		this.admitTime = admitTime;
		this.houseVisited = houseVisited;
		this.visitStatus = visitStatus;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "hvr_id", unique = true, nullable = false)
	public Integer getHvrId() {
		return this.hvrId;
	}

	public void setHvrId(Integer hvrId) {
		this.hvrId = hvrId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	@Column(name = "admit_time", length = 23)
	public Date getAdmitTime() {
		return this.admitTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setAdmitTime(Date admitTime) {
		this.admitTime = admitTime;
	}

	@Column(name = "house_visited")
	public String getHouseVisited() {
		return this.houseVisited;
	}

	public void setHouseVisited(String houseVisited) {
		this.houseVisited = houseVisited;
	}

	@Column(name = "visit_status")
	public String getVisitStatus() {
		return this.visitStatus;
	}

	public void setVisitStatus(String visitStatus) {
		this.visitStatus = visitStatus;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}