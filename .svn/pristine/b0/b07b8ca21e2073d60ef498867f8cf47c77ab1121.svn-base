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
 * ConsultantCustomer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ConsultantCustomer", schema = "dbo")
public class ConsultantCustomer implements java.io.Serializable {

	// Fields

	private Integer ccId;
	private HomeConsultant homeConsultant;
	private String customerName;
	private String customerPhone;
	private String customerGender;
	private String houseFavor;
	private Integer areaDemand;
	private Date typeTime;
	private String propertyType;
	private String remark;
	/*private Set<ConsultantCustomerStatusRecord> consultantCustomerStatusRecords = new HashSet<ConsultantCustomerStatusRecord>(
			0);*/

	// Constructors

	/** default constructor */
	public ConsultantCustomer() {
	}

	/** full constructor */
	public ConsultantCustomer(HomeConsultant homeConsultant,
			String customerName, String customerPhone, String customerGender,
			String houseFavor, Integer areaDemand, Date typeTime,
			String propertyType, String remark) {
		this.homeConsultant = homeConsultant;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerGender = customerGender;
		this.houseFavor = houseFavor;
		this.areaDemand = areaDemand;
		this.typeTime = typeTime;
		this.propertyType = propertyType;
		this.remark = remark;
		//this.consultantCustomerStatusRecords = consultantCustomerStatusRecords;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cc_id", unique = true, nullable = false)
	public Integer getCcId() {
		return this.ccId;
	}

	public void setCcId(Integer ccId) {
		this.ccId = ccId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consultant_id")
	public HomeConsultant getHomeConsultant() {
		return this.homeConsultant;
	}

	public void setHomeConsultant(HomeConsultant homeConsultant) {
		this.homeConsultant = homeConsultant;
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

	@Column(name = "house_favor")
	public String getHouseFavor() {
		return this.houseFavor;
	}

	public void setHouseFavor(String houseFavor) {
		this.houseFavor = houseFavor;
	}

	@Column(name = "area_demand")
	public Integer getAreaDemand() {
		return this.areaDemand;
	}

	public void setAreaDemand(Integer areaDemand) {
		this.areaDemand = areaDemand;
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

	@Column(name = "property_type")
	public String getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "consultantCustomer")
	public Set<ConsultantCustomerStatusRecord> getConsultantCustomerStatusRecords() {
		return this.consultantCustomerStatusRecords;
	}

	public void setConsultantCustomerStatusRecords(
			Set<ConsultantCustomerStatusRecord> consultantCustomerStatusRecords) {
		this.consultantCustomerStatusRecords = consultantCustomerStatusRecords;
	}*/

}