package hitwh.fanghh.service;

import java.util.List;

import hitwh.fanghh.bean.StoreAuthenticationBean;
import hitwh.fanghh.bean.UserAuthenticationBean;

/**
 * 认证管理
 *
 * @ClassName: AuthenticationService
 * @Description: TODO
 * @author: ZY
 * @date: 2016年11月29日 下午3:42:51
 *
 */
public interface AuthenticationService
{
	/**
	 * 获取所有门店信息
	 *
	 * @Title: getAllStore
	 * @version:
	 * @author: ZY
	 * 
	 * @param pageMaxNum每页最大数量
	 * @param pageNo页号
	 * @return
	 */
	public List<StoreAuthenticationBean> getAllStore(int pageMaxNum, int pageNo);

	/**
	 * 按关键字（门店名称）搜索获取门店信息
	 *
	 * @Title: getStoreBySearchStoreName
	 * @version:
	 * @author: ZY
	 * 
	 * @param keyStoreName关键字（门店名称）
	 * @param pageMaxNum每页最大数量
	 * @param pageNo页号
	 * @return
	 */
	public List<StoreAuthenticationBean> getStoreBySearchStoreName(String keyStoreName, int pageMaxNum, int pageNo);

	/**
	 * 获取单个门店信息
	 *
	 * @Title: getSingleStore
	 * @version:
	 * @author: ZY
	 * 
	 * @param storeId
	 * @return
	 */
	public StoreAuthenticationBean getSingleStore(int storeId);

	/**
	 * 门店认证
	 *
	 * @Title: authenticateStore
	 * @version:
	 * @author: ZY
	 * 
	 * @param storeId
	 * @param status是否通过
	 * @param failedReason未通过原因
	 * @return
	 */
	public String authenticateStore(int storeId, boolean status, String failedReason);

	/**
	 * 获取页数
	 *
	 * @Title: getStoreAuthenticationPageNum
	 * @version:
	 * @author: ZY
	 * 
	 * @param pageMaxNum
	 * @return
	 */
	public int getStoreAuthenticationPageNum(int pageMaxNum);
	/**
	 * 用户认证审核
	 *
	 * @Title: authenticateUser
	 * @version:
	 * @author: LY
	 * 
	 * @param userId
	 * @param status是否通过
	 * @return
	 */
	public String authenticateUser(int userId, boolean status , String failedReason);
	/**
	 * 获取所有用户
	 *
	 * @Title: getAllUser
	 * @version:
	 * @author: LY
	 * 
	 * @param pageMaxNum每页最大数量
	 * @param pageNo页号
	 * @return
	 */
	public List<UserAuthenticationBean> getAllUser(int pageMaxNum, int pageNo);
	/**
	 * 按关键字（用户名称）搜索获取用户认证信息
	 *
	 * @Title: getUserBySearchStoreName
	 * @version:
	 * @author: LY
	 * 
	 * @param keyUserName关键字（用户名称）
	 * @param pageMaxNum每页最大数量
	 * @param pageNo页号
	 * @return
	 */
	public List<UserAuthenticationBean> getUserBySearchUserName(String keyUserName, int pageMaxNum, int pageNo);
	/**
	 * 获取单个用户认证信息
	 *
	 * @Title: getSingleUser
	 * @version:
	 * @author: LY
	 * 
	 * @param userId
	 * @return
	 */
	public UserAuthenticationBean getSingleUser(int userId);
	/**
	 * 获取页数
	 *
	 * @Title: getUserAuthenticationPageNum
	 * @version:
	 * @author: LY
	 * 
	 * @param pageMaxNum
	 * @return
	 */
	public int getUserAuthenticationPageNum(int pageMaxNum);
	/**
	 * 通过用户身份证查询认证信息
	 *
	 * @Title: getUserByIdNum
	 * @version:
	 * @author: LY
	 * 
	 * @param pageMaxNum
	 * @return
	 */
	public UserAuthenticationBean getUserByIdNum(String userIdNum);
	/**
	 * 通过用户用户名查询认证信息
	 *
	 * @Title: getUserByIdNum
	 * @version:
	 * @author: LY
	 * 
	 * @param pageMaxNum
	 * @return
	 */

	public UserAuthenticationBean getUserByUserName(String userName);

	List<UserAuthenticationBean> getUserBySearchKeyUserNameAndKeyRealNameAndIdNum(String keyBrokerName,
			String keyRealName, String IdNum, int pageMaxNum, int pageNo);
}
