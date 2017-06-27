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
 * AuthenticatedPic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AuthenticatedPic", schema = "dbo")
public class AuthenticatedPic implements java.io.Serializable {

	// Fields

	private Integer apId;
	private User user;
	private String realPic;
	private Date uploadTime;

	// Constructors

	/** default constructor */
	public AuthenticatedPic() {
	}

	/** full constructor */
	public AuthenticatedPic(User user, String realPic, Date uploadTime) {
		this.user = user;
		this.realPic = realPic;
		this.uploadTime = uploadTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ap_id", unique = true, nullable = false)
	public Integer getApId() {
		return this.apId;
	}

	public void setApId(Integer apId) {
		this.apId = apId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "real_pic")
	public String getRealPic() {
		return this.realPic;
	}

	public void setRealPic(String realPic) {
		this.realPic = realPic;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upload_time", length = 23)
	public Date getUploadTime() {
		return this.uploadTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}