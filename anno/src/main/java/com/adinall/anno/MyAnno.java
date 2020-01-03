package com.adinall.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * created by ： 游戏人日常
 * Date ： 2019/12/31
 * Desc ：
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface MyAnno {
}
