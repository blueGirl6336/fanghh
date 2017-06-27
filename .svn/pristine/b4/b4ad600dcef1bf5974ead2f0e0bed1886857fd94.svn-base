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
 * ConsultantBuildingRel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ConsultantBuildingRel", schema = "dbo")
public class ConsultantBuildingRel implements java.io.Serializable {

	// Fields

	private Integer reId;
	private HomeConsultant homeConsultant;
	private Building building;
	private Date bindTime;
	private Date unbindTime;
	private boolean isUnbound;

	// Constructors

	/** default constructor */
	public ConsultantBuildingRel() {
	}

	/** full constructor */
	public ConsultantBuildingRel(HomeConsultant homeConsultant,
			Building building, Date bindTime, Date unbindTime, boolean isUnbound) {
		this.homeConsultant = homeConsultant;
		this.building = building;
		this.bindTime = bindTime;
		this.unbindTime = unbindTime;
		this.isUnbound = isUnbound;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "re_id", unique = true, nullable = false)
	public Integer getReId() {
		return this.reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
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
	@Column(name = "bind_time", length = 23)
	public Date getBindTime() {
		return this.bindTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setBindTime(Date bindTime) {
		this.bindTime = bindTime;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "unbind_time", length = 23)
	public Date getUnbindTime() {
		return this.unbindTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setUnbindTime(Date unbindTime) {
		this.unbindTime = unbindTime;
	}

	@Column(name = "is_unbound")
	public boolean getIsUnbound() {
		return this.isUnbound;
	}

	public void setIsUnbound(boolean isUnbound) {
		this.isUnbound = isUnbound;
	}

}