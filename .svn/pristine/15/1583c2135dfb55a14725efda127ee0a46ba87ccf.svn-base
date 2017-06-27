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
 * StrategyContent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "StrategyContent", schema = "dbo")
public class StrategyContent implements java.io.Serializable {

	// Fields

	private Integer scId;
	private HousingStrategy housingStrategy;
	private String scPic;
	private String scWriting;

	// Constructors

	/** default constructor */
	public StrategyContent() {
	}

	/** full constructor */
	public StrategyContent(HousingStrategy housingStrategy, String scPic,
			String scWriting) {
		this.housingStrategy = housingStrategy;
		this.scPic = scPic;
		this.scWriting = scWriting;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sc_id", unique = true, nullable = false)
	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hs_id")
	public HousingStrategy getHousingStrategy() {
		return this.housingStrategy;
	}

	public void setHousingStrategy(HousingStrategy housingStrategy) {
		this.housingStrategy = housingStrategy;
	}

	@Column(name = "sc_pic")
	public String getScPic() {
		return this.scPic;
	}

	public void setScPic(String scPic) {
		this.scPic = scPic;
	}

	@Column(name = "sc_writing")
	public String getScWriting() {
		return this.scWriting;
	}

	public void setScWriting(String scWriting) {
		this.scWriting = scWriting;
	}

}