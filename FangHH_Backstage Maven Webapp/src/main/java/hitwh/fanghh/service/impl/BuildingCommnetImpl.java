package hitwh.fanghh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hitwh.fanghh.dao.BuildingcommentDao;
import hitwh.fanghh.pojo.Building;
import hitwh.fanghh.pojo.Buildingcomment;
import hitwh.fanghh.pojo.Region;
import hitwh.fanghh.service.BuildingComment;
import hitwh.fanghh.util.DictionaryString;

@Service
public class BuildingCommnetImpl implements BuildingComment {

	@Autowired
	private BuildingcommentDao buildingcommentDao;

	/**
	 * @discription {获取楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月14日 上午10:38:30
	 * @param commnetId
	 * @return
	 * @see hitwh.fanghh.service.BuildingComment#selectBuildingComment(java.lang.Integer)
	 */
	@Override
	public Buildingcomment selectBuildingComment(Integer commentId) {
		return buildingcommentDao.selectByPrimaryKey(commentId);
	}

	/**
	 * @discription {根据楼盘号获取楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月27日 下午23:00:30
	 * @param commnetId
	 * @return
	 * @see hitwh.fanghh.service.selectBuildingCommentBybuildingId#selectBuildingCommentBybuildingId(java.lang.Integer)
	 */
	@Override
	public List<Buildingcomment> selectBuildingCommentByBuildingId(
			Integer buildingId) {
		return buildingcommentDao.selectByBuildingId(buildingId);
	}

	/**
	 * @discription {删除楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月14日 上午10:38:30
	 * @param commnetId
	 * @return
	 * @see hitwh.fanghh.service.BuildingComment#deleteBuildingComment(java.lang.Integer)
	 */
	@Override
	public boolean deleteBuildingComment(Integer commentId) {
		int result = buildingcommentDao.deleteByPrimaryKey(commentId);
		if (result == 1)
			return true;
		else
			return false;
	}

	/**
	 * @discription {根据楼盘号获取分页楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月28日 下午22:38:30
	 * @param buildingId
	 *            ，pageMaxNum，pageNo
	 * @return
	 * @see hitwh.fanghh.service.BuildingComment#deleteBuildingComment(java.lang.Integer)
	 */
	@Override
	public List<Buildingcomment> getAllBuildingComment(int buildingId,
			int pageMaxNum, int pageNo) {

		List<Buildingcomment> list = buildingcommentDao
				.selectByBuildingId(buildingId);
		int buildingNum = list.size();
		int pageNum = getBuildingCommentPageNum(pageMaxNum);
		// 若想查看页数大于总页数则返回null
		if (pageNum < pageNo) {
			return null;
		} else {
			List<Buildingcomment> resultList = new ArrayList<Buildingcomment>();
			// 设置起始
			int start = pageMaxNum * (pageNo - 1);
			int end = pageMaxNum * pageNo - 1;
			if (end > buildingNum - 1) {
				end = buildingNum - 1;
			}
			for (int i = start; i <= end; i++) {
				resultList.add(list.get(i));
			}
			return resultList;
		}

	}

	/**
	 * @discription {根据楼盘号获取页数}
	 * @author xingfeng
	 * @created 2016年12月28日 下午22:38:30
	 * @param buildingId
	 *            ，pageMaxNum
	 * @return
	 * @see hitwh.fanghh.service.BuildingComment#deleteBuildingComment(java.lang.Integer)
	 */
	@Override
	public int getBuildingCommentPageNum(int pageMaxNum) {
		if (pageMaxNum < 1) {
			pageMaxNum = 1;
		}
		List<Buildingcomment> list = buildingcommentDao.getAllBuildingComment();
		int buildingNum = list.size();
		return buildingNum % pageMaxNum == 0 ? buildingNum / pageMaxNum
				: buildingNum / pageMaxNum + 1;
	}

	/**
	 * @discription {获取所有楼圈点评信息}
	 * @author xingfeng
	 * @created 2016年12月28日 下午22:38:30
	 * @return
	 * @see hitwh.fanghh.service.BuildingComment#deleteBuildingComment(java.lang.Integer)
	 */
	@Override
	public List<Buildingcomment> getAllBuildingCommentInfo(int pageMaxNum,
			int pageNo) {
		List<Buildingcomment> list = buildingcommentDao.getAllBuildingComment();
		int buildingNum = list.size();
		int pageNum = getBuildingCommentPageNum(pageMaxNum);
		// 若想查看页数大于总页数则返回null
		if (pageNum < pageNo) {
			return null;
		} else {
			List<Buildingcomment> resultList = new ArrayList<Buildingcomment>();
			// 设置起始
			int start = pageMaxNum * (pageNo - 1);
			int end = pageMaxNum * pageNo - 1;
			if (end > buildingNum - 1) {
				end = buildingNum - 1;
			}
			for (int i = start; i <= end; i++) {
				resultList.add(list.get(i));
			}
			return resultList;
		}

	}

	  
	    /** 
	     * @discription {在此输入一句话描述作用}
	     * @author wangxinjie       
	     * @created 2016年12月30日 下午3:33:56      
	     * @param commentId
	     * @param checkResult
	     * @return     
	     * @see hitwh.fanghh.service.BuildingComment#buildingCommentCheckNotPass(int, boolean)     
	     */  
	    
	@Override
	public boolean buildingCommentCheckNotPass(int commentId,
			boolean checkResult) {
		Buildingcomment buildingcomment = buildingcommentDao.selectByPrimaryKey(commentId);
		if(checkResult){
			buildingcomment.setCommentCheckStatus(DictionaryString.AUDIT_PASS);
			int result = buildingcommentDao.updateByPrimaryKeySelective(buildingcomment);
			if(result == 1)
				return true;
		}else{
			buildingcomment.setCommentCheckStatus(DictionaryString.AUDIT_NOT_PASS);
			int result = buildingcommentDao.updateByPrimaryKeySelective(buildingcomment);
			if(result == 1)
				return true;
		}
		return false;
	}

}
