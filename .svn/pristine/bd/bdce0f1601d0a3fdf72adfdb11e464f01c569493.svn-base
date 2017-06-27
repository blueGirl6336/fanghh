package hitwh.fanghh.manage.ext.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 树状节点 用来显示
 * 
 * @author QIQI
 */
public class TreeNode {

	// 显示文字
	private String text;

	// 是否展开
	private boolean expanded;

	// id 用来区分 不能重复
	private int id;

	// 是否是叶子节点
	private boolean leaf;

	// 点击连接
	private String url;

	// 文件路径
	private String path;

	// 序号
	private int no;

	// 点击是否会打开页面
	private boolean hasFunction = false;

	private List<TreeNode> children;

	public TreeNode(String text, int id) {
		this.text = text;
		this.id = id;
		this.expanded = false;
		this.leaf = true;
		this.url = "";
		this.children = null;
	}

	public void addChild(TreeNode aNode) {
		// TODO:添加顺序
		this.leaf = false;
		//this.expanded = true;
		if (this.children == null) {
			this.children = new ArrayList<TreeNode>();
		}
		int no = aNode.getNo();
		int index = 0;
		for(int i = 0; i < this.children.size(); i++){
			index = i;
			if(this.children.get(i).getNo() < no){
				index = i+1;
				continue;
			}else
				break;
		}
		this.children.add(index, aNode);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expand) {
		this.expanded = expand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isHasFunction() {
		return hasFunction;
	}

	public void setHasFunction(boolean hasFunction) {
		this.hasFunction = hasFunction;
	}

	@Override
	public String toString() {
		String result = "";
		if (this.children != null && this.children.size() >= 1) {
			result += ("+" + this.text + "\n");
			for (int i = 0; i < this.children.size(); i++) {
				result += "  " + this.children.get(i).toString();
			}
		} else {
			result += ("-" + this.text + "\n");
		}
		return result;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
