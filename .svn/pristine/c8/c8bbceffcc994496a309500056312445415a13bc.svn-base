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
 * BrokerCommissionRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BrokerCommissionRecord", schema = "dbo")
public class BrokerCommissionRecord implements java.io.Serializable {

	// Fields

	private Integer bcrId;
	private SaleOrder saleOrder;
	private Broker broker;
	private String commissionValue;
	private Date offerTime;

	// Constructors

	/** default constructor */
	public BrokerCommissionRecord() {
	}

	/** full constructor */
	public BrokerCommissionRecord(SaleOrder saleOrder, Broker broker,
			String commissionValue, Date offerTime) {
		this.saleOrder = saleOrder;
		this.broker = broker;
		this.commissionValue = commissionValue;
		this.offerTime = offerTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bcr_id", unique = true, nullable = false)
	public Integer getBcrId() {
		return this.bcrId;
	}

	public void setBcrId(Integer bcrId) {
		this.bcrId = bcrId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "so_id")
	public SaleOrder getSaleOrder() {
		return this.saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "broker_id")
	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	@Column(name = "commission_value")
	public String getCommissionValue() {
		return this.commissionValue;
	}

	public void setCommissionValue(String commissionValue) {
		this.commissionValue = commissionValue;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "offer_time", length = 23)
	public Date getOfferTime() {
		return this.offerTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setOfferTime(Date offerTime) {
		this.offerTime = offerTime;
	}

}