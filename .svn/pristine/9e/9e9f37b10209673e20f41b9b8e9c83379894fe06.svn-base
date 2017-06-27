// default package
package hitwh.fanghh.manage.pojo.building;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Developer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Developer", schema = "dbo")
public class Developer implements java.io.Serializable {

	// Fields

	private Integer developerId;
	private String developName;
	private String developAddr;
	private String businessLicense;
	private String qualLevel;
	private String legalPerson;
	private String personPosition;
	private String brokerIdcard;
	private String relationPhone;
	private String zipCode;
	private String email;
	private String remark;

	// Constructors

	/** default constructor */
	public Developer() {
	}

	/** full constructor */
	public Developer(String developName, String developAddr,
			String businessLicense, String qualLevel, String legalPerson,
			String personPosition, String brokerIdcard, String relationPhone,
			String zipCode, String email, String remark) {
		this.developName = developName;
		this.developAddr = developAddr;
		this.businessLicense = businessLicense;
		this.qualLevel = qualLevel;
		this.legalPerson = legalPerson;
		this.personPosition = personPosition;
		this.brokerIdcard = brokerIdcard;
		this.relationPhone = relationPhone;
		this.zipCode = zipCode;
		this.email = email;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "developer_id", unique = true, nullable = false)
	public Integer getDeveloperId() {
		return this.developerId;
	}

	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}

	@Column(name = "develop_name")
	public String getDevelopName() {
		return this.developName;
	}

	public void setDevelopName(String developName) {
		this.developName = developName;
	}

	@Column(name = "develop_addr")
	public String getDevelopAddr() {
		return this.developAddr;
	}

	public void setDevelopAddr(String developAddr) {
		this.developAddr = developAddr;
	}

	@Column(name = "business_license")
	public String getBusinessLicense() {
		return this.businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	@Column(name = "qual_level")
	public String getQualLevel() {
		return this.qualLevel;
	}

	public void setQualLevel(String qualLevel) {
		this.qualLevel = qualLevel;
	}

	@Column(name = "legal_person")
	public String getLegalPerson() {
		return this.legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	@Column(name = "person_position")
	public String getPersonPosition() {
		return this.personPosition;
	}

	public void setPersonPosition(String personPosition) {
		this.personPosition = personPosition;
	}

	@Column(name = "broker_idcard")
	public String getBrokerIdcard() {
		return this.brokerIdcard;
	}

	public void setBrokerIdcard(String brokerIdcard) {
		this.brokerIdcard = brokerIdcard;
	}

	@Column(name = "relation_phone")
	public String getRelationPhone() {
		return this.relationPhone;
	}

	public void setRelationPhone(String relationPhone) {
		this.relationPhone = relationPhone;
	}

	@Column(name = "zipCode")
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}