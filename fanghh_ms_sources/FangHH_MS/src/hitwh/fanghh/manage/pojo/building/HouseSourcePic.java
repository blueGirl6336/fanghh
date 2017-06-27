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
 * HouseSourcePic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HouseSourcePic", schema = "dbo")
public class HouseSourcePic implements java.io.Serializable {

	// Fields

	private Integer hspId;
	private RecommendOrder recommendOrder;
	private String hsPic;

	// Constructors

	/** default constructor */
	public HouseSourcePic() {
	}

	/** full constructor */
	public HouseSourcePic(RecommendOrder recommendOrder, String hsPic) {
		this.recommendOrder = recommendOrder;
		this.hsPic = hsPic;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "hsp_id", unique = true, nullable = false)
	public Integer getHspId() {
		return this.hspId;
	}

	public void setHspId(Integer hspId) {
		this.hspId = hspId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ro_id")
	public RecommendOrder getRecommendOrder() {
		return this.recommendOrder;
	}

	public void setRecommendOrder(RecommendOrder recommendOrder) {
		this.recommendOrder = recommendOrder;
	}

	@Column(name = "hs_pic")
	public String getHsPic() {
		return this.hsPic;
	}

	public void setHsPic(String hsPic) {
		this.hsPic = hsPic;
	}

}