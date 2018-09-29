package entity;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import utils.Console;

/**
 * @author liuxin
 * @version Id: Person.java, v 0.1 2018/6/7 下午10:58 liuxin Exp $$
 */
public class Person implements DisposableBean, InitializingBean {
    private String name = "测试小王子";


    public void say() {
        Console.log("我是" + name);
    }

    @Override
    public void destroy() throws Exception {
        Console.customerNormal("验证DisposableBean方法destroy", "销毁方法执行");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Console.customerNormal("验证InitializingBean方法初始化", "初始化方法执行");
    }

    public void customerDestoryMethod() {
        Console.normal("DisposableBean自定义销毁方法");
    }

    public void customerDestoryMethod2() {
        Console.normal("xml中自定义销毁方法");
    }

}
