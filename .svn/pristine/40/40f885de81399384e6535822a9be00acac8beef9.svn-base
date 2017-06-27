// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.pojo.User;
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
 * IntegralRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "IntegralRecord", schema = "dbo")
public class IntegralRecord implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private User user;
	private Integer integralNum;
	private Date time;
	private String operation;

	// Constructors

	/** default constructor */
	public IntegralRecord() {
	}

	/** full constructor */
	public IntegralRecord(User user, Integer integralNum, Date time,
			String operation) {
		this.user = user;
		this.integralNum = integralNum;
		this.time = time;
		this.operation = operation;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "record_id", unique = true, nullable = false)
	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "integral_num")
	public Integer getIntegralNum() {
		return this.integralNum;
	}

	public void setIntegralNum(Integer integralNum) {
		this.integralNum = integralNum;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", length = 23)
	public Date getTime() {
		return this.time;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "operation")
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}