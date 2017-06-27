/**
 * 
 */
package hitwh.fanghh.bean;

import hitwh.fanghh.pojo.Pictalkcontent;

import java.util.Date;
import java.util.List;

/**
 * @author 冯奔
 *
 */
public class PicTalkBean {
	private Integer ptId;//看图说房ID
	private Integer buildingId;//楼盘ID
	private String title;//看图说房标题
	private Date issueTime;//当前时间
	private List<Pictalkcontent> pictalkcontentList;//看图说房content的List
	/**
	 * @return the buildingId
	 */
	public Integer getBuildingId() {
		return buildingId;
	}
	/**
	 * @param buildingId the buildingId to set
	 */
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the pictalkcontentList
	 */
	public List<Pictalkcontent> getPictalkcontentList() {
		return pictalkcontentList;
	}
	/**
	 * @param pictalkcontentList the pictalkcontentList to set
	 */
	public void setPictalkcontentList(List<Pictalkcontent> pictalkcontentList) {
		this.pictalkcontentList = pictalkcontentList;
	}
	/**
	 * @return the issueTime
	 */
	public Date getIssueTime() {
		return issueTime;
	}
	/**
	 * @param issueTime the issueTime to set
	 */
	public void setIssueTime(Date issueTime) {
		this.issueTime = issueTime;
	}
	/**
	 * @return the ptId
	 */
	public Integer getPtId() {
		return ptId;
	}
	/**
	 * @param ptId the ptId to set
	 */
	public void setPtId(Integer ptId) {
		this.ptId = ptId;
	}
	
}
