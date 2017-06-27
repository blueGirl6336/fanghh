package hitwh.fanghh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hitwh.fanghh.pojo.Buildingcomment;
import hitwh.fanghh.pojo.Dynamiccontent;
import hitwh.fanghh.pojo.Housepricetrend;

public interface BuildingComment 
{
	/**
	 * @discription {根据楼盘获取分页楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月27日 下午23:10:24
	 * @param commnetId
	 * @return
	 */
	public List<Buildingcomment> getAllBuildingComment(int buildingId,int pageMaxNum,int pageNo);
	
	/**
	 * @discription {获取页数}
	 * @author xingfeng
	 * @created 2016年12月27日 下午23:10:24
	 * @param commnetId
	 * @return
	 */
	public int getBuildingCommentPageNum(int pageMaxNum);
	
	/**
	 * @discription {获取楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月14日 下午10:30:05
	 * @param commnetId
	 * @return
	 */
	public Buildingcomment selectBuildingComment(Integer commentId);
	
	/**
	 * @discription {根据楼盘号获取楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月27日 下午22:30:05
	 * @param commnetId
	 * @return
	 */
	public List<Buildingcomment> selectBuildingCommentByBuildingId(Integer buildingId);
	
	/**
	 * @discription {获取所有楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月28日 下午22:30:05
	 * @param commnetId
	 * @return
	 */
	public List<Buildingcomment> getAllBuildingCommentInfo(int pageMaxNum, int pageNo);
	
	/**
	 * @discription {删除楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月14日 下午10:30:05
	 * @param commnetId
	 * @return
	 */
	public boolean deleteBuildingComment(Integer commentId);

	  
	    /**     
	     * @discription {在此输入一句话描述作用}
	     * @author wangxinjie       
	     * @created 2016年12月30日 下午3:33:43 
	     * @param commentId
	     * @param checkResult
	     * @return     
	     */
	public boolean buildingCommentCheckNotPass(int commentId,
			boolean checkResult);
}