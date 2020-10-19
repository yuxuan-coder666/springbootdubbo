package com.springbdubbo.commons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.HibernateValidator;

/**
 * 参数校验工具
 * @author liuyuxuan
 *
 */
public class ValidationUtils {
	
	/**
     * 使用hibernate的注解来进行验证
     */
    private static Validator validator = Validation.byProvider(HibernateValidator.class)
            .configure().failFast(true).buildValidatorFactory().getValidator();
 
    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj obj
     */
    public static <T> String validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        // 检验不合格处理
        if (BaseUtils.isNotEmpty(constraintViolations)) {
            List<String> tipList = new ArrayList<>();
            constraintViolations.forEach(constraintViolationImpl -> tipList.add(constraintViolationImpl.getMessage()));
            return StringUtils.join(tipList, ",");
        } else {
            return "";
        }
 
    }

}
