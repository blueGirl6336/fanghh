// default package
package hitwh.fanghh.manage.pojo.building;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * StrategyLabelCatg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "StrategyLabelCatg", schema = "dbo")
public class StrategyLabelCatg implements java.io.Serializable {

	// Fields

	private Integer id;
	private HousingStrategy housingStrategy;
	private String labelCode;

	// Constructors

	/** default constructor */
	public StrategyLabelCatg() {
	}

	/** full constructor */
	public StrategyLabelCatg(HousingStrategy housingStrategy, String labelCode) {
		this.housingStrategy = housingStrategy;
		this.labelCode = labelCode;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hs_id")
	public HousingStrategy getHousingStrategy() {
		return this.housingStrategy;
	}

	public void setHousingStrategy(HousingStrategy housingStrategy) {
		this.housingStrategy = housingStrategy;
	}

	@Column(name = "label_code")
	public String getLabelCode() {
		return this.labelCode;
	}

	public void setLabelCode(String labelCode) {
		this.labelCode = labelCode;
	}

}