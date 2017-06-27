package hitwh.fanghh.pojo;

import java.util.Date;

public class Redpacket {
    private Integer packetId;

    private Integer userId;

    private Long amount;

    private Date deadline;

    private Integer status;

    private Long lowestLimit;

    public Integer getPacketId() {
        return packetId;
    }

    public void setPacketId(Integer packetId) {
        this.packetId = packetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLowestLimit() {
        return lowestLimit;
    }

    public void setLowestLimit(Long lowestLimit) {
        this.lowestLimit = lowestLimit;
    }
}