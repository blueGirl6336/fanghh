package hitwh.fanghh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import hitwh.fanghh.util.DictionaryString;

/**
 * 用户权限注解
 *
 * @ClassName: RequiredPermission
 * @Description: TODO
 * @author: ZY
 * @date: 2016年11月23日 下午4:24:42
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredPermission
{
	// 用户角色的枚举
	public enum Roles
	{
		// 权限级别,0最小
		USER_WRITER(DictionaryString.USER_WRITER, 0), // 平台录入员
		USER_ADMIN(DictionaryString.USER_ADMIN, 1), // 平台管理员
		SYS_ADMIN(DictionaryString.SYS_ADMIN, 2);// 系统管理员

		private String roleCode;
		private int roleLevel;

		private Roles(String roleCode, int roleLevel)
		{
			this.roleCode = roleCode;
			this.roleLevel = roleLevel;
		}

		public String getRoleCode()
		{
			return roleCode;
		}

		public int getRoleLevel()
		{
			return roleLevel;
		}
	};

	// 默认需要的权限权限为用户管理员
	public Roles role() default Roles.USER_ADMIN;
}
