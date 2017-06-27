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
 * PicTalkContent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PicTalkContent", schema = "dbo")
public class PicTalkContent implements java.io.Serializable {

	// Fields

	private Integer ptcId;
	private PicTalk picTalk;
	private String ptcPic;

	// Constructors

	/** default constructor */
	public PicTalkContent() {
	}

	/** full constructor */
	public PicTalkContent(PicTalk picTalk, String ptcPic) {
		this.picTalk = picTalk;
		this.ptcPic = ptcPic;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ptc_id", unique = true, nullable = false)
	public Integer getPtcId() {
		return this.ptcId;
	}

	public void setPtcId(Integer ptcId) {
		this.ptcId = ptcId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pt_id")
	public PicTalk getPicTalk() {
		return this.picTalk;
	}

	public void setPicTalk(PicTalk picTalk) {
		this.picTalk = picTalk;
	}

	@Column(name = "ptc_pic")
	public String getPtcPic() {
		return this.ptcPic;
	}

	public void setPtcPic(String ptcPic) {
		this.ptcPic = ptcPic;
	}

}