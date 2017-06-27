package hitwh.fanghh.manage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * 模块列表
 * 
 * @author QIQI
 */
@JsonAutoDetect
@Entity
public class Module {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "module_code",nullable = true)
	// 菜单编码，授权表中使用此代码
	// x0000 x表示大模块
	// 10000 表示系统设置
	private String code;

	@Column(name = "module_name",nullable = true)
	// 菜单名称
	private String name;

	@Column(name = "parent_code",nullable = true)
	// 父节点的编码
	private String parentCode;
	
	@Column(name = "module_level",nullable = true)
	// 模块级别 最顶级是1 层次越深，此值越大
	private Integer level;

	@Column(name = "url",nullable = true)
	// 指向的url,view的文件名
	private String url;

	// 模块对应的目录名，模块英文名
	// 一个模块的地址为 /逐级path/url
	
	@Column(name = "path",nullable = true)
	private String path;

	// 图标地址
	@Column(name = "icon_url",nullable = true)
	private String iconUrl;
	
	//是否有页面  有的时候一个非叶子节点也有功能页面  比如点击人事基本信息
	@Column(name = "has_page",nullable = true)
	private boolean hasPage;

	//序号，用来控制菜单的顺序
	@Column(name = "module_detailGroup",nullable = true)
	private Integer no;
	
	@Column(name = "remark", nullable = true)
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public boolean isHasPage() {
		return hasPage;
	}

	public void setHasPage(boolean hasPage) {
		this.hasPage = hasPage;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
