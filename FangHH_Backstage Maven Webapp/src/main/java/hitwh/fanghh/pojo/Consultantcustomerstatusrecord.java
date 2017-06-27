package hitwh.fanghh.pojo;

import java.util.Date;

public class Consultantcustomerstatusrecord {
    private Integer ccsrId;

    private Integer ccId;

    private String customerStatus;

    private String remark;

    private Date typeTime;

    public Integer getCcsrId() {
        return ccsrId;
    }

    public void setCcsrId(Integer ccsrId) {
        this.ccsrId = ccsrId;
    }

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus == null ? null : customerStatus.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getTypeTime() {
        return typeTime;
    }

    public void setTypeTime(Date typeTime) {
        this.typeTime = typeTime;
    }
}