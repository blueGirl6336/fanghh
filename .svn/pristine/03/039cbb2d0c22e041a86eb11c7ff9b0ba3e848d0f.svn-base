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
 * RoofBeam entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "RoofBeam", schema = "dbo")
public class RoofBeam implements java.io.Serializable {

	// Fields
	// 楼栋ID
	private int roofId;
	// 所属楼盘
	private Building building;
	// 楼栋名称
	private String roofName;
	// 物业类型
	private String propertyType;
	// 楼栋结构
	private String roofStructer;
	// 楼栋高度
	private String roofHeight;
	// 朝向
	private String roofFace;
	// 最高层
	private int airFloors;
	// 最底层
	private int earthFloors;
	// 楼栋数
	private int roofNum;
	// 楼栋描述
	private String roofDesc;
	// 楼栋备注
	private String roofRemark;
	
	//private Set<Unit> units = new HashSet<Unit>(0);

	// Constructors

	/** default constructor */
	public RoofBeam() {
	}

	/** full constructor */
	public RoofBeam(Building building, String roofName, String propertyType,
			String roofStructer, String roofHeight, String roofFace,
			int airFloors, int earthFloors, int roofNum,
			String roofDesc, String roofRemark//, Set<Unit> units
			) {
		this.building= building;
		this.roofName = roofName;
		this.propertyType = propertyType;
		this.roofStructer = roofStructer;
		this.roofHeight = roofHeight;
		this.roofFace = roofFace;
		this.airFloors = airFloors;
		this.earthFloors = earthFloors;
		this.roofNum = roofNum;
		this.roofDesc = roofDesc;
		this.roofRemark = roofRemark;
		//this.units = units;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "roof_id", unique = true, nullable = false)
	public int getRoofId() {
		return this.roofId;
	}

	public void setRoofId(int roofId) {
		this.roofId = roofId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "roof_name")
	public String getRoofName() {
		return this.roofName;
	}

	public void setRoofName(String roofName) {
		this.roofName = roofName;
	}

	@Column(name = "property_type")
	public String getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	@Column(name = "roof_structer")
	public String getRoofStructer() {
		return this.roofStructer;
	}

	public void setRoofStructer(String roofStructer) {
		this.roofStructer = roofStructer;
	}

	@Column(name = "roof_height")
	public String getRoofHeight() {
		return this.roofHeight;
	}

	public void setRoofHeight(String roofHeight) {
		this.roofHeight = roofHeight;
	}

	@Column(name = "roof_face")
	public String getRoofFace() {
		return this.roofFace;
	}

	public void setRoofFace(String roofFace) {
		this.roofFace = roofFace;
	}

	@Column(name = "air_floors")
	public int getAirFloors() {
		return this.airFloors;
	}

	public void setAirFloors(int airFloors) {
		this.airFloors = airFloors;
	}

	@Column(name = "earth_floors")
	public int getEarthFloors() {
		return this.earthFloors;
	}

	public void setEarthFloors(int earthFloors) {
		this.earthFloors = earthFloors;
	}

	@Column(name = "roof_num")
	public int getRoofNum() {
		return this.roofNum;
	}

	public void setRoofNum(int roofNum) {
		this.roofNum = roofNum;
	}

	@Column(name = "roof_desc")
	public String getRoofDesc() {
		return this.roofDesc;
	}

	public void setRoofDesc(String roofDesc) {
		this.roofDesc = roofDesc;
	}

	@Column(name = "roof_remark")
	public String getRoofRemark() {
		return this.roofRemark;
	}

	public void setRoofRemark(String roofRemark) {
		this.roofRemark = roofRemark;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roofBeam")
	public Set<Unit> getUnits() {
		return this.units;
	}

	public void setUnits(Set<Unit> units) {
		this.units = units;
	}*/

}