package hitwh.fanghh.pojo;

import java.util.Date;

public class Pictalk {
    private Integer ptId;

    private Integer buildingId;

    private String title;

    private Integer placardTimes;

    private Date issueTime;

    private String url;

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
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

    public Integer getPlacardTimes() {
        return placardTimes;
    }

    public void setPlacardTimes(Integer placardTimes) {
        this.placardTimes = placardTimes;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}