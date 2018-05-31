package com.skf.management.common;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.skf.management.util.ResultHelper;

//@Aspect
//@Component
public class AnnotationInterceptor {

	private static Logger log = LoggerFactory.getLogger(AnnotationInterceptor.class);

	@Pointcut("@annotation(com.skf.management.common.Permission)")
	public void controllerMethodPointcut() {
	}

	@Around("controllerMethodPointcut()")
	public Object loginInterceptor(ProceedingJoinPoint pjp) {
		Object result = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		String token = request.getHeader(Constant.TOKEN);

		try {
			// [{"key":"SKF_TOKEN","value":"eyJjb2RlIjoiUDAwODg1ODkiLCJyb2xlSWQiOjF9","description":"","enabled":true}]
			if (checkLogin(token)) {
				Signature signature = pjp.getSignature();
				MethodSignature methodSignature = (MethodSignature) signature;
				Method targetMethod = methodSignature.getMethod();
				Method realMethod = pjp.getTarget().getClass().getDeclaredMethod(signature.getName(),
						targetMethod.getParameterTypes());
				Permission annotation = (Permission) realMethod.getAnnotation(Permission.class);
				if (annotation != null && Permission.AnnotationEnum.ADMIN.equals(annotation.value())
						&& !checkAdmin(token)) {
					result = ResultHelper.createResult(Constant.HTTP_TYPE_NO_PERMISSION,
							Constant.HTTP_MSG_NO_PERMISSION);
				} else {
					result = pjp.proceed();
				}
			} else {
				result = ResultHelper.createResult(Constant.HTTP_TYPE_UNLOGIN, Constant.HTTP_MSG_UNLOGIN);
			}
		} catch (Throwable e) {
			result = ResultHelper.createResult(Constant.HTTP_TYPE_ERROR, Constant.HTTP_MSG_ERROR);
			log.debug(e.getMessage());
		}
		return result;
	}

	private boolean checkLogin(String token) {
//		if (token == null || token.length() == 0) {
//			return false;
//		}
//		UserModel user = TokenUtil.parseToken(token);
//		if (user == null || user.getCode() == null || user.getCode().length() == 0) {
//			return false;
//		}
		return true;
	}

	private boolean checkAdmin(String token) {
//		UserModel user = TokenUtil.parseToken(token);
//		if (user.getRoleId() == Constant.ADMIN_CODE) {
//			return true;
//		}
		return false;
	}

}
