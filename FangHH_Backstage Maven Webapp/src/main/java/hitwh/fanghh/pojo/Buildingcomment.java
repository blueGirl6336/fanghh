package hitwh.fanghh.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Buildingcomment {
    private Integer commentId;

    private Integer userId;

    private Integer buildingId;

    private Integer consultantId;

    private Date commentTime;

    private BigDecimal entireComment;

    private BigDecimal priceComment;

    private BigDecimal locationComment;

    private BigDecimal facilitiesComment;

    private BigDecimal trafficComment;

    private BigDecimal environmentComment;

    private String commentWriting;

    private String commentCatg;

    private Date catgSettingTime;

    private String commentCheckStatus;

    private Date replyTime;

    private String replyContent;

    private String replyCheckStatus;

    private Boolean isEssence;

    private String commentPic;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public BigDecimal getEntireComment() {
        return entireComment;
    }

    public void setEntireComment(BigDecimal entireComment) {
        this.entireComment = entireComment;
    }

    public BigDecimal getPriceComment() {
        return priceComment;
    }

    public void setPriceComment(BigDecimal priceComment) {
        this.priceComment = priceComment;
    }

    public BigDecimal getLocationComment() {
        return locationComment;
    }

    public void setLocationComment(BigDecimal locationComment) {
        this.locationComment = locationComment;
    }

    public BigDecimal getFacilitiesComment() {
        return facilitiesComment;
    }

    public void setFacilitiesComment(BigDecimal facilitiesComment) {
        this.facilitiesComment = facilitiesComment;
    }

    public BigDecimal getTrafficComment() {
        return trafficComment;
    }

    public void setTrafficComment(BigDecimal trafficComment) {
        this.trafficComment = trafficComment;
    }

    public BigDecimal getEnvironmentComment() {
        return environmentComment;
    }

    public void setEnvironmentComment(BigDecimal environmentComment) {
        this.environmentComment = environmentComment;
    }

    public String getCommentWriting() {
        return commentWriting;
    }

    public void setCommentWriting(String commentWriting) {
        this.commentWriting = commentWriting == null ? null : commentWriting.trim();
    }

    public String getCommentCatg() {
        return commentCatg;
    }

    public void setCommentCatg(String commentCatg) {
        this.commentCatg = commentCatg == null ? null : commentCatg.trim();
    }

    public Date getCatgSettingTime() {
        return catgSettingTime;
    }

    public void setCatgSettingTime(Date catgSettingTime) {
        this.catgSettingTime = catgSettingTime;
    }

    public String getCommentCheckStatus() {
        return commentCheckStatus;
    }

    public void setCommentCheckStatus(String commentCheckStatus) {
        this.commentCheckStatus = commentCheckStatus == null ? null : commentCheckStatus.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public String getReplyCheckStatus() {
        return replyCheckStatus;
    }

    public void setReplyCheckStatus(String replyCheckStatus) {
        this.replyCheckStatus = replyCheckStatus == null ? null : replyCheckStatus.trim();
    }

    public Boolean getIsEssence() {
        return isEssence;
    }

    public void setIsEssence(Boolean isEssence) {
        this.isEssence = isEssence;
    }

    public String getCommentPic() {
        return commentPic;
    }

    public void setCommentPic(String commentPic) {
        this.commentPic = commentPic == null ? null : commentPic.trim();
    }
}