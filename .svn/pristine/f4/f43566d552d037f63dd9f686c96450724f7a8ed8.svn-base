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
 * TalksPlacard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TalksPlacard", schema = "dbo")
public class TalksPlacard implements java.io.Serializable {

	// Fields

	private Integer tpId;
	private PicTalk picTalk;
	private User user;
	private Date placardTime;
	private String placardContent;
	private boolean checkStatus;
	private String checkOpinion;

	// Constructors

	/** default constructor */
	public TalksPlacard() {
	}

	/** full constructor */
	public TalksPlacard(PicTalk picTalk, User user, Date placardTime,
			String placardContent, boolean checkStatus, String checkOpinion) {
		this.picTalk = picTalk;
		this.user = user;
		this.placardTime = placardTime;
		this.placardContent = placardContent;
		this.checkStatus = checkStatus;
		this.checkOpinion = checkOpinion;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "tp_id", unique = true, nullable = false)
	public Integer getTpId() {
		return this.tpId;
	}

	public void setTpId(Integer tpId) {
		this.tpId = tpId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pt_id")
	public PicTalk getPicTalk() {
		return this.picTalk;
	}

	public void setPicTalk(PicTalk picTalk) {
		this.picTalk = picTalk;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "placard_time", length = 23)
	public Date getPlacardTime() {
		return this.placardTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setPlacardTime(Date placardTime) {
		this.placardTime = placardTime;
	}

	@Column(name = "placard_content")
	public String getPlacardContent() {
		return this.placardContent;
	}

	public void setPlacardContent(String placardContent) {
		this.placardContent = placardContent;
	}

	@Column(name = "check_status")
	public boolean getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(boolean checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Column(name = "check_opinion")
	public String getCheckOpinion() {
		return this.checkOpinion;
	}

	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}

}