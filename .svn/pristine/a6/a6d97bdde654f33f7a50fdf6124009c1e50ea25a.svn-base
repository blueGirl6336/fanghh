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
 * HomeConsultantAchv entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HomeConsultantAchv", schema = "dbo")
public class HomeConsultantAchv implements java.io.Serializable {

	// Fields

	private Integer hcaId;
	private HomeConsultant homeConsultant;
	private Integer customerNum;
	private Integer signationNum;
	private long salesVolum;

	// Constructors

	/** default constructor */
	public HomeConsultantAchv() {
	}

	/** full constructor */
	public HomeConsultantAchv(HomeConsultant homeConsultant,
			Integer customerNum, Integer signationNum, long salesVolum) {
		this.homeConsultant = homeConsultant;
		this.customerNum = customerNum;
		this.signationNum = signationNum;
		this.salesVolum = salesVolum;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "hca_id", unique = true, nullable = false)
	public Integer getHcaId() {
		return this.hcaId;
	}

	public void setHcaId(Integer hcaId) {
		this.hcaId = hcaId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consultant_id")
	public HomeConsultant getHomeConsultant() {
		return this.homeConsultant;
	}

	public void setHomeConsultant(HomeConsultant homeConsultant) {
		this.homeConsultant = homeConsultant;
	}

	@Column(name = "customer_num")
	public Integer getCustomerNum() {
		return this.customerNum;
	}

	public void setCustomerNum(Integer customerNum) {
		this.customerNum = customerNum;
	}

	@Column(name = "signation_num")
	public Integer getSignationNum() {
		return this.signationNum;
	}

	public void setSignationNum(Integer signationNum) {
		this.signationNum = signationNum;
	}

	@Column(name = "sales_volum", precision = 18, scale = 0)
	public long getSalesVolum() {
		return this.salesVolum;
	}

	public void setSalesVolum(long salesVolum) {
		this.salesVolum = salesVolum;
	}

}