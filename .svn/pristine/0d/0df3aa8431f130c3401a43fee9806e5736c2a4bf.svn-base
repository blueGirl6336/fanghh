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
 * DynamicContent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DynamicContent", schema = "dbo")
public class DynamicContent implements java.io.Serializable {

	// Fields

	private Integer dcId;
	private BuildingDynamicInfo buildingDynamicInfo;
	private String dcWriting;
	private String dcPic;

	// Constructors

	/** default constructor */
	public DynamicContent() {
	}

	/** full constructor */
	public DynamicContent(BuildingDynamicInfo buildingDynamicInfo,
			String dcWriting, String dcPic) {
		this.buildingDynamicInfo = buildingDynamicInfo;
		this.dcWriting = dcWriting;
		this.dcPic = dcPic;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "dc_id", unique = true, nullable = false)
	public Integer getDcId() {
		return this.dcId;
	}

	public void setDcId(Integer dcId) {
		this.dcId = dcId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bdi_id")
	public BuildingDynamicInfo getBuildingDynamicInfo() {
		return this.buildingDynamicInfo;
	}

	public void setBuildingDynamicInfo(BuildingDynamicInfo buildingDynamicInfo) {
		this.buildingDynamicInfo = buildingDynamicInfo;
	}

	@Column(name = "dc_writing")
	public String getDcWriting() {
		return this.dcWriting;
	}

	public void setDcWriting(String dcWriting) {
		this.dcWriting = dcWriting;
	}

	@Column(name = "dc_pic")
	public String getDcPic() {
		return this.dcPic;
	}

	public void setDcPic(String dcPic) {
		this.dcPic = dcPic;
	}

}