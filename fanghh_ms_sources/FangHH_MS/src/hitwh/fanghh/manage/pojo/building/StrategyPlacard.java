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
 * StrategyPlacard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "StrategyPlacard", schema = "dbo")
public class StrategyPlacard implements java.io.Serializable {

	// Fields

	private Integer spId;
	private User users;
	private HousingStrategy housingStrategy;
	private Date placardTime;
	private String placardContent;
	private boolean checkStatus;
	private String checkOpinion;

	// Constructors

	/** default constructor */
	public StrategyPlacard() {
	}

	/** full constructor */
	public StrategyPlacard(User users, HousingStrategy housingStrategy,
			Date placardTime, String placardContent, boolean checkStatus,
			String checkOpinion) {
		this.users = users;
		this.housingStrategy = housingStrategy;
		this.placardTime = placardTime;
		this.placardContent = placardContent;
		this.checkStatus = checkStatus;
		this.checkOpinion = checkOpinion;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sp_id", unique = true, nullable = false)
	public Integer getSpId() {
		return this.spId;
	}

	public void setSpId(Integer spId) {
		this.spId = spId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUsers() {
		return this.users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hs_id")
	public HousingStrategy getHousingStrategy() {
		return this.housingStrategy;
	}

	public void setHousingStrategy(HousingStrategy housingStrategy) {
		this.housingStrategy = housingStrategy;
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