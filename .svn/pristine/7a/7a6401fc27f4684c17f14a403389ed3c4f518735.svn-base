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
 * HousingStrategy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HousingStrategy", schema = "dbo")
public class HousingStrategy implements java.io.Serializable {

	// Fields

	private Integer hsId;
	private User user;
	private Building building;
	private String title;
	private Date issueTime;
	private Date visitTime;
	private Integer placardNum;
	private String strategyType;
	private Integer strategySort;
	private boolean isEssence;
	/*private Set<StrategyLabelCatg> strategyLabelCatgs = new HashSet<StrategyLabelCatg>(
			0);
	private Set<StrategyPlacard> strategyPlacards = new HashSet<StrategyPlacard>(
			0);
	private Set<StrategyContent> strategyContents = new HashSet<StrategyContent>(
			0);*/

	// Constructors

	/** default constructor */
	public HousingStrategy() {
	}

	/** full constructor */
	public HousingStrategy(User user, Building building, String title,
			Date issueTime, Date visitTime, Integer placardNum,
			String strategyType, Integer strategySort, boolean isEssence) {
		this.user = user;
		this.building = building;
		this.title = title;
		this.issueTime = issueTime;
		this.visitTime = visitTime;
		this.placardNum = placardNum;
		this.strategyType = strategyType;
		this.strategySort = strategySort;
		this.isEssence = isEssence;
		/*this.strategyLabelCatgs = strategyLabelCatgs;
		this.strategyPlacards = strategyPlacards;
		this.strategyContents = strategyContents;*/
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "hs_id", unique = true, nullable = false)
	public Integer getHsId() {
		return this.hsId;
	}

	public void setHsId(Integer hsId) {
		this.hsId = hsId;
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
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "visit_time", length = 23)
	public Date getVisitTime() {
		return this.visitTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	@Column(name = "placard_num")
	public Integer getPlacardNum() {
		return this.placardNum;
	}

	public void setPlacardNum(Integer placardNum) {
		this.placardNum = placardNum;
	}

	@Column(name = "strategy_type")
	public String getStrategyType() {
		return this.strategyType;
	}

	public void setStrategyType(String strategyType) {
		this.strategyType = strategyType;
	}

	@Column(name = "strategy_sort")
	public Integer getStrategySort() {
		return this.strategySort;
	}

	public void setStrategySort(Integer strategySort) {
		this.strategySort = strategySort;
	}

	@Column(name = "is_essence")
	public boolean getIsEssence() {
		return this.isEssence;
	}

	public void setIsEssence(boolean isEssence) {
		this.isEssence = isEssence;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "housingStrategy")
	public Set<StrategyLabelCatg> getStrategyLabelCatgs() {
		return this.strategyLabelCatgs;
	}

	public void setStrategyLabelCatgs(Set<StrategyLabelCatg> strategyLabelCatgs) {
		this.strategyLabelCatgs = strategyLabelCatgs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "housingStrategy")
	public Set<StrategyPlacard> getStrategyPlacards() {
		return this.strategyPlacards;
	}

	public void setStrategyPlacards(Set<StrategyPlacard> strategyPlacards) {
		this.strategyPlacards = strategyPlacards;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "housingStrategy")
	public Set<StrategyContent> getStrategyContents() {
		return this.strategyContents;
	}

	public void setStrategyContents(Set<StrategyContent> strategyContents) {
		this.strategyContents = strategyContents;
	}
*/
}