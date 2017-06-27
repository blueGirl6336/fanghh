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
 * CustomerRemark entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CustomerRemark", schema = "dbo")
public class CustomerRemark implements java.io.Serializable {

	// Fields

	private Integer remarkId;
	private Customer customer;
	private Building building;
	private String customerRemark;

	// Constructors

	/** default constructor */
	public CustomerRemark() {
	}

	/** full constructor */
	public CustomerRemark(Customer customer, Building building,
			String customerRemark) {
		this.customer = customer;
		this.building = building;
		this.customerRemark = customerRemark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "remark_id", unique = true, nullable = false)
	public Integer getRemarkId() {
		return this.remarkId;
	}

	public void setRemarkId(Integer remarkId) {
		this.remarkId = remarkId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "building_id")
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@Column(name = "customer_remark")
	public String getCustomerRemark() {
		return this.customerRemark;
	}

	public void setCustomerRemark(String customerRemark) {
		this.customerRemark = customerRemark;
	}

}