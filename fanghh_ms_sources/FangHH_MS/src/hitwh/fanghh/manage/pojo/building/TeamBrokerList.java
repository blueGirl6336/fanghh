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
 * TeamBrokerList entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TeamBrokerList", schema = "dbo")
public class TeamBrokerList implements java.io.Serializable {

	// Fields

	private Integer id;
	private BrokerTeam brokerTeam;
	private Broker broker;
	private Date joinTime;

	// Constructors

	/** default constructor */
	public TeamBrokerList() {
	}

	/** full constructor */
	public TeamBrokerList(BrokerTeam brokerTeam, Broker broker, Date joinTime) {
		this.brokerTeam = brokerTeam;
		this.broker = broker;
		this.joinTime = joinTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	@Column(name = "join_time", length = 23)
	public Date getJoinTime() {
		return this.joinTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

}