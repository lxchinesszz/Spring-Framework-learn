package chapter_06.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.stereotype.Component;
import utils.Console;

import javax.xml.ws.Action;

/**
 * Pointcut常见的实现类有如下几种：
 * <p>
 * NameMatchMethodPointcut
 * JdkRegexpMethodPointcut
 * Perl5RegexpMethodPointcut
 * AnnotationMatchingPointcut
 * ComposablePointcut
 * ControlFlowPointcut
 * <p>
 * 1）NameMatchMethodPointcut
 * 最简单的Pointcut实现，是StaticMethodMatcher的子类，可以指定Joinpoint处的方法名称进行匹配。
 * 如：
 * <p>
 * new NameMatchMethodPointcut().setMappedName("login");
 * <p>
 * 2）JdkRegexpMethodPointcut、Perl5RegexpMethodPointcut
 * StaticMethodMatcher下可以使用正则表达式对拦截方法进行匹配，
 * 如：
 * <p>
 * new JdkRegexpMethodPointcut().setPattern(".*doSth().*");
 * <p>
 * 3）AnnotationMatchingPointcut
 * AnnotationMatchingPointcut根据目标对象中是的存在指定类型的注解来匹配Joinpoint。
 * 如：
 * <p>
 * new AnnotationMatchingPointcut(ClassLevelAnnotation.class, MethodLevelAnnotation.class);
 * <p>
 * 以上代码会对使用类注解ClassLevelAnnotation、方法注解MethodLevelAnnotation所匹配到的方法进行拦截。
 * <p>
 * <p>
 * 4）ComposablePointcut
 * ComposablePointcut可以进行Pointcut逻辑运算的Pointcut实现。不常用，不赘述。
 * <p>
 * <p>
 * 5）ControlFlowPointcut
 * 假设要织入的Joinpoint处所在的方法为login(),
 * ControlFlowPointcut可以指定具体的目标对象调用login()才进行拦截，别的目标对象调用login()方法时不会进行拦截。
 * 不常用，不赘述。
 *
 * @author liuxin
 * @version Id: LearnSpringAop.java, v 0.1 2018/7/12 下午4:17
 */
public class LearnSpringAop {
    public static void main(String[] args) {
        /**
         * 方法名匹配
         * 所以：log2没有拦截
         * */
        Console.customerNormal("方法名匹配", "--------------");
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedNames("log");
        advisor.setAdvice(new AopProxyMethodInterceptor());
        jdkAopTest(advisor);
        cglibAopTest(advisor);

        /**
         * 正则匹配
         * 拦截log看头的
         * 所以log和log2都拦截了
         */
        Console.customerNormal("\n\n\n\n正则匹配", "--------------");
        DefaultPointcutAdvisor advisor2 = new DefaultPointcutAdvisor();
        JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
        jdkRegexpMethodPointcut.setPattern(".*log.*()");
        advisor2.setPointcut(jdkRegexpMethodPointcut);
        advisor2.setAdvice(new AopProxyMethodInterceptor());
        jdkAopTest(advisor2);
        cglibAopTest(advisor2);

        /**
         * 拦截指定注解的方法
         *
         */
        Console.customerNormal("\n\n\n\n注解匹配", "--------------");
        /**
         *Component.class,Action.class
         * 在这里只是演示用的,并不是他本身拥有这样的能力
         * 第一个参数是类级别
         * 第二个参数是方法级别
         */
        DefaultPointcutAdvisor advisor3 = new DefaultPointcutAdvisor();
        AnnotationMatchingPointcut annotationMatchingPointcut = new AnnotationMatchingPointcut(Component.class, Action.class);
        advisor3.setPointcut(annotationMatchingPointcut);
        advisor3.setAdvice(new AopProxyMethodInterceptor());
        jdkAopTest(advisor3);
        cglibAopTest(advisor3);
        /**
         *
         */
        Console.customerNormal("\n\n\n\n指定类和指定方法拦截", "--------------");
        DefaultPointcutAdvisor advisor4= new DefaultPointcutAdvisor();
        ControlFlowPointcut controlFlowPointcut=new ControlFlowPointcut(CglibAopTest.class,"log2");
        advisor4.setPointcut(controlFlowPointcut);
        advisor4.setAdvice(new AopProxyMethodInterceptor());
        cglibAopTest(advisor4);
    }

    public static void jdkAopTest(Advisor advisor) {
        JdkAopInterfaceTest jdkAopTest = new JdkAopTest();
        ProxyFactory weaver = new ProxyFactory(jdkAopTest);
        weaver.addAdvisor(advisor);
        weaver.setInterfaces(JdkAopInterfaceTest.class);
        //返回代理对象
        JdkAopInterfaceTest jdkAop = (JdkAopInterfaceTest) weaver.getProxy();
        jdkAop.log();
        jdkAop.log2();
        System.out.println(jdkAop.getClass());
    }

    public static void cglibAopTest(Advisor advisor) {
        CglibAopTest cglibAopTest = new CglibAopTest();
        ProxyFactory weaver = new ProxyFactory(cglibAopTest);
        weaver.addAdvisor(advisor);
        //返回代理对象
        CglibAopTest aopProxy = (CglibAopTest) weaver.getProxy();
        aopProxy.log();
        aopProxy.log2();
        System.out.println(aopProxy.getClass());
    }

    public interface JdkAopInterfaceTest {
        void log();

        void log2();
    }

    @Component
    public static class JdkAopTest implements JdkAopInterfaceTest {
        @Override
        @Action
        public void log() {
            Console.log("JDK-AOP");
        }

        @Override
        public void log2() {
            Console.log("JDK-AOP2");
        }
    }

    @Component
    public static class CglibAopTest {

        public void log() {
            Console.normal("Cglib-AOP");
        }

        @Action
        public void log2() {
            Console.normal("Cglib-AOP2");
        }
    }

    public static class AopProxyMethodInterceptor implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            try {
                System.out.println("拦截下，再执行");
                return methodInvocation.proceed();
            } finally {
                System.out.println("拦截结束");
            }
        }
    }
}
