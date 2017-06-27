// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.pojo.User;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * CollectList entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CollectList", schema = "dbo")
public class CollectList implements java.io.Serializable {

	// Fields

	private Integer collectId;
	private User user;
	private Date collectTime;
	private String collectType;
	private String collectObjId;
	private String remark;

	// Constructors

	/** default constructor */
	public CollectList() {
	}

	/** full constructor */
	public CollectList(User user, Date collectTime, String collectType,
			String collectObjId, String remark) {
		this.user = user;
		this.collectTime = collectTime;
		this.collectType = collectType;
		this.collectObjId = collectObjId;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "collect_id", unique = true, nullable = false)
	public Integer getCollectId() {
		return this.collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "collect_time", length = 23)
	public Date getCollectTime() {
		return this.collectTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	@Column(name = "collect_type")
	public String getCollectType() {
		return this.collectType;
	}

	public void setCollectType(String collectType) {
		this.collectType = collectType;
	}

	@Column(name = "collect_obj_id")
	public String getCollectObjId() {
		return this.collectObjId;
	}

	public void setCollectObjId(String collectObjId) {
		this.collectObjId = collectObjId;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}