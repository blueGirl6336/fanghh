package hitwh.fanghh.pojo;

public class Commentpic {
    private Integer cpId;

    private Integer commentId;

    private String picLocation;

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getPicLocation() {
        return picLocation;
    }

    public void setPicLocation(String picLocation) {
        this.picLocation = picLocation == null ? null : picLocation.trim();
    }
}