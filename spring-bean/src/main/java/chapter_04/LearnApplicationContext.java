package chapter_04;

import chapter_04.document.TestComponent;
import entity.CheckCustomerClosed;
import entity.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.Console;

import java.util.Arrays;

/**
 * 我们要弄清StandardXMl是如何被装换成BeanDefinition并被注册到AbstractApplicationContext上的
 * 它的调用时间点和调用过程是什么样的。
 * 抽象应用上下文,通用方法都在其内部调用
 * AbstractApplicationContext abstractApplicationContext;
 * @author liuxin
 * @version Id: LearnApplicationContext.java, v 0.1 2018/6/26 下午3:45
 */
public class LearnApplicationContext {
    public static void main(String[] args) {
        parseXmlProcess();
//        annotationProcess();
    }

    private static void annotationProcess(){
        AnnotationConfigApplicationContext annotationApplicationContext =
                new AnnotationConfigApplicationContext();
        Arrays.stream(annotationApplicationContext.getBeanDefinitionNames()).forEach(Console::normal);
        annotationApplicationContext.scan("chapter_04/document");
        annotationApplicationContext.refresh();
        TestComponent testComponent = annotationApplicationContext.getBean(TestComponent.class);
        testComponent.say("注解扫描实现");
        BeanDefinition beanDefinition = annotationApplicationContext.getBeanDefinition("testComponent");
        Console.normal(beanDefinition);
    }

    private static void parseXmlProcess() {
        /**
         * //注意:
         * 1. applicationContext 作为父上下问
         */
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("CheckCustomerClosed.xml"
                        , "CheckBeanDefinitionRegistryImpl.xml");
        applicationContext.getBean(CheckCustomerClosed.class).customerClosed();
        applicationContext.getEnvironment().getActiveProfiles();

        /**
         * //注意:
         * 1. xmlApplicationContext作为子上下问,其构造中父上下文作为参数传递
         * 所以xmlApplicationContext包含有父applicationContext一样的内容
         */
        ClassPathXmlApplicationContext xmlApplicationContext =
                new ClassPathXmlApplicationContext(new String[]{"person.xml"}, applicationContext);
        Person person = xmlApplicationContext.getBean(Person.class);
        person.say();
        xmlApplicationContext.getBean(CheckCustomerClosed.class).customerClosed();
    }
}
