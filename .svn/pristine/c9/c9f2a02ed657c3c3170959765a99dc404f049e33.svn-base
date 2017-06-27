// default package
package hitwh.fanghh.manage.pojo.building;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * InvitationCode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "InvitationCode", schema = "dbo")
public class InvitationCode implements java.io.Serializable {

	// Fields

	private Integer icId;
	private String invitationCode;
	private Integer useTimes;
	private String ownerType;
	private Integer ownerId;
	private Integer usedTimes;

	// Constructors

	/** default constructor */
	public InvitationCode() {
	}

	/** full constructor */
	public InvitationCode(String invitationCode, Integer useTimes,
			String ownerType, Integer ownerId, Integer usedTimes) {
		this.invitationCode = invitationCode;
		this.useTimes = useTimes;
		this.ownerType = ownerType;
		this.ownerId = ownerId;
		this.usedTimes = usedTimes;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ic_id", unique = true, nullable = false)
	public Integer getIcId() {
		return this.icId;
	}

	public void setIcId(Integer icId) {
		this.icId = icId;
	}

	@Column(name = "invitation_code")
	public String getInvitationCode() {
		return this.invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	@Column(name = "use_times")
	public Integer getUseTimes() {
		return this.useTimes;
	}

	public void setUseTimes(Integer useTimes) {
		this.useTimes = useTimes;
	}

	@Column(name = "owner_type")
	public String getOwnerType() {
		return this.ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	@Column(name = "owner_id")
	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	@Column(name = "used_times")
	public Integer getUsedTimes() {
		return this.usedTimes;
	}

	public void setUsedTimes(Integer usedTimes) {
		this.usedTimes = usedTimes;
	}

}