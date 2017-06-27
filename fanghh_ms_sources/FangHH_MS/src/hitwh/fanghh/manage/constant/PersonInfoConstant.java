package hitwh.fanghh.manage.constant;

public class PersonInfoConstant {

	// 工作状态 数据字典组 2030000
	public static final String WORKSTATE_WORK = "2030001"; // 在职
	public static final String WORKSTATE_DIMISSION = "2030002"; // 离职
	public static final String WORKSTATE_RETIREMENT = "2030003"; // 离退休
	public static final String WORKSTATE_DEATH = "2030004"; // 去世

	// 审核状态
	public static final int CHECK_DONOTLOOK = 0; // 用户未浏览
	public static final int CHECK_UPATING = 1; // 正在修改
	public static final int CHECK_FAIL = 2; // 未通过
	public static final int CHECK_SUBMIT = 3; // 用户已提交，待审核
	public static final int CHECK_Pending = 5; // 审核待定
	public static final int CHECK_WAITCHECK = 7; // 留待查询
	public static final int CHECK_FINISH = 10; // 审核完毕

	public static int getStatusByString(String statusString) {
		if ("审核完毕".equals(statusString)) {
			return 10;
		}
		if ("未通过".equals(statusString)) {
			return 2;
		}
		if ("用户已提交，待审核".equals(statusString)) {
			return 3;
		}
		if ("用户未浏览".equals(statusString)) {
			return 0;
		}
		if ("正在修改".equals(statusString)) {
			return 1;
		}
		if ("审核待定".equals(statusString)) {
			return 5;
		}
		if ("留待查询".equals(statusString)) {
			return 7;
		}
		return -1;
	}
	
	//退休年龄定义
	public static final int RETIREMENT_MAN_AGE = 60; // 普通男子退休年龄
	public static final int RETIREMENT_WOMAN_AGE = 55; // 普通女子退休年龄
	public static final int RETIREMENT_MAN_BODAO_AGE = 65; // 带头人，博导男子退休年龄
	public static final int RETIREMENT_WOMAN_BODAO_AGE = 65; // 带头人，博导女子退休年龄
	public static final int RETIREMENT_SERVICE_MAN_AGE = 60; // 工勤男子退休年龄
	public static final int RETIREMENT_SERVICE_WOMAN_AGE = 50; // 工勤女子退休年龄
	
	//档案类别
	public static final String ARCHIVE_PERSONAL_FILES = "0";  //人事档案类别号
	public static final String ARCHIVE_SCHOOL_FILES = "1";  //校内档案类别号
	
	//登录失败次数限制
	public static final int LOGIN_FAILURE_USERNAME_RESTRICTION = 6; // 用户名登录限制
	public static final int LOGIN_FAILURE_IP_RESTRICTION = 10; // 用户名登录限制
	

}
