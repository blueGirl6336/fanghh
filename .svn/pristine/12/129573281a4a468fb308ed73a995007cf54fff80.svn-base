package hitwh.fanghh.manage.pojo;

import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 用户信息
 * 
 * @author QIQI
 * 
 */
@JsonAutoDetect
@Entity
// 指定表名，与数据库自带user重名
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;

	// 用户名，也是登录名
	@Column(name = "user_name", nullable = true)
	private String username;

	// 密码
	@Column(name = "password", nullable = true)
	private String password;

	// 用户手机号
	@Column(name = "phone_no", nullable = true)
	private String phoneNo;
	// 用户头像
	@Column(name = "portrait", nullable = true)
	private String portrait;

	// 角色
	@Column(name = "role", nullable = true)
	private String role;
	// 用户等级
	@Column(name = "user_degree", nullable = true)
	private Integer userDegree;
	// 用户目前积分
	@Column(name = "current_integral", nullable = true)
	private Integer currentIntegral;
	// 分享码
	@Column(name = "share_code", nullable = true)
	private String shareCode;
	// 使用次数
	@Column(name = "code_times", nullable = true)
	private Integer codeTimes;
	// 是否实名认证
	@Column(name = "is_authenticated", nullable = true)
	private boolean isAuthenticated;
	// 创建时间
	@Column(name = "create_time", nullable = true)
	private Timestamp createTime;
	// 是否启用
	@Column(name = "is_activited", nullable = true)
	private boolean isActivited;
	//最近登录时间
	@Column(name = "recent_login_time", nullable = true)
	private Timestamp recentLoginTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getUserDegree() {
		return userDegree;
	}
	public void setUserDegree(Integer userDegree) {
		this.userDegree = userDegree;
	}
	public Integer getCurrentIntegral() {
		return currentIntegral;
	}
	public void setCurrentIntegral(Integer currentIntegral) {
		this.currentIntegral = currentIntegral;
	}
	public String getShareCode() {
		return shareCode;
	}
	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}
	public Integer getCodeTimes() {
		return codeTimes;
	}
	public void setCodeTimes(Integer codeTimes) {
		this.codeTimes = codeTimes;
	}
	public boolean getIsAuthenticated() {
		return isAuthenticated;
	}
	public void setIsAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getCreateTime() {
		return createTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	public Timestamp getRecentLoginTime() {
		return recentLoginTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setRecentLoginTime(Timestamp recentLoginTime) {
		this.recentLoginTime = recentLoginTime;
	}
	public boolean getIsActivited() {
		return isActivited;
	}
	public void setIsActivited(boolean isActivited) {
		this.isActivited = isActivited;
	}


}
