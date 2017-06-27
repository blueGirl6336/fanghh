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
 * CommentPic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CommentPic", schema = "dbo")
public class CommentPic implements java.io.Serializable {

	// Fields

	private Integer cpId;
	private BuildingComment buildingComment;
	private String picLocation;

	// Constructors

	/** default constructor */
	public CommentPic() {
	}

	/** full constructor */
	public CommentPic(BuildingComment buildingComment, String picLocation) {
		this.buildingComment = buildingComment;
		this.picLocation = picLocation;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "cp_id", unique = true, nullable = false)
	public Integer getCpId() {
		return this.cpId;
	}

	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "comment_id")
	public BuildingComment getBuildingComment() {
		return this.buildingComment;
	}

	public void setBuildingComment(BuildingComment buildingComment) {
		this.buildingComment = buildingComment;
	}

	@Column(name = "pic_location")
	public String getPicLocation() {
		return this.picLocation;
	}

	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}

}