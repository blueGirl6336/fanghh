package hitwh.fanghh.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Brokercommentfromconsultant {
    private Integer bcfcId;

    private Integer consultantId;

    private Integer brokerId;

    private String orderId;

    private String entireComment;

    private BigDecimal customerQualityComment;

    private BigDecimal expertiseLevelComment;

    private String commentWriting;

    private Date commentTime;

    private String commentCheckStatus;

    private Date replyTime;

    private String replyContent;

    private String replyCheckStatus;

    public Integer getBcfcId() {
        return bcfcId;
    }

    public void setBcfcId(Integer bcfcId) {
        this.bcfcId = bcfcId;
    }

    public Integer getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Integer consultantId) {
        this.consultantId = consultantId;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getEntireComment() {
        return entireComment;
    }

    public void setEntireComment(String entireComment) {
        this.entireComment = entireComment == null ? null : entireComment.trim();
    }

    public BigDecimal getCustomerQualityComment() {
        return customerQualityComment;
    }

    public void setCustomerQualityComment(BigDecimal customerQualityComment) {
        this.customerQualityComment = customerQualityComment;
    }

    public BigDecimal getExpertiseLevelComment() {
        return expertiseLevelComment;
    }

    public void setExpertiseLevelComment(BigDecimal expertiseLevelComment) {
        this.expertiseLevelComment = expertiseLevelComment;
    }

    public String getCommentWriting() {
        return commentWriting;
    }

    public void setCommentWriting(String commentWriting) {
        this.commentWriting = commentWriting == null ? null : commentWriting.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
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
}