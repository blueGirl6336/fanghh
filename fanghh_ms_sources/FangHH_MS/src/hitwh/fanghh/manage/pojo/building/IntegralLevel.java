// default package
package hitwh.fanghh.manage.pojo.building;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * IntegralLevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "IntegralLevel", schema = "dbo")
public class IntegralLevel implements java.io.Serializable {

	// Fields

	private Integer ilId;
	private Integer userLevel;
	private Integer lowestStandard;
	private Integer highestStandard;

	// Constructors

	/** default constructor */
	public IntegralLevel() {
	}

	/** full constructor */
	public IntegralLevel(Integer userLevel, Integer lowestStandard,
			Integer highestStandard) {
		this.userLevel = userLevel;
		this.lowestStandard = lowestStandard;
		this.highestStandard = highestStandard;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "il_id", unique = true, nullable = false)
	public Integer getIlId() {
		return this.ilId;
	}

	public void setIlId(Integer ilId) {
		this.ilId = ilId;
	}

	@Column(name = "user_level")
	public Integer getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	@Column(name = "lowest_standard")
	public Integer getLowestStandard() {
		return this.lowestStandard;
	}

	public void setLowestStandard(Integer lowestStandard) {
		this.lowestStandard = lowestStandard;
	}

	@Column(name = "highest_standard")
	public Integer getHighestStandard() {
		return this.highestStandard;
	}

	public void setHighestStandard(Integer highestStandard) {
		this.highestStandard = highestStandard;
	}

}