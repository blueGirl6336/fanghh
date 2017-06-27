package hitwh.fanghh.pojo;

import java.math.BigDecimal;

public class Versionupdate {
    private Integer vuId;

    private String versionCode;

    private String downloadUrl;

    private Integer type;

    private String updateMessage;

    private BigDecimal updateSize;

    public Integer getVuId() {
        return vuId;
    }

    public void setVuId(Integer vuId) {
        this.vuId = vuId;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode == null ? null : versionCode.trim();
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage == null ? null : updateMessage.trim();
    }

    public BigDecimal getUpdateSize() {
        return updateSize;
    }

    public void setUpdateSize(BigDecimal updateSize) {
        this.updateSize = updateSize;
    }
}