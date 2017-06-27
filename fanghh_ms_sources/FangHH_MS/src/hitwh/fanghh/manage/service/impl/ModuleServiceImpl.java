package hitwh.fanghh.manage.service.impl;

import hitwh.fanghh.manage.dao.ModuleDao;
import hitwh.fanghh.manage.dao.PermissionDao;
import hitwh.fanghh.manage.ext.bean.CheckedTreeNode;
import hitwh.fanghh.manage.ext.bean.TreeNode;
import hitwh.fanghh.manage.pojo.Module;
import hitwh.fanghh.manage.pojo.Permission;
import hitwh.fanghh.manage.service.ModuleService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleDao moduleDao;

	@Autowired
	private PermissionDao permissionDao;

	public void add(Module m) {
		this.moduleDao.add(m);
	}

	/**
	 * 
	 * @Description: 通过权限号获取能访问的模块列表
	 * 
	 * @param role
	 *            : 权限编号
	 * @param startLevel
	 *            : 模块等级下限
	 * @return:
	 */
	public List<Module> getByRole(String role, int minLevel, int maxLevel) {
		return this.moduleDao.getByRole(role, minLevel, maxLevel);
	}

	// 获取所有的模块
	public List<Module> getAll() {
		return this.moduleDao.getAll();
	}
	
	
	/**
	 * 
	 * @Description:通过级别限定获取的模块 
	 * 
	 * @param minLevel
	 * @param maxLevel
	 * @return:
	 */
	public List<Module> getByLevel(int minLevel, int maxLevel) {
		return this.moduleDao.getByLevel(minLevel, maxLevel);
	}

	/**
	 * 生成节点树
	 * 
	 * @param mList
	 *            :根据角色权限定义获得的可访问模块名
	 * @return 带有所有节点的根节点
	 */
	public CheckedTreeNode generateTree(List<Module> mList) {

		// 产生根节点
		CheckedTreeNode root = new CheckedTreeNode(".", 0);

		// 此处添加一个List，用来记录已经生成树中的节点ID，这样可以减少插入节点时的递归搜索次数
		HashMap<String,CheckedTreeNode> treeMap = new HashMap<String, CheckedTreeNode>();

		int loopLimit = 10;

		while (mList.size() > 0 && loopLimit > 0) {
			for (Iterator<Module> it = mList.iterator(); it.hasNext();) {
				Module n = it.next();
				// 判断是否需要限制目录层次
				if (n.getLevel() == 0) {
					// 如果是最顶层模块，将模块添加到根节点下
					CheckedTreeNode t = new CheckedTreeNode(n.getName(),
							new Integer(n.getCode()));
					root.addChild(t);
					treeMap.put(n.getCode(), t);
					it.remove();
				} else {
					if (treeMap.containsKey(n.getParentCode())) {
						// 如果父节点在Map中,将它添加到父节点的子列表中
						// 初始化treenode
						CheckedTreeNode t = new CheckedTreeNode(n.getName(),
								new Integer(n.getCode()));
						// 获得父节点
						CheckedTreeNode parentNode = treeMap.get(n
								.getParentCode());

						t.setNo(n.getNo());
						parentNode.addChild(t);
						treeMap.put(n.getCode(), t);
						it.remove();
					}
				}
			}
			loopLimit--;
		}
		return root;
	}

	/**
	 * 生成节点树的重载，不需要考虑权限
	 * 
	 * @param mList
	 *            :根据角色权限定义获得的可访问模块名
	 * @param pList
	 *            :权限列表
	 * @param level
	 *            :模块层次限制，限制显示多少级菜单，-1为不限制
	 * @return 带有所有节点的根节点
	 */
	public TreeNode generateTree(List<Module> mList, int level) {
		TreeNode root = new TreeNode(".", 0);
		// 此处添加一个List，用来记录已经生成树中的节点ID，这样可以减少插入节点时的递归搜索次数
		HashMap<String, TreeNode> treeMap = new HashMap<String, TreeNode>();

		boolean levelLimit = false;
		if (level > 0)
			levelLimit = true;

		int loopLimit = 12;
		while (mList.size() > 0 && loopLimit > 0) {
			for (Iterator<Module> it = mList.iterator(); it.hasNext();) {
				Module n = it.next();
				// 判断是否需要限制目录层次
				if (levelLimit && new Integer(n.getCode() )>level) {
					it.remove();
					continue;
				}
				if (n.getLevel() == 1) {
					// 如果是最顶层模块，将模块添加到根节点下
					TreeNode t = new TreeNode(n.getName(), new Integer(n.getCode()));
					t.setUrl(n.getUrl());
					t.setPath(n.getPath());
					t.setHasFunction(n.isHasPage());
					t.setNo(n.getNo());
					root.addChild(t);
				
					treeMap.put(n.getCode(), t);
					it.remove();
				} else {
					if (treeMap.containsKey(n.getParentCode())) {
						// 如果父节点在Map中,将它添加到父节点的子列表中
						// 初始化treenode
						TreeNode t = new TreeNode(n.getName(), new Integer(n.getCode()));
						// 获得父节点
						TreeNode parentNode = treeMap.get(n.getParentCode());
						String path = parentNode.getPath();
						if (n.getPath() != null && n.getPath().length() > 0)
							path = path + "." + n.getPath();
						t.setPath(path);
						t.setUrl(n.getUrl());
						t.setNo(n.getNo());
						t.setHasFunction(n.isHasPage());
						parentNode.addChild(t);
						treeMap.put(n.getCode(), t);
						it.remove();
					}
				}
			}
			loopLimit--;
		}
		// 将最后未添加的模块全部放到根目录下面
		for (int i = 0; i < mList.size(); i++) {
			Module m = mList.get(i);
			TreeNode t = new TreeNode(m.getName(), new Integer(m.getCode()));
			t.setUrl(m.getUrl());
			root.addChild(t);
		}
		return root;
	}

	/**
	 * 将Permission List转换成HashMap
	 * 
	 * @param pList
	 * @return
	 */
	public HashMap<Integer, Permission> convertPermissionListToMap(
			List<Permission> pList) {
		int length = pList.size();
		HashMap<Integer, Permission> pMap = new HashMap<Integer, Permission>();
		for (int i = 0; i < length; i++) {
			pMap.put(pList.get(i).getModuleCode(), pList.get(i));
		}
		return pMap;
	}
}
