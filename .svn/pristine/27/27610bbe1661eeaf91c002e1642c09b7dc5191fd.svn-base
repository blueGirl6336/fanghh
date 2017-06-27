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
 * Property entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Property", schema = "dbo")
public class Property implements java.io.Serializable {

	// Fields

	private Integer propertyId;
	private String propertyName;
	private String propertyLeader;
	private long propertyPrice;
	private String propertyAddr;

	// Constructors

	/** default constructor */
	public Property() {
	}

	/** full constructor */
	public Property( String propertyName,
			String propertyLeader, long propertyPrice, String propertyAddr) {
		this.propertyName = propertyName;
		this.propertyLeader = propertyLeader;
		this.propertyPrice = propertyPrice;
		this.propertyAddr = propertyAddr;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "property_id", unique = true, nullable = false)
	public Integer getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	@Column(name = "property_name")
	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Column(name = "property_leader")
	public String getPropertyLeader() {
		return this.propertyLeader;
	}

	public void setPropertyLeader(String propertyLeader) {
		this.propertyLeader = propertyLeader;
	}

	@Column(name = "property_price", precision = 18, scale = 0)
	public long getPropertyPrice() {
		return this.propertyPrice;
	}

	public void setPropertyPrice(long propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	@Column(name = "property_addr")
	public String getPropertyAddr() {
		return this.propertyAddr;
	}

	public void setPropertyAddr(String propertyAddr) {
		this.propertyAddr = propertyAddr;
	}

}