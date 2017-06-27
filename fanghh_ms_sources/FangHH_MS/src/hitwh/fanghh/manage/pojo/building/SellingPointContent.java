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
 * SellingPointContent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SellingPointContent", schema = "dbo")
public class SellingPointContent implements java.io.Serializable {

	// Fields

	private Integer spcId;
	private BuildingSellingPoint buildingSellingPoint;
	private String spcWriting;
	private String spcPic;

	// Constructors

	/** default constructor */
	public SellingPointContent() {
	}

	/** full constructor */
	public SellingPointContent(BuildingSellingPoint buildingSellingPoint,
			String spcWriting, String spcPic) {
		this.buildingSellingPoint = buildingSellingPoint;
		this.spcWriting = spcWriting;
		this.spcPic = spcPic;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "spc_id", unique = true, nullable = false)
	public Integer getSpcId() {
		return this.spcId;
	}

	public void setSpcId(Integer spcId) {
		this.spcId = spcId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bsp_id")
	public BuildingSellingPoint getBuildingSellingPoint() {
		return this.buildingSellingPoint;
	}

	public void setBuildingSellingPoint(
			BuildingSellingPoint buildingSellingPoint) {
		this.buildingSellingPoint = buildingSellingPoint;
	}

	@Column(name = "spc_writing")
	public String getSpcWriting() {
		return this.spcWriting;
	}

	public void setSpcWriting(String spcWriting) {
		this.spcWriting = spcWriting;
	}

	@Column(name = "spc_pic")
	public String getSpcPic() {
		return this.spcPic;
	}

	public void setSpcPic(String spcPic) {
		this.spcPic = spcPic;
	}

}