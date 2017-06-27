package hitwh.fanghh.pojo;

public class Transactionvaluecheck {
    private Integer checkId;

    private Integer soId;

    private String developerId;

    private Long developerQuotedPrice;

    private Long developerCommissionPrice;

    private Boolean isAgreed;

    private String brokerId;

    private Long brokerQuotedPrice;

    private String checkStatus;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getSoId() {
        return soId;
    }

    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId == null ? null : developerId.trim();
    }

    public Long getDeveloperQuotedPrice() {
        return developerQuotedPrice;
    }

    public void setDeveloperQuotedPrice(Long developerQuotedPrice) {
        this.developerQuotedPrice = developerQuotedPrice;
    }

    public Long getDeveloperCommissionPrice() {
        return developerCommissionPrice;
    }

    public void setDeveloperCommissionPrice(Long developerCommissionPrice) {
        this.developerCommissionPrice = developerCommissionPrice;
    }

    public Boolean getIsAgreed() {
        return isAgreed;
    }

    public void setIsAgreed(Boolean isAgreed) {
        this.isAgreed = isAgreed;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId == null ? null : brokerId.trim();
    }

    public Long getBrokerQuotedPrice() {
        return brokerQuotedPrice;
    }

    public void setBrokerQuotedPrice(Long brokerQuotedPrice) {
        this.brokerQuotedPrice = brokerQuotedPrice;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }
}