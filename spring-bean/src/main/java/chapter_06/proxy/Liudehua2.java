package chapter_06.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuxin
 * @version Id: Liudehua2.java, v 0.1 2018/7/20 下午4:53
 */

class Liudehua2 implements Singer {
    @Override
    public void sing(String song) {
        System.out.println("刘德华唱了一首:" + song);
    }
}
class ldhProxyHander implements InvocationHandler {
    Object target;

    public ldhProxyHander(Object srcObj) {
        this.target = srcObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开场报幕");
        Object invoke = method.invoke(target, args);
        System.out.println("结束再见");
        return invoke;
    }
}
class Main {
    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Singer ldh = (Singer) Proxy.newProxyInstance(contextClassLoader,
                Liudehua2.class.getInterfaces(), new ldhProxyHander(new Liudehua2()));
        ldh.sing("爱你一万年");
    }
}
