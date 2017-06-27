package hitwh.fanghh.pojo;

import java.util.Date;

public class Buildingsearchrecord {
    private Integer bsrId;

    private String buildingName;

    private Date searchTime;

    public Integer getBsrId() {
        return bsrId;
    }

    public void setBsrId(Integer bsrId) {
        this.bsrId = bsrId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }
}