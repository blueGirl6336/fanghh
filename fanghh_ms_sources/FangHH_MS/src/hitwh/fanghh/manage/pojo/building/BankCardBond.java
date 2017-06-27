package hitwh.fanghh.manage.pojo.building;

import hitwh.fanghh.manage.pojo.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BankCardBond entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BankCardBond", schema = "dbo")
public class BankCardBond implements java.io.Serializable {

	// Fields

	private Integer bcbId;
	private User user;
	private String cardNo;
	private String bandBelonged;

	// Constructors

	/** default constructor */
	public BankCardBond() {
	}

	/** full constructor */
	public BankCardBond(User user, String cardNo, String bandBelonged) {
		this.user = user;
		this.cardNo = cardNo;
		this.bandBelonged = bandBelonged;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "bcb_id", unique = true, nullable = false)
	public Integer getBcbId() {
		return this.bcbId;
	}

	public void setBcbId(Integer bcbId) {
		this.bcbId = bcbId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "card_no")
	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Column(name = "band_belonged")
	public String getBandBelonged() {
		return this.bandBelonged;
	}

	public void setBandBelonged(String bandBelonged) {
		this.bandBelonged = bandBelonged;
	}

}