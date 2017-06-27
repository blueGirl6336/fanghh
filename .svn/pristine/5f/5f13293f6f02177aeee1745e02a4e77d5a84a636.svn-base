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
 * BrokerCommentFromConsultant entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BrokerCommentFromConsultant", schema = "dbo")
public class BrokerCommentFromConsultant implements java.io.Serializable {

	// Fields

	private Integer bcfcId;
	private Broker broker;
	private HomeConsultant homeConsultant;
	private String orderId;
	private String entireComment;
	private Integer customerQualityComment;
	private Integer expertiseLevelComment;
	private String commentWriting;
	private Date commentTime;
	private String commentCheckStatus;
	private Date replyTime;
	private String replyContent;
	private String replyCheckStatus;

	// Constructors

	/** default constructor */
	public BrokerCommentFromConsultant() {
	}

	/** full constructor */
	public BrokerCommentFromConsultant(Broker broker,
			HomeConsultant homeConsultant, String orderId,
			String entireComment, Integer customerQualityComment,
			Integer expertiseLevelComment, String commentWriting,
			Date commentTime, String commentCheckStatus, Date replyTime,
			String replyContent, String replyCheckStatus) {
		this.broker = broker;
		this.homeConsultant = homeConsultant;
		this.orderId = orderId;
		this.entireComment = entireComment;
		this.customerQualityComment = customerQualityComment;
		this.expertiseLevelComment = expertiseLevelComment;
		this.commentWriting = commentWriting;
		this.commentTime = commentTime;
		this.commentCheckStatus = commentCheckStatus;
		this.replyTime = replyTime;
		this.replyContent = replyContent;
		this.replyCheckStatus = replyCheckStatus;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bcfc_id", unique = true, nullable = false)
	public Integer getBcfcId() {
		return this.bcfcId;
	}

	public void setBcfcId(Integer bcfcId) {
		this.bcfcId = bcfcId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "broker_id")
	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consultant_id")
	public HomeConsultant getHomeConsultant() {
		return this.homeConsultant;
	}

	public void setHomeConsultant(HomeConsultant homeConsultant) {
		this.homeConsultant = homeConsultant;
	}

	@Column(name = "order_id")
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Column(name = "entire_comment")
	public String getEntireComment() {
		return this.entireComment;
	}

	public void setEntireComment(String entireComment) {
		this.entireComment = entireComment;
	}

	@Column(name = "customer_quality_comment")
	public Integer getCustomerQualityComment() {
		return this.customerQualityComment;
	}

	public void setCustomerQualityComment(Integer customerQualityComment) {
		this.customerQualityComment = customerQualityComment;
	}

	@Column(name = "expertise_level_comment")
	public Integer getExpertiseLevelComment() {
		return this.expertiseLevelComment;
	}

	public void setExpertiseLevelComment(Integer expertiseLevelComment) {
		this.expertiseLevelComment = expertiseLevelComment;
	}

	@Column(name = "comment_writing")
	public String getCommentWriting() {
		return this.commentWriting;
	}

	public void setCommentWriting(String commentWriting) {
		this.commentWriting = commentWriting;
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

}