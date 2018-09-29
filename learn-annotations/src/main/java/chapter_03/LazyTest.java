package chapter_03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuxin
 * @version Id: LazyTest.java, v 0.1 2018/9/27 4:23 PM
 */
public class LazyTest {

    /**
     * 什么是懒加载?
     * 懒加载不使用不加载,使用的时候才去加载!
     * 两种配置方法
     * xml配置文件中bean标签的lazy属性
     * @Lazy注解
     * @param args
     */
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:spring-lazy.xml");
        // 控制台打印
        //init-method:这是一个nolazy的bean
        //init-method:这是一个未决的的bean
    }


}

