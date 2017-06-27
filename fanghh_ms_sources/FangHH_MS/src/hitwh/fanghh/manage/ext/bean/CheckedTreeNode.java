package hitwh.fanghh.manage.ext.bean;

/**
 * 可验证菜单树节点 用来确定权限的选择
 * 
 * @author QIQI
 */
public class CheckedTreeNode extends TreeNode {

	// 知否被选中
	private boolean checked;

	public CheckedTreeNode(String text, int string) {
		super(text, string);
		this.checked = false;
		this.setExpanded(true);
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
