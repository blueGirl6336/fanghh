package hitwh.fanghh.pojo;

import java.math.BigDecimal;

public class Interestrate {
    private Integer interestId;

    private String loanType;

    private Integer yearMin;

    private Integer putYear;

    private BigDecimal rate;

    private Integer yearMax;

    public Integer getInterestId() {
        return interestId;
    }

    public void setInterestId(Integer interestId) {
        this.interestId = interestId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType == null ? null : loanType.trim();
    }

    public Integer getYearMin() {
        return yearMin;
    }

    public void setYearMin(Integer yearMin) {
        this.yearMin = yearMin;
    }

    public Integer getPutYear() {
        return putYear;
    }

    public void setPutYear(Integer putYear) {
        this.putYear = putYear;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getYearMax() {
        return yearMax;
    }

    public void setYearMax(Integer yearMax) {
        this.yearMax = yearMax;
    }
}