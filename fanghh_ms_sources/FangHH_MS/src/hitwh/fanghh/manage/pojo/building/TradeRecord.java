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
 * TradeRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TradeRecord", schema = "dbo")
public class TradeRecord implements java.io.Serializable {

	// Fields

	private Integer tradeId;
	private Broker broker;
	private Date tradeTime;
	private String tradeCatg;
	private String tradeType;
	private String tradeObj;
	private long tradeMoney;

	// Constructors

	/** default constructor */
	public TradeRecord() {
	}

	/** full constructor */
	public TradeRecord(Broker broker, Date tradeTime, String tradeCatg,
			String tradeType, String tradeObj, long tradeMoney) {
		this.broker = broker;
		this.tradeTime = tradeTime;
		this.tradeCatg = tradeCatg;
		this.tradeType = tradeType;
		this.tradeObj = tradeObj;
		this.tradeMoney = tradeMoney;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "trade_id", unique = true, nullable = false)
	public Integer getTradeId() {
		return this.tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "broker_id")
	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "trade_time", length = 23)
	public Date getTradeTime() {
		return this.tradeTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	@Column(name = "trade_catg")
	public String getTradeCatg() {
		return this.tradeCatg;
	}

	public void setTradeCatg(String tradeCatg) {
		this.tradeCatg = tradeCatg;
	}

	@Column(name = "trade_type")
	public String getTradeType() {
		return this.tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	@Column(name = "trade_obj")
	public String getTradeObj() {
		return this.tradeObj;
	}

	public void setTradeObj(String tradeObj) {
		this.tradeObj = tradeObj;
	}

	@Column(name = "trade_money", precision = 18, scale = 0)
	public long getTradeMoney() {
		return this.tradeMoney;
	}

	public void setTradeMoney(long tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

}