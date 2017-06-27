package hitwh.fanghh.manage.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * 权限表
 * 
 * @author QIQI
 * 
 */
@JsonAutoDetect
@Entity
public class Permission {
	@Id
	@GeneratedValue
	private int id;

	// 角色代码
	@Column(name = "roleCode", nullable = true)
	private String roleCode;

	// 模块编码
	@Column(name = "moduleCode", nullable = true)
	private int moduleCode;

	// 模块名称
	@Column(name = "moduleName", nullable = true)
	private String moduleName;
	
	@Column(name = "remark", nullable = true)
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public int getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(int moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
