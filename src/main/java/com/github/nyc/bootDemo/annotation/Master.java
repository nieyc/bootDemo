package com.github.nyc.bootDemo.annotation;

import java.lang.annotation.*;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:13 2019/3/21
 * @Description:读写分离情况下，有些查询需要走master数据库，只需加上此注解即可
 **/
@Target({ElementType.METHOD, ElementType.TYPE})//用于描述注解的使用范围 METHOD:用于描述方法,TYPE 用于描述类或接口（甚至 enum ）
@Retention(RetentionPolicy.RUNTIME)//用于描述注解的生命周期,RUNTIME代表运行时
@Documented
@Inherited
public @interface Master {
}
