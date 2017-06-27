// default package
package hitwh.fanghh.manage.pojo.building;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DegreeAuthorityRule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DegreeAuthorityRule", schema = "dbo")
public class DegreeAuthorityRule implements java.io.Serializable {

	// Fields

	private Integer darId;
	private Integer degree;
	private Integer integralLimit;
	private Integer buildingNum;
	private Integer clientNum;

	// Constructors

	/** default constructor */
	public DegreeAuthorityRule() {
	}

	/** full constructor */
	public DegreeAuthorityRule(Integer degree, Integer integralLimit,
			Integer buildingNum, Integer clientNum) {
		this.degree = degree;
		this.integralLimit = integralLimit;
		this.buildingNum = buildingNum;
		this.clientNum = clientNum;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "dar_id", unique = true, nullable = false)
	public Integer getDarId() {
		return this.darId;
	}

	public void setDarId(Integer darId) {
		this.darId = darId;
	}

	@Column(name = "degree")
	public Integer getDegree() {
		return this.degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	@Column(name = "integral_limit")
	public Integer getIntegralLimit() {
		return this.integralLimit;
	}

	public void setIntegralLimit(Integer integralLimit) {
		this.integralLimit = integralLimit;
	}

	@Column(name = "building_num")
	public Integer getBuildingNum() {
		return this.buildingNum;
	}

	public void setBuildingNum(Integer buildingNum) {
		this.buildingNum = buildingNum;
	}

	@Column(name = "client_num")
	public Integer getClientNum() {
		return this.clientNum;
	}

	public void setClientNum(Integer clientNum) {
		this.clientNum = clientNum;
	}

}