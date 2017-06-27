package hitwh.fanghh.manage.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 日期记录
 * 
 * @author QIQI
 * 
 */
/*@Entity*/
public class LogBean {

	@Id
	@GeneratedValue
	private int id;

	// 时间
	private String operationTime;

	// 用户名
	private String operator;

	// 登录ip
	private String ip;

	// 操作的对象
	private String opreateEntity;

	// 进行的操作
	private String operation;

	// 备注
	private String remark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOpreateEntity() {
		return opreateEntity;
	}

	public void setOpreateEntity(String opreateEntity) {
		this.opreateEntity = opreateEntity;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
