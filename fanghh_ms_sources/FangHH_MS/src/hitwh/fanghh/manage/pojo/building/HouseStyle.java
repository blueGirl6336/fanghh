// default package
package hitwh.fanghh.manage.pojo.building;
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

/**
 * HouseStyle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HouseStyle", schema = "dbo")
public class HouseStyle implements java.io.Serializable {

	// Fields

	private Integer styleId;
	private Building building;
	private String houseStyle;
	private String styleDescription;
	private String stylePic;
	//private Set<House> houses = new HashSet<House>(0);

	// Constructors

	/** default constructor */
	public HouseStyle() {
	}

	/** full constructor */
	public HouseStyle(Building building, String houseStyle,
			String styleDescription, String stylePic//, Set<House> houses
			) {
		this.building = building;
		this.houseStyle = houseStyle;
		this.styleDescription = styleDescription;
		this.stylePic = stylePic;
		//this.houses = houses;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "style_id", unique = true, nullable = false)
	public Integer getStyleId() {
		return this.styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "house_style")
	public String getHouseStyle() {
		return this.houseStyle;
	}

	public void setHouseStyle(String houseStyle) {
		this.houseStyle = houseStyle;
	}

	@Column(name = "style_description")
	public String getStyleDescription() {
		return this.styleDescription;
	}

	public void setStyleDescription(String styleDescription) {
		this.styleDescription = styleDescription;
	}

	@Column(name = "style_pic")
	public String getStylePic() {
		return this.stylePic;
	}

	public void setStylePic(String stylePic) {
		this.stylePic = stylePic;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "houseStyle")
	public Set<House> getHouses() {
		return this.houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}*/

}