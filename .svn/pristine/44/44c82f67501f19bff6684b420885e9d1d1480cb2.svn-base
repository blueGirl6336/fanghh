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
 * Wallet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Wallet", schema = "dbo")
public class Wallet implements java.io.Serializable {

	// Fields

	private Integer walletId;
	private Broker broker;
	private long balance;
	private long totalIncome;
	private long totalPay;
	private long commissionReceived;
	private long commissionNotRecevied;
	private long freezeMoney;
	private String password;

	// Constructors

	/** default constructor */
	public Wallet() {
	}

	/** full constructor */
	public Wallet(Broker broker, long balance, long totalIncome, long totalPay,
			long commissionReceived, long commissionNotRecevied,
			long freezeMoney, String password) {
		this.broker = broker;
		this.balance = balance;
		this.totalIncome = totalIncome;
		this.totalPay = totalPay;
		this.commissionReceived = commissionReceived;
		this.commissionNotRecevied = commissionNotRecevied;
		this.freezeMoney = freezeMoney;
		this.password = password;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "wallet_id", unique = true, nullable = false)
	public Integer getWalletId() {
		return this.walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "broker_id")
	public Broker getBroker() {
		return this.broker;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	@Column(name = "balance", precision = 18, scale = 0)
	public long getBalance() {
		return this.balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Column(name = "total_income", precision = 18, scale = 0)
	public long getTotalIncome() {
		return this.totalIncome;
	}

	public void setTotalIncome(long totalIncome) {
		this.totalIncome = totalIncome;
	}

	@Column(name = "total_pay", precision = 18, scale = 0)
	public long getTotalPay() {
		return this.totalPay;
	}

	public void setTotalPay(long totalPay) {
		this.totalPay = totalPay;
	}

	@Column(name = "commission_received", precision = 18, scale = 0)
	public long getCommissionReceived() {
		return this.commissionReceived;
	}

	public void setCommissionReceived(long commissionReceived) {
		this.commissionReceived = commissionReceived;
	}

	@Column(name = "commission_not_recevied", precision = 18, scale = 0)
	public long getCommissionNotRecevied() {
		return this.commissionNotRecevied;
	}

	public void setCommissionNotRecevied(long commissionNotRecevied) {
		this.commissionNotRecevied = commissionNotRecevied;
	}

	@Column(name = "freeze_money", precision = 18, scale = 0)
	public long getFreezeMoney() {
		return this.freezeMoney;
	}

	public void setFreezeMoney(long freezeMoney) {
		this.freezeMoney = freezeMoney;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}