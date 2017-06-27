package hitwh.fanghh.pojo;

public class Advertisementpic {
    private Integer apId;

    private Integer advertId;

    private String advertismentPic;

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public Integer getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Integer advertId) {
        this.advertId = advertId;
    }

    public String getAdvertismentPic() {
        return advertismentPic;
    }

    public void setAdvertismentPic(String advertismentPic) {
        this.advertismentPic = advertismentPic == null ? null : advertismentPic.trim();
    }
}