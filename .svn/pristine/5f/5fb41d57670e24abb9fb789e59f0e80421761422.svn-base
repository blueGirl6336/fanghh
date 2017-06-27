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
 * ShareContent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ShareContent", schema = "dbo")
public class ShareContent implements java.io.Serializable {

	// Fields

	private Integer scId;
	private ShareInfo shareInfo;
	private String scPic;
	private String scWriting;

	// Constructors

	/** default constructor */
	public ShareContent() {
	}

	/** full constructor */
	public ShareContent(ShareInfo shareInfo, String scPic, String scWriting) {
		this.shareInfo = shareInfo;
		this.scPic = scPic;
		this.scWriting = scWriting;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "sc_id", unique = true, nullable = false)
	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "share_id")
	public ShareInfo getShareInfo() {
		return this.shareInfo;
	}

	public void setShareInfo(ShareInfo shareInfo) {
		this.shareInfo = shareInfo;
	}

	@Column(name = "sc_pic")
	public String getScPic() {
		return this.scPic;
	}

	public void setScPic(String scPic) {
		this.scPic = scPic;
	}

	@Column(name = "sc_writing")
	public String getScWriting() {
		return this.scWriting;
	}

	public void setScWriting(String scWriting) {
		this.scWriting = scWriting;
	}

}