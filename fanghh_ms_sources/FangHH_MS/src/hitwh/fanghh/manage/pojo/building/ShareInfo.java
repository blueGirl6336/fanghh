// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.math.BigDecimal;
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
 * ShareInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ShareInfo", schema = "dbo")
public class ShareInfo implements java.io.Serializable {

	// Fields

	private Integer shareId;
	private Building building;
	private String title;
	private Date issueTime;
	private BigDecimal cashBack;
	private BigDecimal totalCash;
	private BigDecimal remainCash;
	/*private Set<ShareContent> shareContents = new HashSet<ShareContent>(0);
	private Set<ShareBack> shareBacks = new HashSet<ShareBack>(0);*/

	// Constructors

	/** default constructor */
	public ShareInfo() {
	}

	/** full constructor */
	public ShareInfo(Building building, String title, Date issueTime,
			BigDecimal cashBack,BigDecimal totalCash,BigDecimal remainCash) {
		this.building = building;
		this.title = title;
		this.issueTime = issueTime;
		this.cashBack = cashBack;
		this.totalCash = totalCash;
		this.remainCash = remainCash;
		/*this.shareContents = shareContents;
		this.shareBacks = shareBacks;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "share_id", unique = true, nullable = false)
	public Integer getShareId() {
		return this.shareId;
	}

	public void setShareId(Integer shareId) {
		this.shareId = shareId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "issue_time", length = 23)
	public Date getIssueTime() {
		return this.issueTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}

	@Column(name = "cash_back")
	public BigDecimal getCashBack() {
		return this.cashBack;
	}

	public void setCashBack(BigDecimal cashBack) {
		this.cashBack = cashBack;
	}
	@Column(name = "total_cash")
	public BigDecimal getTotalCash() {
		return this.totalCash;
	}

	public void setTotalCash(BigDecimal totalCash) {
		this.totalCash = totalCash;
	}
	@Column(name = "remain_cash")
	public BigDecimal getRemainCash() {
		return this.remainCash;
	}

	public void setRemainCash(BigDecimal remainCash) {
		this.remainCash = remainCash;
	}
/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shareInfo")
	public Set<ShareContent> getShareContents() {
		return this.shareContents;
	}

	public void setShareContents(Set<ShareContent> shareContents) {
		this.shareContents = shareContents;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shareInfo")
	public Set<ShareBack> getShareBacks() {
		return this.shareBacks;
	}

	public void setShareBacks(Set<ShareBack> shareBacks) {
		this.shareBacks = shareBacks;
	}
*/
}