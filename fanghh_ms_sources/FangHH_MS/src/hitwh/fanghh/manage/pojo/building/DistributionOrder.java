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
 * DistributionOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DistributionOrder", schema = "dbo")
public class DistributionOrder implements java.io.Serializable {

	// Fields

	private Integer doId;
	private Customer customer;
	private SalesDirector salesDirector;
	private HomeConsultant homeConsultant;
	private Date distributionTime;
	private Date removeDistributionDate;
	private boolean isRemoved;
	private String remark;

	// Constructors

	/** default constructor */
	public DistributionOrder() {
	}

	/** full constructor */
	public DistributionOrder(Customer customer, SalesDirector salesDirector,
			HomeConsultant homeConsultant, Date distributionTime,
			Date removeDistributionDate, boolean isRemoved, String remark) {
		this.customer = customer;
		this.salesDirector = salesDirector;
		this.homeConsultant = homeConsultant;
		this.distributionTime = distributionTime;
		this.removeDistributionDate = removeDistributionDate;
		this.isRemoved = isRemoved;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "do_id", unique = true, nullable = false)
	public Integer getDoId() {
		return this.doId;
	}

	public void setDoId(Integer doId) {
		this.doId = doId;
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
	@JoinColumn(name = "director_id")
	public SalesDirector getSalesDirector() {
		return this.salesDirector;
	}

	public void setSalesDirector(SalesDirector salesDirector) {
		this.salesDirector = salesDirector;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consultant_id")
	public HomeConsultant getHomeConsultant() {
		return this.homeConsultant;
	}

	public void setHomeConsultant(HomeConsultant homeConsultant) {
		this.homeConsultant = homeConsultant;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "distribution_time", length = 23)
	public Date getDistributionTime() {
		return this.distributionTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setDistributionTime(Date distributionTime) {
		this.distributionTime = distributionTime;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remove_distribution_date", length = 23)
	public Date getRemoveDistributionDate() {
		return this.removeDistributionDate;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setRemoveDistributionDate(Date removeDistributionDate) {
		this.removeDistributionDate = removeDistributionDate;
	}

	@Column(name = "is_removed")
	public boolean getIsRemoved() {
		return this.isRemoved;
	}

	public void setIsRemoved(boolean isRemoved) {
		this.isRemoved = isRemoved;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}