package hitwh.fanghh.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Mapsurrounding {
    private Integer msId;

    private Integer buildingId;

    private BigDecimal posx;

    private BigDecimal posy;

    private String addr;

    private String description;

    private Date addTime;

    private Integer type;

    public Integer getMsId() {
        return msId;
    }

    public void setMsId(Integer msId) {
        this.msId = msId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public BigDecimal getPosx() {
        return posx;
    }

    public void setPosx(BigDecimal posx) {
        this.posx = posx;
    }

    public BigDecimal getPosy() {
        return posy;
    }

    public void setPosy(BigDecimal posy) {
        this.posy = posy;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}