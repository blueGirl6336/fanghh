// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.util.CustomDateDeserializer;
import hitwh.fanghh.manage.util.CustomDateSerializer;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * TransactionCheckPic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TransactionCheckPic", schema = "dbo")
public class TransactionCheckPic implements java.io.Serializable {

	// Fields

	private Integer id;
	private TransactionValueCheck transactionValueCheck;
	private String evidenceSource;
	private String evidencePic;
	private Date uploadTime;

	// Constructors

	/** default constructor */
	public TransactionCheckPic() {
	}

	/** full constructor */
	public TransactionCheckPic(TransactionValueCheck transactionValueCheck,
			String evidenceSource, String evidencePic, Date uploadTime) {
		this.transactionValueCheck = transactionValueCheck;
		this.evidenceSource = evidenceSource;
		this.evidencePic = evidencePic;
		this.uploadTime = uploadTime;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "check_id")
	public TransactionValueCheck getTransactionValueCheck() {
		return this.transactionValueCheck;
	}

	public void setTransactionValueCheck(
			TransactionValueCheck transactionValueCheck) {
		this.transactionValueCheck = transactionValueCheck;
	}

	@Column(name = "evidence_source")
	public String getEvidenceSource() {
		return this.evidenceSource;
	}

	public void setEvidenceSource(String evidenceSource) {
		this.evidenceSource = evidenceSource;
	}

	@Column(name = "evidence_pic")
	public String getEvidencePic() {
		return this.evidencePic;
	}

	public void setEvidencePic(String evidencePic) {
		this.evidencePic = evidencePic;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upload_time", length = 23)
	public Date getUploadTime() {
		return this.uploadTime;
	}
	@JsonDeserialize(using = CustomDateDeserializer.class)
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}