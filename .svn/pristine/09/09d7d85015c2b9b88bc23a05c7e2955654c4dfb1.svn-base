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
 * ShareBack entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ShareBack", schema = "dbo")
public class ShareBack implements java.io.Serializable {

	// Fields

	private Integer gpId;
	private User user;
	private ShareInfo shareInfo;
	private Date shareTime;

	// Constructors

	/** default constructor */
	public ShareBack() {
	}

	/** full constructor */
	public ShareBack(User user, ShareInfo shareInfo, Date shareTime) {
		this.user = user;
		this.shareInfo = shareInfo;
		this.shareTime = shareTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "gp_id", unique = true, nullable = false)
	public Integer getGpId() {
		return this.gpId;
	}

	public void setGpId(Integer gpId) {
		this.gpId = gpId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "share_id")
	public ShareInfo getShareInfo() {
		return this.shareInfo;
	}

	public void setShareInfo(ShareInfo shareInfo) {
		this.shareInfo = shareInfo;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "share_time", length = 23)
	public Date getShareTime() {
		return this.shareTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setShareTime(Date shareTime) {
		this.shareTime = shareTime;
	}

}