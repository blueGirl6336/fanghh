// default package
package hitwh.fanghh.manage.pojo.building;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FourDoubleZeroPhone entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FourDoubleZeroPhone", schema = "dbo")
public class FourDoubleZeroPhone implements java.io.Serializable {

	// Fields

	private Integer castId;
	private String orginalPhoneNum;
	private String targetPhoneNum;
	private Boolean status;

	// Constructors

	/** default constructor */
	public FourDoubleZeroPhone() {
	}

	/** full constructor */
	public FourDoubleZeroPhone(String orginalPhoneNum, String targetPhoneNum) {
		this.orginalPhoneNum = orginalPhoneNum;
		this.targetPhoneNum = targetPhoneNum;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cast_id", unique = true, nullable = false)
	public Integer getCastId() {
		return this.castId;
	}

	public void setCastId(Integer castId) {
		this.castId = castId;
	}

	@Column(name = "orginal_phone_num")
	public String getOrginalPhoneNum() {
		return this.orginalPhoneNum;
	}

	public void setOrginalPhoneNum(String orginalPhoneNum) {
		this.orginalPhoneNum = orginalPhoneNum;
	}

	@Column(name = "target_phone_num")
	public String getTargetPhoneNum() {
		return this.targetPhoneNum;
	}

	public void setTargetPhoneNum(String targetPhoneNum) {
		this.targetPhoneNum = targetPhoneNum;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}