package hitwh.fanghh.pojo;

public class Broker {
    private Integer brokerId;

    private Integer userId;

    private Integer storeId;

    private Integer teamId;

    private String brokerName;

    private String brokerIdcard;

    private String brokerType;

    private String invitationCode;

    private String idcardPic;

    private String failedReason;
    
    private String applicateAuthentication;
    private String status;
    
    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
    

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName == null ? null : brokerName.trim();
    }

    public String getBrokerIdcard() {
        return brokerIdcard;
    }

    public void setBrokerIdcard(String brokerIdcard) {
        this.brokerIdcard = brokerIdcard == null ? null : brokerIdcard.trim();
    }

    public String getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(String brokerType) {
        this.brokerType = brokerType == null ? null : brokerType.trim();
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public String getIdcardPic() {
        return idcardPic;
    }

    public void setIdcardPic(String idcardPic) {
        this.idcardPic = idcardPic == null ? null : idcardPic.trim();
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason == null ? null : failedReason.trim();
    }
    public String getApplicateAuthentication() {
        return applicateAuthentication;
    }

    public void setApplicateAuthentication(String applicateAuthentication) {
        this.applicateAuthentication = applicateAuthentication;
    }
}