package hitwh.fanghh.manage.service;

import hitwh.fanghh.manage.ext.bean.CheckedTreeNode;
import hitwh.fanghh.manage.ext.bean.TreeNode;
import hitwh.fanghh.manage.pojo.Module;

import java.util.List;


public interface ModuleService {
	
	public void add(Module m);

	public List<Module> getByRole(String role, int minLevel, int maxLevel);
	
	public List<Module> getAll();
	
	public List<Module> getByLevel(int minLevel, int maxLevel);
	
	public CheckedTreeNode generateTree(List<Module> mList);
	
	public TreeNode generateTree(List<Module> mList, int level);
}
