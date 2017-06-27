// default package
package hitwh.fanghh.manage.pojo.building;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SurroundFacility entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SurroundFacility", schema = "dbo")
public class SurroundFacility implements java.io.Serializable {

	// Fields

	private Integer sfId;
	private Building building;
	private String busStation;
	private String school;
	private String hospital;
	private String bank;
	private String entertainment;
	private String shopping;
	private String repast;
	private String exercise;

	// Constructors

	/** default constructor */
	public SurroundFacility() {
	}

	/** full constructor */
	public SurroundFacility(Building building, String busStation,
			String school, String hospital, String bank, String entertainment,
			String shopping, String repast, String exercise) {
		this.building = building;
		this.busStation = busStation;
		this.school = school;
		this.hospital = hospital;
		this.bank = bank;
		this.entertainment = entertainment;
		this.shopping = shopping;
		this.repast = repast;
		this.exercise = exercise;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sf_id", unique = true, nullable = false)
	public Integer getSfId() {
		return this.sfId;
	}

	public void setSfId(Integer sfId) {
		this.sfId = sfId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "busStation", length = 50)
	public String getBusStation() {
		return this.busStation;
	}

	public void setBusStation(String busStation) {
		this.busStation = busStation;
	}

	@Column(name = "school", length = 50)
	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(name = "hospital", length = 50)
	public String getHospital() {
		return this.hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Column(name = "bank", length = 50)
	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "entertainment", length = 50)
	public String getEntertainment() {
		return this.entertainment;
	}

	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}

	@Column(name = "shopping", length = 50)
	public String getShopping() {
		return this.shopping;
	}

	public void setShopping(String shopping) {
		this.shopping = shopping;
	}

	@Column(name = "repast", length = 50)
	public String getRepast() {
		return this.repast;
	}

	public void setRepast(String repast) {
		this.repast = repast;
	}

	@Column(name = "exercise", length = 50)
	public String getExercise() {
		return this.exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

}