package hitwh.fanghh.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hitwh.fanghh.annotation.RequiredPermission;
import hitwh.fanghh.annotation.RequiredPermission.Roles;

/**
 * 权限拦截切片
 *
 * @ClassName: PermissionAspect
 * @Description: TODO
 * @author: ZY
 * @date: 2016年11月23日 下午4:19:04
 *
 */
@Aspect
@Component
public class PermissionAspect
{
	@Autowired
	HttpSession session;

	@Around(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)&&@annotation(requiredPermission)")
	public Object aroundMethod(ProceedingJoinPoint pjp, RequiredPermission requiredPermission) throws Throwable
	{
		// 从切点上获取目标方法
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();

		// 若目标方法需要检查用户权限
		if (method.isAnnotationPresent(RequiredPermission.class))
		{
			Roles[] roleList = Roles.values();// 权限列表
			Object userRoleCode = session.getAttribute("role");// 用户权限码
			int requiredRoleLevel = requiredPermission.role().getRoleLevel();// 调用此方法需要的权限级别
			int userRoleLevel = 0;// 用户权限级别

			// 查找用户权限级别
			for (Roles role : roleList)
			{
				if (role.getRoleCode().equals(userRoleCode))
				{
					// 追加此判断防止角色重合
					if (userRoleLevel < role.getRoleLevel())
					{
						userRoleLevel = role.getRoleLevel();
					}
				}
			}

			if (userRoleLevel >= requiredRoleLevel)
			{
				return pjp.proceed();
			} else
			{
				throw new PermissionDeniedException("权限不足！");
			}
		}

		// 若目标方法不需要检查用户权限
		return pjp.proceed();
	}

}

class PermissionDeniedException extends RuntimeException
{
	public PermissionDeniedException(String msg)
	{
		super(msg);
	}
}