package hitwh.fanghh.pojo;

import java.util.Date;

public class Buildingdynamicinfo {
    private Integer bdiId;

    private Integer buildingId;

    private String title;

    private Date issueTime;

    private Boolean isLatest;

    public Integer getBdiId() {
        return bdiId;
    }

    public void setBdiId(Integer bdiId) {
        this.bdiId = bdiId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
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

    public Boolean getIsLatest() {
        return isLatest;
    }

    public void setIsLatest(Boolean isLatest) {
        this.isLatest = isLatest;
    }
}