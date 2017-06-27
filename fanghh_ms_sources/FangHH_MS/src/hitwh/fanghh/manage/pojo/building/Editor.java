// default package
package hitwh.fanghh.manage.pojo.building;
import hitwh.fanghh.manage.pojo.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Editor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Editor", schema = "dbo")
public class Editor implements java.io.Serializable {

	// Fields

	private Integer editorId;
	private User user;

	// Constructors

	/** default constructor */
	public Editor() {
	}

	/** full constructor */
	public Editor(User user) {
		this.user = user;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "editor_id", unique = true, nullable = false)
	public Integer getEditorId() {
		return this.editorId;
	}

	public void setEditorId(Integer editorId) {
		this.editorId = editorId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}