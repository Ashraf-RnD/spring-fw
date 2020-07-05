/*
 * Md Ashraful Alam
 * 7/5/20, 11:59 PM
 */

package com.ashraf.springaop.aop.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BeforeLoggable {
}
