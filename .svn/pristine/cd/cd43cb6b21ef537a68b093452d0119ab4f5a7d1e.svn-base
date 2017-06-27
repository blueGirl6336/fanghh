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
 * GroupPurchaseHouseList entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GroupPurchaseHouseList", schema = "dbo")
public class GroupPurchaseHouseList implements java.io.Serializable {

	// Fields

	private Integer gphId;
	private House house;
	private String houseName;
	private String childOrderId;
	private boolean isPurchased;
	private String childOrderStatus;
	private String activityId;

	// Constructors

	/** default constructor */
	public GroupPurchaseHouseList() {
	}

	/** full constructor */
	public GroupPurchaseHouseList(House house, String childOrderId,
			boolean isPurchased, String childOrderStatus, String activityId) {
		this.house = house;
		this.childOrderId = childOrderId;
		this.isPurchased = isPurchased;
		this.childOrderStatus = childOrderStatus;
		this.activityId = activityId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "gph_id", unique = true, nullable = false)
	public Integer getGphId() {
		return this.gphId;
	}

	public void setGphId(Integer gphId) {
		this.gphId = gphId;
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
	public String getHouseName() {
		return this.getHouse().getHouseNum();
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
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

	@Column(name = "activity_id")
	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

}