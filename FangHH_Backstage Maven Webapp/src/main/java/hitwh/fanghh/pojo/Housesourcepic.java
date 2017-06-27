package hitwh.fanghh.pojo;

public class Housesourcepic {
    private Integer hspId;

    private Integer roId;

    private String hsPic;

    public Integer getHspId() {
        return hspId;
    }

    public void setHspId(Integer hspId) {
        this.hspId = hspId;
    }

    public Integer getRoId() {
        return roId;
    }

    public void setRoId(Integer roId) {
        this.roId = roId;
    }

    public String getHsPic() {
        return hsPic;
    }

    public void setHsPic(String hsPic) {
        this.hsPic = hsPic == null ? null : hsPic.trim();
    }
}