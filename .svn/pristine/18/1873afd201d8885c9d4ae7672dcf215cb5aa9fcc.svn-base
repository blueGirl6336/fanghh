// default package
package hitwh.fanghh.manage.pojo.building;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PerferentialRule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PerferentialRule", schema = "dbo")
public class PerferentialRule implements java.io.Serializable {

	// Fields

	private Integer ruleId;
	private String activityId;
	private String perferentialRuleType;
	private String discountRate;
	private long reducedPrice;
	private String perferentialDescription;

	// Constructors

	/** default constructor */
	public PerferentialRule() {
	}

	/** full constructor */
	public PerferentialRule(String activityId, String perferentialRuleType,
			String discountRate, long reducedPrice,
			String perferentialDescription) {
		this.activityId = activityId;
		this.perferentialRuleType = perferentialRuleType;
		this.discountRate = discountRate;
		this.reducedPrice = reducedPrice;
		this.perferentialDescription = perferentialDescription;
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

	@Column(name = "activity_id")
	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Column(name = "perferential_rule_type")
	public String getPerferentialRuleType() {
		return this.perferentialRuleType;
	}

	public void setPerferentialRuleType(String perferentialRuleType) {
		this.perferentialRuleType = perferentialRuleType;
	}

	@Column(name = "discount_rate")
	public String getDiscountRate() {
		return this.discountRate;
	}

	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}

	@Column(name = "reduced_price", precision = 18, scale = 0)
	public long getReducedPrice() {
		return this.reducedPrice;
	}

	public void setReducedPrice(long reducedPrice) {
		this.reducedPrice = reducedPrice;
	}

	@Column(name = "perferential_description")
	public String getPerferentialDescription() {
		return this.perferentialDescription;
	}

	public void setPerferentialDescription(String perferentialDescription) {
		this.perferentialDescription = perferentialDescription;
	}

}