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
 * TransactionValueCheck entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TransactionValueCheck", schema = "dbo")
public class TransactionValueCheck implements java.io.Serializable {

	// Fields

	private Integer checkId;
	private SaleOrder saleOrder;
	private String developerId;
	private long developerQuotedPrice;
	private long developerCommissionPrice;
	private boolean isAgreed;
	private String brokerId;
	private long brokerQuotedPrice;
	private String checkStatus;
	/*private Set<TransactionCheckPic> transactionCheckPics = new HashSet<TransactionCheckPic>(
			0);*/

	// Constructors

	/** default constructor */
	public TransactionValueCheck() {
	}

	/** full constructor */
	public TransactionValueCheck(SaleOrder saleOrder, String developerId,
			long developerQuotedPrice, long developerCommissionPrice,
			boolean isAgreed, String brokerId, long brokerQuotedPrice
			) {
		this.saleOrder = saleOrder;
		this.developerId = developerId;
		this.developerQuotedPrice = developerQuotedPrice;
		this.developerCommissionPrice = developerCommissionPrice;
		this.isAgreed = isAgreed;
		this.brokerId = brokerId;
		this.brokerQuotedPrice = brokerQuotedPrice;
		this.checkStatus = checkStatus;
		//this.transactionCheckPics = transactionCheckPics;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "check_id", unique = true, nullable = false)
	public Integer getCheckId() {
		return this.checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "so_id")
	public SaleOrder getSaleOrder() {
		return this.saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

	@Column(name = "developer_id")
	public String getDeveloperId() {
		return this.developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	@Column(name = "developer_quoted_price", precision = 18, scale = 0)
	public long getDeveloperQuotedPrice() {
		return this.developerQuotedPrice;
	}

	public void setDeveloperQuotedPrice(long developerQuotedPrice) {
		this.developerQuotedPrice = developerQuotedPrice;
	}

	@Column(name = "developer_commission_price", precision = 18, scale = 0)
	public long getDeveloperCommissionPrice() {
		return this.developerCommissionPrice;
	}

	public void setDeveloperCommissionPrice(long developerCommissionPrice) {
		this.developerCommissionPrice = developerCommissionPrice;
	}

	@Column(name = "is_agreed")
	public boolean getIsAgreed() {
		return this.isAgreed;
	}

	public void setIsAgreed(boolean isAgreed) {
		this.isAgreed = isAgreed;
	}

	@Column(name = "broker_id")
	public String getBrokerId() {
		return this.brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	@Column(name = "broker_quoted_price", precision = 18, scale = 0)
	public long getBrokerQuotedPrice() {
		return this.brokerQuotedPrice;
	}

	public void setBrokerQuotedPrice(long brokerQuotedPrice) {
		this.brokerQuotedPrice = brokerQuotedPrice;
	}

	@Column(name = "check_status")
	public String getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "transactionValueCheck")
	public Set<TransactionCheckPic> getTransactionCheckPics() {
		return this.transactionCheckPics;
	}

	public void setTransactionCheckPics(
			Set<TransactionCheckPic> transactionCheckPics) {
		this.transactionCheckPics = transactionCheckPics;
	}*/

}