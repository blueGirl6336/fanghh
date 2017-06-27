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
 * PredestinationInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PredestinationInfo", schema = "dbo")
public class PredestinationInfo implements java.io.Serializable {

	// Fields

	private Integer piId;
	private Customer customer;
	private String childOrderId;
	private String predestinationType;
	private Date predestinationTime;
	private long predestinationValue;
	private String predestinationStatus;

	// Constructors

	/** default constructor */
	public PredestinationInfo() {
	}

	/** full constructor */
	public PredestinationInfo(Customer customer, String childOrderId,
			String predestinationType, Date predestinationTime,
			long predestinationValue, String predestinationStatus) {
		this.customer = customer;
		this.childOrderId = childOrderId;
		this.predestinationType = predestinationType;
		this.predestinationTime = predestinationTime;
		this.predestinationValue = predestinationValue;
		this.predestinationStatus = predestinationStatus;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "pi_id", unique = true, nullable = false)
	public Integer getPiId() {
		return this.piId;
	}

	public void setPiId(Integer piId) {
		this.piId = piId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "child_order_id")
	public String getChildOrderId() {
		return this.childOrderId;
	}

	public void setChildOrderId(String childOrderId) {
		this.childOrderId = childOrderId;
	}

	@Column(name = "predestination_type")
	public String getPredestinationType() {
		return this.predestinationType;
	}

	public void setPredestinationType(String predestinationType) {
		this.predestinationType = predestinationType;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "predestination_time", length = 23)
	public Date getPredestinationTime() {
		return this.predestinationTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setPredestinationTime(Date predestinationTime) {
		this.predestinationTime = predestinationTime;
	}

	@Column(name = "predestination_value", precision = 18, scale = 0)
	public long getPredestinationValue() {
		return this.predestinationValue;
	}

	public void setPredestinationValue(long predestinationValue) {
		this.predestinationValue = predestinationValue;
	}

	@Column(name = "predestination_status")
	public String getPredestinationStatus() {
		return this.predestinationStatus;
	}

	public void setPredestinationStatus(String predestinationStatus) {
		this.predestinationStatus = predestinationStatus;
	}

}