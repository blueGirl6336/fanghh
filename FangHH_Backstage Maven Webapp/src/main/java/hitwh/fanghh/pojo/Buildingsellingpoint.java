package hitwh.fanghh.pojo;

import java.util.Date;

public class Buildingsellingpoint {
    private Integer bspId;

    private Integer buildingId;

    private String title;

    private Date issueTime;

    public Integer getBspId() {
        return bspId;
    }

    public void setBspId(Integer bspId) {
        this.bspId = bspId;
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
}