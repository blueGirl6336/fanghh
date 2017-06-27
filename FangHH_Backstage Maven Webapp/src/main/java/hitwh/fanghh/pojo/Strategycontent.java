package hitwh.fanghh.pojo;

public class Strategycontent {
    private Integer scId;

    private Integer hsId;

    private String scPic;

    private String scWriting;

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public Integer getHsId() {
        return hsId;
    }

    public void setHsId(Integer hsId) {
        this.hsId = hsId;
    }

    public String getScPic() {
        return scPic;
    }

    public void setScPic(String scPic) {
        this.scPic = scPic == null ? null : scPic.trim();
    }

    public String getScWriting() {
        return scWriting;
    }

    public void setScWriting(String scWriting) {
        this.scWriting = scWriting == null ? null : scWriting.trim();
    }
}