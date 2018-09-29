package chapter_06.spring;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.AspectJAroundAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @author liuxin
 * @version Id: SpringAOP.java, v 0.1 2018/7/26 上午9:14
 */
public class SpringAOP {
    public static void main(String[] args) {
        //匹配器
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedNames("say");
        advisor.setAdvice(new JayHanler());

        //不设置匹配器默认都拦截
        ProxyFactory proxyFactory = new ProxyFactory();
        //使用Cglib代理
        proxyFactory.setTarget(new Jay());
        //使用接口代理
        proxyFactory.setInterfaces(JayInterface.class);
        proxyFactory.addAdvice(new JayHanler());
        JayInterface proxy = (JayInterface)proxyFactory.getProxy();
        proxy.say("jay");
    }

}
interface JayInterface{
    void say(String sing);
}
class Jay implements JayInterface{
    @Override
    public void say(String sing) {
        System.out.println("say...."+sing);
    }
}
class JayHanler implements MethodBeforeAdvice,AfterReturningAdvice {
    @Override
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("before"+ (String.valueOf(args[0])));
        args[0]="lx";
    }

    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("after");
    }
}
