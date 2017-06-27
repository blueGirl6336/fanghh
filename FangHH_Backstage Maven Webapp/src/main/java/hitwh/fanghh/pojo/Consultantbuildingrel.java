package hitwh.fanghh.pojo;

import java.util.Date;

public class Consultantbuildingrel {
    private Integer reId;

    private Integer buildingId;

    private Integer consultantId;

    private Date bindTime;

    private Date unbindTime;

    private Boolean isUnbound;

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

    public Integer getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Integer consultantId) {
        this.consultantId = consultantId;
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

    public Boolean getIsUnbound() {
        return isUnbound;
    }

    public void setIsUnbound(Boolean isUnbound) {
        this.isUnbound = isUnbound;
    }
}