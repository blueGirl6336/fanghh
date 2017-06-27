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
 * AdvertisementPic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AdvertisementPic", schema = "dbo")
public class AdvertisementPic implements java.io.Serializable {

	// Fields

	private Integer apId;
	private AdvertisementSpace advertisementSpace;
	private String advertismentPic;

	// Constructors

	/** default constructor */
	public AdvertisementPic() {
	}

	/** full constructor */
	public AdvertisementPic(AdvertisementSpace advertisementSpace,
			String advertismentPic) {
		this.advertisementSpace = advertisementSpace;
		this.advertismentPic = advertismentPic;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ap_id", unique = true, nullable = false)
	public Integer getApId() {
		return this.apId;
	}

	public void setApId(Integer apId) {
		this.apId = apId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "advert_id")
	public AdvertisementSpace getAdvertisementSpace() {
		return this.advertisementSpace;
	}

	public void setAdvertisementSpace(AdvertisementSpace advertisementSpace) {
		this.advertisementSpace = advertisementSpace;
	}

	@Column(name = "advertisment_pic")
	public String getAdvertismentPic() {
		return this.advertismentPic;
	}

	public void setAdvertismentPic(String advertismentPic) {
		this.advertismentPic = advertismentPic;
	}

}