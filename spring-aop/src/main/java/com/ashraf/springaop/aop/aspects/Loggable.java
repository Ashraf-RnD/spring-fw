/*
 * Md Ashraful Alam
 * 7/3/20, 11:37 AM
 */

package com.ashraf.springaop.aop.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Loggable {
    boolean enable() default true;
}
