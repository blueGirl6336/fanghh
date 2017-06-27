package hitwh.fanghh.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Ordersign {
    private Integer osId;

    private String orderId;

    private BigDecimal commissionSum;

    private BigDecimal commissionTable;

    private Integer teamLeaderId;

    private BigDecimal commissionTeamLeader;

    private Integer brokerId;

    private BigDecimal commisstionBroker;

    private String status;

    private String remark;

    private Date signTime;

    private Integer regionalAgencyId;

    private BigDecimal commisstionRegionalAgency;

    private Date endTime;

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public BigDecimal getCommissionSum() {
        return commissionSum;
    }

    public void setCommissionSum(BigDecimal commissionSum) {
        this.commissionSum = commissionSum;
    }

    public BigDecimal getCommissionTable() {
        return commissionTable;
    }

    public void setCommissionTable(BigDecimal commissionTable) {
        this.commissionTable = commissionTable;
    }

    public Integer getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Integer teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public BigDecimal getCommissionTeamLeader() {
        return commissionTeamLeader;
    }

    public void setCommissionTeamLeader(BigDecimal commissionTeamLeader) {
        this.commissionTeamLeader = commissionTeamLeader;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public BigDecimal getCommisstionBroker() {
        return commisstionBroker;
    }

    public void setCommisstionBroker(BigDecimal commisstionBroker) {
        this.commisstionBroker = commisstionBroker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Integer getRegionalAgencyId() {
        return regionalAgencyId;
    }

    public void setRegionalAgencyId(Integer regionalAgencyId) {
        this.regionalAgencyId = regionalAgencyId;
    }

    public BigDecimal getCommisstionRegionalAgency() {
        return commisstionRegionalAgency;
    }

    public void setCommisstionRegionalAgency(BigDecimal commisstionRegionalAgency) {
        this.commisstionRegionalAgency = commisstionRegionalAgency;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}