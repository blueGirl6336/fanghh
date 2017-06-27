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
 * Voucher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Voucher", schema = "dbo")
public class Voucher implements java.io.Serializable {

	// Fields

	private Integer voucherId;
	private Broker broker;
	private long voucherValue;
	private String voucherStatus;
	private Date sendTime;
	private Integer duration;

	// Constructors

	/** default constructor */
	public Voucher() {
	}

	/** full constructor */
	public Voucher(Broker broker, long voucherValue, String voucherStatus,
			Date sendTime, Integer duration) {
		this.broker = broker;
		this.voucherValue = voucherValue;
		this.voucherStatus = voucherStatus;
		this.sendTime = sendTime;
		this.duration = duration;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "voucher_id", unique = true, nullable = false)
	public Integer getVoucherId() {
		return this.voucherId;
	}

	public void setVoucherId(Integer voucherId) {
		this.voucherId = voucherId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "broker_id")
	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	@Column(name = "voucher_value", precision = 18, scale = 0)
	public long getVoucherValue() {
		return this.voucherValue;
	}

	public void setVoucherValue(long voucherValue) {
		this.voucherValue = voucherValue;
	}

	@Column(name = "voucher_status")
	public String getVoucherStatus() {
		return this.voucherStatus;
	}

	public void setVoucherStatus(String voucherStatus) {
		this.voucherStatus = voucherStatus;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "send_time", length = 23)
	public Date getSendTime() {
		return this.sendTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}