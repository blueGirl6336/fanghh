// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * BuildingComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BuildingComment", schema = "dbo")
public class BuildingComment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private User user;
	private HomeConsultant homeConsultant;
	private Building building;
	private Date commentTime;
	private Integer entireComment;
	private Integer priceComment;
	private Integer locationComment;
	private Integer facilitiesComment;
	private Integer trafficComment;
	private Integer environmentComment;
	private String commentWriting;
	private String commentCatg;
	private Date catgSettingTime;
	private String commentCheckStatus;
	private Date replyTime;
	private String replyContent;
	private String replyCheckStatus;
	private boolean isEssence;
	//private Set<CommentPic> commentPics = new HashSet<CommentPic>(0);

	// Constructors

	/** default constructor */
	public BuildingComment() {
	}

	/** full constructor */
	public BuildingComment(User user, HomeConsultant homeConsultant,
			Building building, Date commentTime, Integer entireComment,
			Integer priceComment, Integer locationComment,
			Integer facilitiesComment, Integer trafficComment,
			Integer environmentComment, String commentWriting,
			String commentCatg, Date catgSettingTime,
			String commentCheckStatus, Date replyTime, String replyContent,
			String replyCheckStatus, boolean isEssence
			) {
		this.user = user;
		this.homeConsultant = homeConsultant;
		this.building = building;
		this.commentTime = commentTime;
		this.entireComment = entireComment;
		this.priceComment = priceComment;
		this.locationComment = locationComment;
		this.facilitiesComment = facilitiesComment;
		this.trafficComment = trafficComment;
		this.environmentComment = environmentComment;
		this.commentWriting = commentWriting;
		this.commentCatg = commentCatg;
		this.catgSettingTime = catgSettingTime;
		this.commentCheckStatus = commentCheckStatus;
		this.replyTime = replyTime;
		this.replyContent = replyContent;
		this.replyCheckStatus = replyCheckStatus;
		this.isEssence = isEssence;
		//this.commentPics = commentPics;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "comment_id", unique = true, nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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
	@JoinColumn(name = "consultant_id")
	public HomeConsultant getHomeConsultant() {
		return this.homeConsultant;
	}

	public void setHomeConsultant(HomeConsultant homeConsultant) {
		this.homeConsultant = homeConsultant;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "comment_time", length = 23)
	public Date getCommentTime() {
		return this.commentTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	@Column(name = "entire_comment")
	public Integer getEntireComment() {
		return this.entireComment;
	}

	public void setEntireComment(Integer entireComment) {
		this.entireComment = entireComment;
	}

	@Column(name = "price_comment")
	public Integer getPriceComment() {
		return this.priceComment;
	}

	public void setPriceComment(Integer priceComment) {
		this.priceComment = priceComment;
	}

	@Column(name = "location_comment")
	public Integer getLocationComment() {
		return this.locationComment;
	}

	public void setLocationComment(Integer locationComment) {
		this.locationComment = locationComment;
	}

	@Column(name = "facilities_comment")
	public Integer getFacilitiesComment() {
		return this.facilitiesComment;
	}

	public void setFacilitiesComment(Integer facilitiesComment) {
		this.facilitiesComment = facilitiesComment;
	}

	@Column(name = "traffic_comment")
	public Integer getTrafficComment() {
		return this.trafficComment;
	}

	public void setTrafficComment(Integer trafficComment) {
		this.trafficComment = trafficComment;
	}

	@Column(name = "environment_comment")
	public Integer getEnvironmentComment() {
		return this.environmentComment;
	}

	public void setEnvironmentComment(Integer environmentComment) {
		this.environmentComment = environmentComment;
	}

	@Column(name = "comment_writing")
	public String getCommentWriting() {
		return this.commentWriting;
	}

	public void setCommentWriting(String commentWriting) {
		this.commentWriting = commentWriting;
	}

	@Column(name = "comment_catg")
	public String getCommentCatg() {
		return this.commentCatg;
	}

	public void setCommentCatg(String commentCatg) {
		this.commentCatg = commentCatg;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "catg_setting_time", length = 23)
	public Date getCatgSettingTime() {
		return this.catgSettingTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setCatgSettingTime(Date catgSettingTime) {
		this.catgSettingTime = catgSettingTime;
	}

	@Column(name = "comment_check_status")
	public String getCommentCheckStatus() {
		return this.commentCheckStatus;
	}

	public void setCommentCheckStatus(String commentCheckStatus) {
		this.commentCheckStatus = commentCheckStatus;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "reply_time", length = 23)
	public Date getReplyTime() {
		return this.replyTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	@Column(name = "reply_content")
	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Column(name = "reply_check_status")
	public String getReplyCheckStatus() {
		return this.replyCheckStatus;
	}

	public void setReplyCheckStatus(String replyCheckStatus) {
		this.replyCheckStatus = replyCheckStatus;
	}

	@Column(name = "is_essence")
	public boolean getIsEssence() {
		return this.isEssence;
	}

	public void setIsEssence(boolean isEssence) {
		this.isEssence = isEssence;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buildingComment")
	public Set<CommentPic> getCommentPics() {
		return this.commentPics;
	}

	public void setCommentPics(Set<CommentPic> commentPics) {
		this.commentPics = commentPics;
	}*/

}