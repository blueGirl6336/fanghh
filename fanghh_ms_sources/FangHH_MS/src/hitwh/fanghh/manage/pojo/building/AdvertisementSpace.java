package hitwh.fanghh.manage.pojo.building;

import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * AdvertisementSpace entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AdvertisementSpace", schema = "dbo")
public class AdvertisementSpace implements java.io.Serializable {

	// Fields

	private Integer advertId;
	private Building building;
	private Date topTime;
	private Integer duration;
	/*private Set<AdvertisementPic> advertisementPics = new HashSet<AdvertisementPic>(
			0);*/

	// Constructors

	/** default constructor */
	public AdvertisementSpace() {
	}

	/** full constructor */
	public AdvertisementSpace(Building building, Date topTime,
			Integer duration) {
		this.building = building;
		this.topTime = topTime;
		this.duration = duration;
		//this.advertisementPics = advertisementPics;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "advert_id", unique = true, nullable = false)
	public Integer getAdvertId() {
		return this.advertId;
	}

	public void setAdvertId(Integer advertId) {
		this.advertId = advertId;
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
	@Column(name = "top_time", length = 23)
	public Date getTopTime() {
		return this.topTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setTopTime(Date topTime) {
		this.topTime = topTime;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "advertisementSpace")
	public Set<AdvertisementPic> getAdvertisementPics() {
		return this.advertisementPics;
	}

	public void setAdvertisementPics(Set<AdvertisementPic> advertisementPics) {
		this.advertisementPics = advertisementPics;
	}*/

}