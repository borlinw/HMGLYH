package com.hdsx.hmglyh.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 细颗粒 权限 控制
 * @author zhanglm
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationAuth {
	String mkid(); // 模块 ID (权限)
}
