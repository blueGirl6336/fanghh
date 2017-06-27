// default package
package hitwh.fanghh.manage.pojo.building;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ModuleNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ModuleNews", schema = "dbo")
public class ModuleNews implements java.io.Serializable {

	// Fields

	private Integer mnId;
	private String module;
	private String moduleNews;

	// Constructors

	/** default constructor */
	public ModuleNews() {
	}

	/** full constructor */
	public ModuleNews(String module, String moduleNews) {
		this.module = module;
		this.moduleNews = moduleNews;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "mn_id", unique = true, nullable = false)
	public Integer getMnId() {
		return this.mnId;
	}

	public void setMnId(Integer mnId) {
		this.mnId = mnId;
	}

	@Column(name = "module")
	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Column(name = "module_news")
	public String getModuleNews() {
		return this.moduleNews;
	}

	public void setModuleNews(String moduleNews) {
		this.moduleNews = moduleNews;
	}

}