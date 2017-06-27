package hitwh.fanghh.pojo;

public class Brokerteam {
    private Integer teamId;

    private Integer teamLeader;

    private Integer customerNum;

    private Integer dealNum;

    private Long saleProfit;

    private Long totalCommission;

    private Integer buildingNum;

    private String invitationCode;

    private Integer teamNum;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Integer teamLeader) {
        this.teamLeader = teamLeader;
    }

    public Integer getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(Integer customerNum) {
        this.customerNum = customerNum;
    }

    public Integer getDealNum() {
        return dealNum;
    }

    public void setDealNum(Integer dealNum) {
        this.dealNum = dealNum;
    }

    public Long getSaleProfit() {
        return saleProfit;
    }

    public void setSaleProfit(Long saleProfit) {
        this.saleProfit = saleProfit;
    }

    public Long getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Long totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Integer getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(Integer buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public Integer getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(Integer teamNum) {
        this.teamNum = teamNum;
    }
}