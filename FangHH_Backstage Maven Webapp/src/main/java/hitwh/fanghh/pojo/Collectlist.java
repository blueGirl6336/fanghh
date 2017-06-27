package hitwh.fanghh.pojo;

import java.util.Date;

public class Collectlist {
    private Integer collectId;

    private Integer userId;

    private Date collectTime;

    private String collectType;

    private String collectObjId;

    private String remark;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public String getCollectType() {
        return collectType;
    }

    public void setCollectType(String collectType) {
        this.collectType = collectType == null ? null : collectType.trim();
    }

    public String getCollectObjId() {
        return collectObjId;
    }

    public void setCollectObjId(String collectObjId) {
        this.collectObjId = collectObjId == null ? null : collectObjId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}