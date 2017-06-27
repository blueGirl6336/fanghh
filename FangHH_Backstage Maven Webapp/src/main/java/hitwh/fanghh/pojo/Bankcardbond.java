package hitwh.fanghh.pojo;

public class Bankcardbond {
    private Integer bcbId;

    private Integer userId;

    private String cardNo;

    private String bandBelonged;

    public Integer getBcbId() {
        return bcbId;
    }

    public void setBcbId(Integer bcbId) {
        this.bcbId = bcbId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public String getBandBelonged() {
        return bandBelonged;
    }

    public void setBandBelonged(String bandBelonged) {
        this.bandBelonged = bandBelonged == null ? null : bandBelonged.trim();
    }
}