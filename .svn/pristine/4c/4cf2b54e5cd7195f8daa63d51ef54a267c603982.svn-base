package hitwh.fanghh.manage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dictionary entity. @author MyEclipse Persistence Tools
 * 数据字典
 */
@Entity
@Table(name = "Dictionary", schema = "dbo")
public class Dictionary implements java.io.Serializable {

	// Fields
	//编号
	private Integer id;
	//是否管理员可见
	private boolean dictAdminvisible;
	//字典项代码
	private String dictCode;
	//字典项分组
	private Integer dictDetailgroup;
	//字典项简写
	private String dictLogogram;
	//模块代码
	private String dictModuleCode;
	//字典项名称
	private String dictName;
	//字典项父项代码
	private String dictParentCode;
	//字典项等级
	private Integer dictLevel;
	//字典项的值
	private String dictValue;
	//备注
	private String remark;

	// Constructors

	/** default constructor */
	public Dictionary() {
	}

	/** full constructor */
	public Dictionary(boolean dictAdminvisible, String dictCode,
			Integer dictDetailgroup, String dictLogogram,
			String dictModuleCode, String dictName, String dictParentCode,
			Integer dictLevel, String dictValue, String remark) {
		this.dictAdminvisible = dictAdminvisible;
		this.dictCode = dictCode;
		this.dictDetailgroup = dictDetailgroup;
		this.dictLogogram = dictLogogram;
		this.dictModuleCode = dictModuleCode;
		this.dictName = dictName;
		this.dictParentCode = dictParentCode;
		this.dictLevel = dictLevel;
		this.dictValue = dictValue;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "dictAdminvisible")
	public boolean getDictAdminvisible() {
		return this.dictAdminvisible;
	}

	public void setDictAdminvisible(boolean dictAdminvisible) {
		this.dictAdminvisible = dictAdminvisible;
	}

	@Column(name = "dictCode", length = 50)
	public String getDictCode() {
		return this.dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	@Column(name = "dictDetailgroup")
	public Integer getDictDetailgroup() {
		return this.dictDetailgroup;
	}

	public void setDictDetailgroup(Integer dictDetailgroup) {
		this.dictDetailgroup = dictDetailgroup;
	}

	@Column(name = "dictLogogram", length = 50)
	public String getDictLogogram() {
		return this.dictLogogram;
	}

	public void setDictLogogram(String dictLogogram) {
		this.dictLogogram = dictLogogram;
	}

	@Column(name = "dictModuleCode", length = 50)
	public String getDictModuleCode() {
		return this.dictModuleCode;
	}

	public void setDictModuleCode(String dictModuleCode) {
		this.dictModuleCode = dictModuleCode;
	}

	@Column(name = "dictName", length = 50)
	public String getDictName() {
		return this.dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	@Column(name = "dictParentCode", length = 50)
	public String getDictParentCode() {
		return this.dictParentCode;
	}

	public void setDictParentCode(String dictParentCode) {
		this.dictParentCode = dictParentCode;
	}

	@Column(name = "dictLevel")
	public Integer getDictLevel() {
		return this.dictLevel;
	}

	public void setDictLevel(Integer dictLevel) {
		this.dictLevel = dictLevel;
	}

	@Column(name = "dictValue", length = 50)
	public String getDictValue() {
		return this.dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	@Column(name = "remark", length = 100)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}