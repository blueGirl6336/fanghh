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
 * PushNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PushNews", schema = "dbo")
public class PushNews implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private Broker broker;
	private String newsType;
	private Integer typeId;
	private String newsTitle;
	private String newsContent;
	private Date sendTime;
	private String newsStatus;

	// Constructors

	/** default constructor */
	public PushNews() {
	}

	/** full constructor */
	public PushNews(Broker broker, String newsType, Integer typeId,
			String newsTitle, String newsContent, Date sendTime,
			String newsStatus) {
		this.broker = broker;
		this.newsType = newsType;
		this.typeId = typeId;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.sendTime = sendTime;
		this.newsStatus = newsStatus;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "news_id", unique = true, nullable = false)
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "broker_id")
	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	@Column(name = "news_type")
	public String getNewsType() {
		return this.newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	@Column(name = "type_id")
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "news_title")
	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	@Column(name = "news_content")
	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
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

	@Column(name = "news_status")
	public String getNewsStatus() {
		return this.newsStatus;
	}

	public void setNewsStatus(String newsStatus) {
		this.newsStatus = newsStatus;
	}

}