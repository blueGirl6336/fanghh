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
 * ConsultantMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ConsultantMessage", schema = "dbo")
public class ConsultantMessage implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private SalesDirector salesDirector;
	private HomeConsultant homeConsultant;
	private String messageTitle;
	private String messageContent;
	private String messageStatus;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public ConsultantMessage() {
	}

	/** full constructor */
	public ConsultantMessage(SalesDirector salesDirector,
			HomeConsultant homeConsultant, String messageTitle,
			String messageContent, String messageStatus, Date modifyTime) {
		this.salesDirector = salesDirector;
		this.homeConsultant = homeConsultant;
		this.messageTitle = messageTitle;
		this.messageContent = messageContent;
		this.messageStatus = messageStatus;
		this.modifyTime = modifyTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "message_id", unique = true, nullable = false)
	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "director_id")
	public SalesDirector getSalesDirector() {
		return this.salesDirector;
	}

	public void setSalesDirector(SalesDirector salesDirector) {
		this.salesDirector = salesDirector;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consultant_id")
	public HomeConsultant getHomeConsultant() {
		return this.homeConsultant;
	}

	public void setHomeConsultant(HomeConsultant homeConsultant) {
		this.homeConsultant = homeConsultant;
	}

	@Column(name = "message_title")
	public String getMessageTitle() {
		return this.messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	@Column(name = "message_content")
	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@Column(name = "message_status")
	public String getMessageStatus() {
		return this.messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_time", length = 23)
	public Date getModifyTime() {
		return this.modifyTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}