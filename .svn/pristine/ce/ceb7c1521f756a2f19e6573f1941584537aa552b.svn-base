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
 * ConsultantCustomerStatusRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ConsultantCustomerStatusRecord", schema = "dbo")
public class ConsultantCustomerStatusRecord implements java.io.Serializable {

	// Fields

	private Integer ccsrId;
	private ConsultantCustomer consultantCustomer;
	private String customerStatus;
	private String remark;
	private Date typeTime;

	// Constructors

	/** default constructor */
	public ConsultantCustomerStatusRecord() {
	}

	/** full constructor */
	public ConsultantCustomerStatusRecord(
			ConsultantCustomer consultantCustomer, String customerStatus,
			String remark, Date typeTime) {
		this.consultantCustomer = consultantCustomer;
		this.customerStatus = customerStatus;
		this.remark = remark;
		this.typeTime = typeTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ccsr_id", unique = true, nullable = false)
	public Integer getCcsrId() {
		return this.ccsrId;
	}

	public void setCcsrId(Integer ccsrId) {
		this.ccsrId = ccsrId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cc_id")
	public ConsultantCustomer getConsultantCustomer() {
		return this.consultantCustomer;
	}

	public void setConsultantCustomer(ConsultantCustomer consultantCustomer) {
		this.consultantCustomer = consultantCustomer;
	}

	@Column(name = "customer_status")
	public String getCustomerStatus() {
		return this.customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

}