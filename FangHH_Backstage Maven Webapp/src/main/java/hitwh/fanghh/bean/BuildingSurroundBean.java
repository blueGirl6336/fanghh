/**     
 * @discription {在此输入一句话描述此文件的作用}
 * @author wangxinjie       
 * @created 2016年12月27日 下午3:25:16    
 */

package hitwh.fanghh.bean;

import hitwh.fanghh.pojo.Buildingpic;

import java.util.List;

/**
 * Title: BuildingSurroundBean.java Description: 描述
 * 
 * @author wangxinjie
 * @created 2016年12月27日 下午3:25:16
 */

public class BuildingSurroundBean {

	private Integer buildingId;

	private Integer sfId;

	private String busstation;

	private String school;

	private String hospital;

	private String bank;

	private String entertainment;

	private String shopping;

	private String repast;

	private String exercise;

	private List<Buildingpic> list;

	/**
	 * 构造函数
	 * 
	 * @discription {在此输入一句话描述作用}
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:53
	 */
	public BuildingSurroundBean() {
		super();
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public Integer getBuildingId() {
		return buildingId;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param buildingId
	 */
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public String getBusstation() {
		return busstation;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param busstation
	 */
	public void setBusstation(String busstation) {
		this.busstation = busstation;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public String getSchool() {
		return school;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param school
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public String getHospital() {
		return hospital;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param hospital
	 */
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public String getBank() {
		return bank;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param bank
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public String getEntertainment() {
		return entertainment;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param entertainment
	 */
	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public String getShopping() {
		return shopping;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param shopping
	 */
	public void setShopping(String shopping) {
		this.shopping = shopping;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public String getRepast() {
		return repast;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param repast
	 */
	public void setRepast(String repast) {
		this.repast = repast;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public String getExercise() {
		return exercise;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param exercise
	 */
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @return type
	 */

	public List<Buildingpic> getList() {
		return list;
	}

	/**
	 * @author wangxinjie
	 * @created 2016年12月27日 下午3:31:38
	 * @param list
	 */
	public void setList(List<Buildingpic> list) {
		this.list = list;
	}

	public Integer getSfId() {
		return sfId;
	}

	public void setSfId(Integer sfId) {
		this.sfId = sfId;
	}

}