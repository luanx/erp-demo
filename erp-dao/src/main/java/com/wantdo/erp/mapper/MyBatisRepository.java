package com.wantdo.erp.mapper;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @ Date : 16/4/4
 * @ From : erp-demo
 * @ Author : luanx@wantdo.com
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisRepository {
    String value() default "";
}