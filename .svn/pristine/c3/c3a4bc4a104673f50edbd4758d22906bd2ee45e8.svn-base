// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * RecommendOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RecommendOrder", schema = "dbo")
public class RecommendOrder implements java.io.Serializable {

	// Fields

	private Integer roId;
	private Customer customer;
	private Broker broker;
	private House house;
	private String orderId;
	private Date recommendTime;
	private Integer areaDemand;
	private String propertyType;
	private Integer legalDuration;
	private boolean isMatched;
	private boolean isRelAgent;
	private boolean isChecked;
	private boolean isDistributed;
	private String remark;
	//private Set<HouseSourcePic> houseSourcePics = new HashSet<HouseSourcePic>(0);

	// Constructors

	/** default constructor */
	public RecommendOrder() {
	}

	/** full constructor */
	public RecommendOrder(Customer customer, Broker broker, House house,
			String orderId, Date recommendTime, Integer areaDemand,
			String propertyType, Integer legalDuration, boolean isMatched,
			boolean isRelAgent, boolean isChecked, boolean isDistributed,
			String remark) {
		this.customer = customer;
		this.broker = broker;
		this.house = house;
		this.orderId = orderId;
		this.recommendTime = recommendTime;
		this.areaDemand = areaDemand;
		this.propertyType = propertyType;
		this.legalDuration = legalDuration;
		this.isMatched = isMatched;
		this.isRelAgent = isRelAgent;
		this.isChecked = isChecked;
		this.isDistributed = isDistributed;
		this.remark = remark;
		//this.houseSourcePics = houseSourcePics;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ro_id", unique = true, nullable = false)
	public Integer getRoId() {
		return this.roId;
	}

	public void setRoId(Integer roId) {
		this.roId = roId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "broker_id")
	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "house_id")
	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	@Column(name = "order_id")
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "recommend_time", length = 23)
	public Date getRecommendTime() {
		return this.recommendTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setRecommendTime(Date recommendTime) {
		this.recommendTime = recommendTime;
	}

	@Column(name = "area_demand")
	public Integer getAreaDemand() {
		return this.areaDemand;
	}

	public void setAreaDemand(Integer areaDemand) {
		this.areaDemand = areaDemand;
	}

	@Column(name = "property_type")
	public String getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	@Column(name = "legal_duration")
	public Integer getLegalDuration() {
		return this.legalDuration;
	}

	public void setLegalDuration(Integer legalDuration) {
		this.legalDuration = legalDuration;
	}

	@Column(name = "is_matched")
	public boolean getIsMatched() {
		return this.isMatched;
	}

	public void setIsMatched(boolean isMatched) {
		this.isMatched = isMatched;
	}

	@Column(name = "is_rel_agent")
	public boolean getIsRelAgent() {
		return this.isRelAgent;
	}

	public void setIsRelAgent(boolean isRelAgent) {
		this.isRelAgent = isRelAgent;
	}

	@Column(name = "is_checked")
	public boolean getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	@Column(name = "is_distributed")
	public boolean getIsDistributed() {
		return this.isDistributed;
	}

	public void setIsDistributed(boolean isDistributed) {
		this.isDistributed = isDistributed;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recommendOrder")
	public Set<HouseSourcePic> getHouseSourcePics() {
		return this.houseSourcePics;
	}

	public void setHouseSourcePics(Set<HouseSourcePic> houseSourcePics) {
		this.houseSourcePics = houseSourcePics;
	}*/

}