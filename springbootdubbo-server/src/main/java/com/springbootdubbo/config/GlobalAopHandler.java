package com.springbootdubbo.config;

import com.springbdubbo.commons.utils.BaseUtils;
import com.springbdubbo.commons.utils.ValidationUtils;
import com.springbootdubbo.api.enums.RespCode;
import com.springbootdubbo.api.resp.ApiResult;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * AOP拦截器
 * @author liuyuxuan
 *
 */
@Aspect
@Component
public class GlobalAopHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalAopHandler.class);

    private static final long DEFAULT_EXECUTE_TIME_THRESHOLD = 30000;
    
    @Pointcut("execution(* com.springbootdubbo.*.rpc.*.*(..))")
    public void servicePointcut() {
    }

    @Around("servicePointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
    	try {
    		final long startTime = System.currentTimeMillis();
    		Object result = null;
    		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    		String method = "";
    		if(methodSignature.getMethod() != null) {
    			ApiLog apiLog =  methodSignature.getMethod().getAnnotation(ApiLog.class);
    			method = apiLog.title();
    			logger.info("请求方法:{}", method);
    		}
    		String methodPath = joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName();
    		logger.info("请求方法路径:{}", methodPath);
    		for (Object arg : joinPoint.getArgs()) {
    			String argsJson = BaseUtils.objectToJSON(arg);
    			logger.info("请求参数:{}", argsJson);
    			String validate = ValidationUtils.validate(arg);
    			if(BaseUtils.isNotEmpty(validate)) {
    				result = new ApiResult(RespCode.PARAM_FAIL.getCode(),validate);
    				logger.info("请求方法:{},方法路径:{},返回数据:{}", method, methodPath, BaseUtils.objectToJSON(result));
    				return result;
    			}
    		}
    		Object returnValue = null;
    		try {
    			returnValue = joinPoint.proceed();
			} catch (BusinessException e) {
				result = new ApiResult(e.getErrorCode(),e.getErrorMsg());
				logger.info("发生自定义异常;请求方法:{},方法路径:{},返回数据:{}", method, methodPath, BaseUtils.objectToJSON(result));
				return result;
			} catch (Exception e) {
				result = new ApiResult().FAIL();
				logger.error("系统发生异常;请求方法:{},方法路径:{},异常原因:", method, methodPath, e);
				logger.info("系统发生异常;请求方法:{},方法路径:{},返回数据:{},异常原因:", method, methodPath, BaseUtils.objectToJSON(result), e);
				return result;
			} catch (Throwable e) {
				result = new ApiResult().FAIL();
				logger.error("系统发生异常;请求方法:{},方法路径:{},异常原因:", method, methodPath, e);
				logger.info("系统发生异常;请求方法:{},方法路径:{},返回数据:{},异常原因:", method, methodPath, BaseUtils.objectToJSON(result), e);
				return result;
			}
    		if (returnValue instanceof ApiResult) {
    			ApiResult apiResultModel = (ApiResult) returnValue;
    			final long executeTime = System.currentTimeMillis() - startTime;
    			logger.info("请求方法:{},方法路径:{},返回数据:{},耗时:{}", method, methodPath, BaseUtils.objectToJSON(apiResultModel), executeTime);
    			if (executeTime > DEFAULT_EXECUTE_TIME_THRESHOLD) {
    				logger.error("请求方法:{},方法路径:{},耗时超过阈值:{},耗时:{}", method, methodPath,DEFAULT_EXECUTE_TIME_THRESHOLD, executeTime);
    			}
    		}
    		return returnValue;
		} catch (Exception e) {
			logger.error("系统发生异常;请求方法:{},异常原因:", joinPoint.toLongString(),e);
			return new ApiResult().FAIL();
		}
    }

}
