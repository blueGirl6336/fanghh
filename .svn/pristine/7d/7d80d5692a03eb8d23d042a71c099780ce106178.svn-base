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

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * PerferentialHouseList entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PerferentialHouseList", schema = "dbo")
public class PerferentialHouseList implements java.io.Serializable {

	// Fields

	private Integer phlId;
	private House house;
	private String activityId;
	private String childOrderId;
	private boolean isPurchased;
	private String childOrderStatus;

	// Constructors

	/** default constructor */
	public PerferentialHouseList() {
	}

	/** full constructor */
	public PerferentialHouseList(House house, String activityId,
			String childOrderId, boolean isPurchased, String childOrderStatus) {
		this.house = house;
		this.activityId = activityId;
		this.childOrderId = childOrderId;
		this.isPurchased = isPurchased;
		this.childOrderStatus = childOrderStatus;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "phl_id", unique = true, nullable = false)
	public Integer getPhlId() {
		return this.phlId;
	}

	public void setPhlId(Integer phlId) {
		this.phlId = phlId;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "house_id")
	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	
	@Transient
	public Integer getHouseId() {
		return this.house.getHouseId();
	}

	public void setHouseId(Integer houseId) {
		this.house.setHouseId(houseId);
	}
	
	@Transient
	public String getHouseNum() {
		return this.house.getHouseNum();
	}

	public void setHouseNum(String houseNum) {
		this.house.setHouseNum(houseNum);
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