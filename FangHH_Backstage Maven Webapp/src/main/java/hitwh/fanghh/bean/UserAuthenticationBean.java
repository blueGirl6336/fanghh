package hitwh.fanghh.bean;
/**
 * 
 * @ClassName:UserAuthenticationBean
 * @Description:TODO
 * @author:LY
 * @date:{date}
 *
 */
public class UserAuthenticationBean {
	  private Integer userId;

	  private String userName;//用户名
	  
	  
	  private String idNumber;//身份证号
	  
	  private String realPic;//认证图片
	  
	  private String realName;//真实姓名
	  
	  private String failedReason;//实名认证失败原因
	  private String status;//状态
	  
	  
	  public Integer getUserId() {
		  return userId;
	  }

	  public void setUserId(Integer userId) {
		  this.userId = userId;
	  }

	  public String getUserName() {
		  return userName;
	  }

	  public void setUserName(String userName) {
		  this.userName = userName == null ? null : userName.trim();
	  }
	  
	  public String getStatus() {
		  return status;
	  }

	  public void setStatus(String status) {
		  this.status = status == null ? null : status.trim();
	  }
	  public String getFailedReason() {
		  return failedReason;
	  }

	  public void setFailedReason(String failedReason) {
		  this.failedReason = failedReason;
	  }
	  public String getIdNumber() {
		  return idNumber;
	  }

	  public void setIdNumber(String idNumber) {
		  this.idNumber = idNumber;
	  }
	  
	  public String getRealPic() {
		  return realPic;
	  }

	  public void setRealPic(String realPic) {
		  this.realPic = realPic;
	  }
	  public String getRealName() {
		  return realName;
	  }

	  public void setRealName(String realName) {
		  this.realName = realName;
	  }
}

