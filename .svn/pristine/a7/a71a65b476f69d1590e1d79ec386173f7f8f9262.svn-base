// default package
package hitwh.fanghh.manage.pojo.building;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * IntegralRule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "IntegralRule", schema = "dbo")
public class IntegralRule implements java.io.Serializable {

	// Fields

	private Integer ruleId;
	private String operationType;
	private Integer integralGained;

	// Constructors

	/** default constructor */
	public IntegralRule() {
	}

	/** full constructor */
	public IntegralRule(String operationType, Integer integralGained) {
		this.operationType = operationType;
		this.integralGained = integralGained;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "rule_id", unique = true, nullable = false)
	public Integer getRuleId() {
		return this.ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	@Column(name = "operation_type")
	public String getOperationType() {
		return this.operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Column(name = "integral_gained")
	public Integer getIntegralGained() {
		return this.integralGained;
	}

	public void setIntegralGained(Integer integralGained) {
		this.integralGained = integralGained;
	}

}