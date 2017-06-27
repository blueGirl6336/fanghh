package hitwh.fanghh.pojo;

import java.util.Date;

public class Housingstrategy {
    private Integer hsId;

    private Integer buildingId;

    private Integer userId;

    private String title;

    private Date issueTime;

    private Date visitTime;

    private Integer placardNum;

    private String strategyType;

    private Integer strategySort;

    private Boolean isEssence;

    public Integer getHsId() {
        return hsId;
    }

    public void setHsId(Integer hsId) {
        this.hsId = hsId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Integer getPlacardNum() {
        return placardNum;
    }

    public void setPlacardNum(Integer placardNum) {
        this.placardNum = placardNum;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType == null ? null : strategyType.trim();
    }

    public Integer getStrategySort() {
        return strategySort;
    }

    public void setStrategySort(Integer strategySort) {
        this.strategySort = strategySort;
    }

    public Boolean getIsEssence() {
        return isEssence;
    }

    public void setIsEssence(Boolean isEssence) {
        this.isEssence = isEssence;
    }
}