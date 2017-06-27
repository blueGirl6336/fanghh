package hitwh.fanghh.manage.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * 系统参数类
 * 
 * @author QIQI
 */
/*@JsonAutoDetect
@Entity*/
public class ConfigBean {

	@Id
	@GeneratedValue
	private int id;

	//名称
	private String name;

	//显示名称
	private String displayName;

	//设置值
	private String value;

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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
