// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * StoreAchvRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "StoreAchvRecord", schema = "dbo")
public class StoreAchvRecord implements java.io.Serializable {

	// Fields

	private Integer barId;
	private Building building;
	private Store store;
	private Integer customerNum;
	private Integer dealNum;
	private long commission;
	private Date typeTime;
	private long saleProfit;

	// Constructors

	/** default constructor */
	public StoreAchvRecord() {
	}

	/** full constructor */
	public StoreAchvRecord(Building building, Store store, Integer customerNum,
			Integer dealNum, long commission, Date typeTime, long saleProfit) {
		this.building = building;
		this.store = store;
		this.customerNum = customerNum;
		this.dealNum = dealNum;
		this.commission = commission;
		this.typeTime = typeTime;
		this.saleProfit = saleProfit;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bar_id", unique = true, nullable = false)
	public Integer getBarId() {
		return this.barId;
	}

	public void setBarId(Integer barId) {
		this.barId = barId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "store_id")
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "customer_num")
	public Integer getCustomerNum() {
		return this.customerNum;
	}

	public void setCustomerNum(Integer customerNum) {
		this.customerNum = customerNum;
	}

	@Column(name = "deal_num")
	public Integer getDealNum() {
		return this.dealNum;
	}

	public void setDealNum(Integer dealNum) {
		this.dealNum = dealNum;
	}

	@Column(name = "commission", precision = 18, scale = 0)
	public long getCommission() {
		return this.commission;
	}

	public void setCommission(long commission) {
		this.commission = commission;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "type_time", length = 23)
	public Date getTypeTime() {
		return this.typeTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setTypeTime(Date typeTime) {
		this.typeTime = typeTime;
	}

	@Column(name = "sale_profit", precision = 18, scale = 0)
	public long getSaleProfit() {
		return this.saleProfit;
	}

	public void setSaleProfit(long saleProfit) {
		this.saleProfit = saleProfit;
	}

}