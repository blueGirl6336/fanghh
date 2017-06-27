package hitwh.fanghh.pojo;

import java.util.Date;

public class Strategyplacard {
    private Integer spId;

    private Integer hsId;

    private Integer userId;

    private Date placardTime;

    private String placardContent;

    private Boolean checkStatus;

    private String checkOpinion;

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public Integer getHsId() {
        return hsId;
    }

    public void setHsId(Integer hsId) {
        this.hsId = hsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPlacardTime() {
        return placardTime;
    }

    public void setPlacardTime(Date placardTime) {
        this.placardTime = placardTime;
    }

    public String getPlacardContent() {
        return placardContent;
    }

    public void setPlacardContent(String placardContent) {
        this.placardContent = placardContent == null ? null : placardContent.trim();
    }

    public Boolean getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Boolean checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckOpinion() {
        return checkOpinion;
    }

    public void setCheckOpinion(String checkOpinion) {
        this.checkOpinion = checkOpinion == null ? null : checkOpinion.trim();
    }
}