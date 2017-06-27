// default package
package hitwh.fanghh.manage.pojo.building;
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
 * PicTalk entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PicTalk", schema = "dbo")
public class PicTalk implements java.io.Serializable {

	// Fields

	private Integer ptId;
	private Building building;
	private String title;
	private Integer placardTimes;
	private Date issueTime;
	/*private Set<TalksPlacard> talksPlacards = new HashSet<TalksPlacard>(0);
	private Set<PicTalkContent> picTalkContents = new HashSet<PicTalkContent>(0);*/

	// Constructors

	/** default constructor */
	public PicTalk() {
	}

	/** full constructor */
	public PicTalk(Building building, String title, Integer placardTimes,
			Date issueTime) {
		this.building = building;
		this.title = title;
		this.placardTimes = placardTimes;
		this.issueTime = issueTime;
		/*this.talksPlacards = talksPlacards;
		this.picTalkContents = picTalkContents;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "pt_id", unique = true, nullable = false)
	public Integer getPtId() {
		return this.ptId;
	}

	public void setPtId(Integer ptId) {
		this.ptId = ptId;
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

	@Column(name = "placard_times")
	public Integer getPlacardTimes() {
		return this.placardTimes;
	}

	public void setPlacardTimes(Integer placardTimes) {
		this.placardTimes = placardTimes;
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

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "picTalk")
	public Set<TalksPlacard> getTalksPlacards() {
		return this.talksPlacards;
	}

	public void setTalksPlacards(Set<TalksPlacard> talksPlacards) {
		this.talksPlacards = talksPlacards;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "picTalk")
	public Set<PicTalkContent> getPicTalkContents() {
		return this.picTalkContents;
	}

	public void setPicTalkContents(Set<PicTalkContent> picTalkContents) {
		this.picTalkContents = picTalkContents;
	}*/

}