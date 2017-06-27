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
 * CommissionRule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CommissionRule", schema = "dbo")
public class CommissionRule implements java.io.Serializable {

	// Fields

	private Integer ruleId;
	private Date createTime;
	private Double plateProportional;
	private Double teamLeaderProportion;
	private Double brokerLeaderProportional;
	private Double storeLeaderProportion;
	private String corporateRule;
	private Integer buildingId;
	private String ruleType;
	private String status;
	private Double regionProportional;

	// Constructors

	/** default constructor */
	public CommissionRule() {
	}

	/** minimal constructor */
	public CommissionRule(Integer ruleId) {
		this.ruleId = ruleId;
	}

	/** full constructor */
	public CommissionRule(Integer ruleId, Date createTime,
			Double plateProportional, Double teamLeaderProportion,
			Double brokerLeaderProportional, Double storeLeaderProportion,
			String corporateRule, Integer buildingId, String ruleType,
			String status, Double regionProportional) {
		this.ruleId = ruleId;
		this.createTime = createTime;
		this.plateProportional = plateProportional;
		this.teamLeaderProportion = teamLeaderProportion;
		this.brokerLeaderProportional = brokerLeaderProportional;
		this.storeLeaderProportion = storeLeaderProportion;
		this.corporateRule = corporateRule;
		this.buildingId = buildingId;
		this.ruleType = ruleType;
		this.status = status;
		this.regionProportional = regionProportional;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "rule_id", unique = true, nullable = false)
	public Integer getRuleId() {
		return this.ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 23)
	public Date getCreateTime() {
		return this.createTime;
	}

	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "plate_proportional", precision = 18, scale = 3)
	public Double getPlateProportional() {
		return this.plateProportional;
	}

	public void setPlateProportional(Double plateProportional) {
		this.plateProportional = plateProportional;
	}

	@Column(name = "team_leader_proportion", precision = 18, scale = 3)
	public Double getTeamLeaderProportion() {
		return this.teamLeaderProportion;
	}

	public void setTeamLeaderProportion(Double teamLeaderProportion) {
		this.teamLeaderProportion = teamLeaderProportion;
	}

	@Column(name = "broker_leader_proportional", precision = 18, scale = 3)
	public Double getBrokerLeaderProportional() {
		return this.brokerLeaderProportional;
	}

	public void setBrokerLeaderProportional(Double brokerLeaderProportional) {
		this.brokerLeaderProportional = brokerLeaderProportional;
	}

	@Column(name = "store_leader_proportion", precision = 18, scale = 3)
	public Double getStoreLeaderProportion() {
		return this.storeLeaderProportion;
	}

	public void setStoreLeaderProportion(Double storeLeaderProportion) {
		this.storeLeaderProportion = storeLeaderProportion;
	}

	@Column(name = "corporate_rule", length = 3550)
	public String getCorporateRule() {
		return this.corporateRule;
	}

	public void setCorporateRule(String corporateRule) {
		this.corporateRule = corporateRule;
	}

	@Column(name = "rule_type")
	public String getRuleType() {
		return this.ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "region_proportional", precision = 18, scale = 3)
	public Double getRegionProportional() {
		return this.regionProportional;
	}

	public void setRegionProportional(Double regionProportional) {
		this.regionProportional = regionProportional;
	}
	
	@Column(name = "building_id")
	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

}