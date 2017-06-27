package hitwh.fanghh.pojo;

import java.util.Date;

public class Authenticatedpic {
    private Integer apId;

    private Integer userId;

    private String realPic;

    private Date uploadTime;

    public Integer getApId() {
        return apId;
    }

    public void setApId(Integer apId) {
        this.apId = apId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealPic() {
        return realPic;
    }

    public void setRealPic(String realPic) {
        this.realPic = realPic == null ? null : realPic.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}