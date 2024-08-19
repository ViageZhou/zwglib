package com.zwg.xfj.net;

/**
 * Created by shuidi on 2023/7/17.
 */

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiDoc {

    String value() default "";
}
