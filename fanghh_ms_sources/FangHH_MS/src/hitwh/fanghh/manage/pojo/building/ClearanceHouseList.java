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
import javax.persistence.Transient;

/**
 * ClearanceHouseList entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ClearanceHouseList", schema = "dbo")
public class ClearanceHouseList implements java.io.Serializable {

	// Fields

	private Integer chlId;
	private House house;
	private String houseNum;
	private String activityId;
	private String childOrderId;
	private boolean isPurchased;
	private String childOrderStatus;

	// Constructors

	/** default constructor */
	public ClearanceHouseList() {
	}

	/** full constructor */
	public ClearanceHouseList(House house, String activityId,
			String childOrderId, boolean isPurchased, String houseNum,String childOrderStatus) {
		this.house = house;
		this.activityId = activityId;
		this.childOrderId = childOrderId;
		this.isPurchased = isPurchased;
		this.houseNum = houseNum;
		this.childOrderStatus = childOrderStatus;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "chl_id", unique = true, nullable = false)
	public Integer getChlId() {
		return this.chlId;
	}

	public void setChlId(Integer chlId) {
		this.chlId = chlId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "house_id")
	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	@Transient
	public String getHouseNum() {
		return this.house.getHouseNum();
	}

	public void setHouseNum(String houseNum) {
		this.house.setHouseNum(houseNum);
	}

	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}

	@Column(name = "activity_id")
	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Column(name = "child_order_id")
	public String getChildOrderId() {
		return this.childOrderId;
	}

	public void setChildOrderId(String childOrderId) {
		this.childOrderId = childOrderId;
	}

	@Column(name = "is_purchased")
	public boolean getIsPurchased() {
		return this.isPurchased;
	}

	public void setIsPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}

	@Column(name = "child_order_status")
	public String getChildOrderStatus() {
		return this.childOrderStatus;
	}

	public void setChildOrderStatus(String childOrderStatus) {
		this.childOrderStatus = childOrderStatus;
	}

}