package hitwh.fanghh.pojo;

public class Homeconsultant {
    private Integer consultantId;

    private Integer userId;

    private Integer buildingId;

    private String consultantName;

    private String consultantIdcard;

    private Boolean isAgent;

    private Boolean isStopped;

    private Boolean isOff;

    public Integer getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName == null ? null : consultantName.trim();
    }

    public String getConsultantIdcard() {
        return consultantIdcard;
    }

    public void setConsultantIdcard(String consultantIdcard) {
        this.consultantIdcard = consultantIdcard == null ? null : consultantIdcard.trim();
    }

    public Boolean getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(Boolean isAgent) {
        this.isAgent = isAgent;
    }

    public Boolean getIsStopped() {
        return isStopped;
    }

    public void setIsStopped(Boolean isStopped) {
        this.isStopped = isStopped;
    }

    public Boolean getIsOff() {
        return isOff;
    }

    public void setIsOff(Boolean isOff) {
        this.isOff = isOff;
    }
}