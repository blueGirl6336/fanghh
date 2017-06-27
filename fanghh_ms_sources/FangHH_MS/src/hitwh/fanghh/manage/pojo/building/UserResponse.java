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
 * UserResponse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "UserResponse", schema = "dbo")
public class UserResponse implements java.io.Serializable {

	// Fields

	private Integer responseId;
	private User user;
	private String responseInfo;
	private Date responseTime;

	// Constructors

	/** default constructor */
	public UserResponse() {
	}

	/** full constructor */
	public UserResponse(User user, String responseInfo, Date responseTime) {
		this.user = user;
		this.responseInfo = responseInfo;
		this.responseTime = responseTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "response_id", unique = true, nullable = false)
	public Integer getResponseId() {
		return this.responseId;
	}

	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "response_info")
	public String getResponseInfo() {
		return this.responseInfo;
	}

	public void setResponseInfo(String responseInfo) {
		this.responseInfo = responseInfo;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "response_time", length = 23)
	public Date getResponseTime() {
		return this.responseTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

}