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
 * SignationStatusRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SignationStatusRecord", schema = "dbo")
public class SignationStatusRecord implements java.io.Serializable {

	// Fields

	private Integer ssrId;
	private SaleOrder saleOrder;
	private String signationStatus;
	private long signationValue;
	private Date signationTime;
	private String typerId;

	// Constructors

	/** default constructor */
	public SignationStatusRecord() {
	}

	/** full constructor */
	public SignationStatusRecord(SaleOrder saleOrder, String signationStatus,
			long signationValue, Date signationTime, String typerId) {
		this.saleOrder = saleOrder;
		this.signationStatus = signationStatus;
		this.signationValue = signationValue;
		this.signationTime = signationTime;
		this.typerId = typerId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ssr_id", unique = true, nullable = false)
	public Integer getSsrId() {
		return this.ssrId;
	}

	public void setSsrId(Integer ssrId) {
		this.ssrId = ssrId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "so_id")
	public SaleOrder getSaleOrder() {
		return this.saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	@Column(name = "signation_status")
	public String getSignationStatus() {
		return this.signationStatus;
	}

	public void setSignationStatus(String signationStatus) {
		this.signationStatus = signationStatus;
	}

	@Column(name = "signation_value", precision = 18, scale = 0)
	public long getSignationValue() {
		return this.signationValue;
	}

	public void setSignationValue(long signationValue) {
		this.signationValue = signationValue;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "signation_time", length = 23)
	public Date getSignationTime() {
		return this.signationTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setSignationTime(Date signationTime) {
		this.signationTime = signationTime;
	}

	@Column(name = "typer_id")
	public String getTyperId() {
		return this.typerId;
	}

	public void setTyperId(String typerId) {
		this.typerId = typerId;
	}

}