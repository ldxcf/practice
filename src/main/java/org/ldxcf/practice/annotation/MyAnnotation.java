package org.ldxcf.practice.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * 用来定义类，指定类的TableName的
 * @author Administrator
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface MyAnnotation {
	public String table();
	public String description();
}
