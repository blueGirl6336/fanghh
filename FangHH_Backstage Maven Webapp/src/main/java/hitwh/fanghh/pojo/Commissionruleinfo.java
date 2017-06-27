package hitwh.fanghh.pojo;

public class Commissionruleinfo {
    private Integer criId;

    private String numericalLabel;

    private String ruleType;

    private String ruleDetail;

    private Integer ruleId;

    public Integer getCriId() {
        return criId;
    }

    public void setCriId(Integer criId) {
        this.criId = criId;
    }

    public String getNumericalLabel() {
        return numericalLabel;
    }

    public void setNumericalLabel(String numericalLabel) {
        this.numericalLabel = numericalLabel == null ? null : numericalLabel.trim();
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType == null ? null : ruleType.trim();
    }

    public String getRuleDetail() {
        return ruleDetail;
    }

    public void setRuleDetail(String ruleDetail) {
        this.ruleDetail = ruleDetail == null ? null : ruleDetail.trim();
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }
}