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
 * GroupCommissionRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GroupCommissionRecord", schema = "dbo")
public class GroupCommissionRecord implements java.io.Serializable {

	// Fields

	private Integer gcrId;
	private BrokerTeam brokerTeam;
	private Broker broker;
	private Date commissionTime;
	private long commissionValue;

	// Constructors

	/** default constructor */
	public GroupCommissionRecord() {
	}

	/** full constructor */
	public GroupCommissionRecord(BrokerTeam brokerTeam, Broker broker,
			Date commissionTime, long commissionValue) {
		this.brokerTeam = brokerTeam;
		this.broker = broker;
		this.commissionTime = commissionTime;
		this.commissionValue = commissionValue;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "gcr_id", unique = true, nullable = false)
	public Integer getGcrId() {
		return this.gcrId;
	}

	public void setGcrId(Integer gcrId) {
		this.gcrId = gcrId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id")
	public BrokerTeam getBrokerTeam() {
		return this.brokerTeam;
	}

	public void setBrokerTeam(BrokerTeam brokerTeam) {
		this.brokerTeam = brokerTeam;
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
	@Column(name = "commission_time", length = 23)
	public Date getCommissionTime() {
		return this.commissionTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setCommissionTime(Date commissionTime) {
		this.commissionTime = commissionTime;
	}

	@Column(name = "commission_value", precision = 18, scale = 0)
	public long getCommissionValue() {
		return this.commissionValue;
	}

	public void setCommissionValue(long commissionValue) {
		this.commissionValue = commissionValue;
	}

}