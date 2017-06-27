package hitwh.fanghh.manage.module.base.util;

public class TeamInvitateCode {
	public static String getTeamInvitateCode(String phoneNo) {
		String originalStr = phoneNo.substring(1);
		char[] strArr = originalStr.toCharArray();
		int n = strArr.length;
		int i = 0, j = n - 1;
		char tmp;
		for (; i < j; i++, j--) {
			if (i % 2 == 0) {
				tmp = strArr[i];
				strArr[i] = strArr[j];
				strArr[j] = tmp;
			}
		}
		String invitateCode = String.valueOf(strArr);
		return invitateCode;
	}

}
