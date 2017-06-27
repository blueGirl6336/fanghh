package hitwh.fanghh.pojo;

import java.util.Date;

public class Saledirectorbuildingrel {
    private Integer reId;

    private Integer buildingId;

    private Integer directorId;

    private Date bindTime;

    private Date unbindTime;

    private Boolean isBound;

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public Date getUnbindTime() {
        return unbindTime;
    }

    public void setUnbindTime(Date unbindTime) {
        this.unbindTime = unbindTime;
    }

    public Boolean getIsBound() {
        return isBound;
    }

    public void setIsBound(Boolean isBound) {
        this.isBound = isBound;
    }
}