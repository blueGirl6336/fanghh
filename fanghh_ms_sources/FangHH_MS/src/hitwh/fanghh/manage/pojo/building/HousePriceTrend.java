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
 * HousePriceTrend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HousePriceTrend", schema = "dbo")
public class HousePriceTrend implements java.io.Serializable {

	// Fields

	private Integer trendId;
	private Building building;
	private long currentPrice;
	private Date udpateTime;

	// Constructors

	/** default constructor */
	public HousePriceTrend() {
	}

	/** full constructor */
	public HousePriceTrend(Building building, long currentPrice, Date udpateTime) {
		this.building = building;
		this.currentPrice = currentPrice;
		this.udpateTime = udpateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "trend_id", unique = true, nullable = false)
	public Integer getTrendId() {
		return this.trendId;
	}

	public void setTrendId(Integer trendId) {
		this.trendId = trendId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "current_price", precision = 18, scale = 0)
	public long getCurrentPrice() {
		return this.currentPrice;
	}

	public void setCurrentPrice(long currentPrice) {
		this.currentPrice = currentPrice;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "udpate_time", length = 23)
	public Date getUdpateTime() {
		return this.udpateTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setUdpateTime(Date udpateTime) {
		this.udpateTime = udpateTime;
	}

}