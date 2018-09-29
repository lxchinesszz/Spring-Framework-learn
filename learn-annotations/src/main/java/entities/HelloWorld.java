package entities;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @author liuxin
 * @version Id: HelloWorld.java, v 0.1 2018/9/25 下午9:43
 * ConfigurableBeanFactory.SCOPE_PROTOTYPE 原型模式
 * ConfigurableBeanFactory.SCOPE_SINGLETON 单例模式
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Lazy
public class HelloWorld {

    public String describe;

    public HelloWorld(String describe) {
        this.describe = describe;
    }

    public void initMethod(){
        System.out.println("init-method:"+describe);
    }

    public void destroy(){
        System.out.println("destory-method");
    }
    @Override
    public String toString() {
        return "HelloWorld{" +
                "describe='" + describe + '\'' +
                '}';
    }
}
