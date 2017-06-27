package hitwh.fanghh.pojo;

public class Pictalkcontent {
    private Integer ptcId;

    private Integer ptId;

    private String ptcPic;

    private Integer ptc_order;
    
    private String ptcContent;

    public Integer getPtcId() {
        return ptcId;
    }

    public void setPtcId(Integer ptcId) {
        this.ptcId = ptcId;
    }

    public Integer getPtId() {
        return ptId;
    }

    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    public String getPtcPic() {
        return ptcPic;
    }

    public void setPtcPic(String ptcPic) {
        this.ptcPic = ptcPic == null ? null : ptcPic.trim();
    }



	/**
	 * @return the ptcContent
	 */
	public String getPtcContent() {
		return ptcContent;
	}

	/**
	 * @param ptcContent the ptcContent to set
	 */
	public void setPtcContent(String ptcContent) {
		this.ptcContent = ptcContent;
	}

	/**
	 * @return the ptc_order
	 */
	public Integer getPtc_order() {
		return ptc_order;
	}

	/**
	 * @param ptc_order the ptc_order to set
	 */
	public void setPtc_order(Integer ptc_order) {
		this.ptc_order = ptc_order;
	}
}