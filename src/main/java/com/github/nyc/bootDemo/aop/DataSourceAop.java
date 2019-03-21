package com.github.nyc.bootDemo.aop;

/**
 * @author:nieyc
 * @company:panchan
 * @Date:created in 15:03 2019/3/21
 * @Description
 **/

import com.github.nyc.bootDemo.annotation.Master;
import com.github.nyc.bootDemo.bean.DBContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Results;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAop {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

   /* @Pointcut("!@annotation(com.github.nyc.bootDemo.annotation.Master) " +
            "&& (execution(* com.github.nyc.bootDemo.demo..*service.select*(..)) " +
            "|| execution(* com.github.nyc.bootDemo.demo..*service.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.github.nyc.bootDemo.annotation.Master) " +
            "|| execution(* com.github.nyc.bootDemo.demo..*service.insert*(..)) " +
            "|| execution(* com.github.nyc.bootDemo.demo..*service.add*(..)) " +
            "|| execution(* com.github.nyc.bootDemo.demo..*service.update*(..)) " +
            "|| execution(* com.github.nyc.bootDemo.demo..*service.edit*(..)) " +
            "|| execution(* com.github.nyc.bootDemo.demo..*service.delete*(..)) " +
            "|| execution(* com.github.nyc.bootDemo.demo..*service.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
*/

    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     *
     * execution()是最常用的切点函数，其语法如下所示：
         整个表达式可以分为五个部分：
         1、execution(): 表达式主体。
         2、第一个*号：表示返回类型，*号表示所有的类型。
         3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.github.nyc.bootDemo.demo包、子孙包下所有类的方法。
         4、第二个*号：表示类名，*号表示所有的类。
         5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
     */
    @Before("execution(* com.github.nyc.bootDemo.demo..*Service.*(..))")
    public void before(JoinPoint jp) {
       String methodName = jp.getSignature().getName();
       Signature signature = jp.getSignature();
       MethodSignature methodSignature = (MethodSignature)signature;
       Method targetMethod = methodSignature.getMethod();
       //方法前有@master 注解的，全部走主库
       if(targetMethod.getAnnotation(Master.class)!=null){
           DBContextHolder.master();
       }else{
           if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
               DBContextHolder.slave();
           }else {
               DBContextHolder.master();
           }

       }
   }

    @After("execution(* com.github.nyc.bootDemo.demo..*Service.*(..))")
    public void doAfterReturning() throws Throwable {
        // 处理完请求，返回内容
        logger.info("remove .................");
        DBContextHolder.remove();
    }
}
