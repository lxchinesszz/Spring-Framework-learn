package chapter_02;

import entity.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author liuxin
 * @version Id: LearnInitAndDisposable.java, v 0.1 2018/6/26 下午2:12
 */
public class LearnInitAndDisposable {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("person.xml");
        /**
         * Person因为继承了InitializingBean和DisposableBean方法
         * 所以在初始化时候和销毁时候都会执行
         * 从设计模式上讲，这两个接口都是只有一个方法,验证了最小接口隔离原则
         * 1. 一个类对另一个类的依赖应该建立在最小的接口上(扩展灵活,谁扩展谁用)。
         * 2. 接口要最小化,功能更细分. 目的是:不需要的功能,就不要去实现
         */
        Person person = xml.getBean(Person.class);
        person.say();
        xml.close();

        /**
         * BeanFactory
         */
        BeanFactory beanFactory;
        /**
         *BeanDefinition
         */
        BeanDefinition beanDefinition;


        ApplicationContext applicationContext;

    }
}
