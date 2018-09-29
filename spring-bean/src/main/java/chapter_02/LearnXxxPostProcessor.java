package chapter_02;

import entity.CheckCustomerClosed;
import entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utils.Console;

/**
 * PostProcessor流程参考: https://blog.csdn.net/caihaijiang/article/details/35552859
 * <p>
 * ### 为什么我们类名是XxxPostProcessor ？
 * 当BeanDefinition已经通过BeanDefinitionRegistry成功注册到BeanFactory中后,Spring提供了一个供我们一些切入的方法
 * 他们都是以PostProcessor为后缀,前面的Xxx代码了切入的时间点
 * eg:
 * 1. BeanDefinitionRegistryPostProcessor
 * 2. BeanFactoryPostProcessor
 * 3. beanPostProcessor
 * <p>
 * 下面我们分别学习
 *
 * @author liuxin
 * @version Id: LearnBeanFactoryPostProcessor.java, v 0.1 2018/6/25 下午2:59
 */
public class LearnXxxPostProcessor {
    /**
     * 初始化前再给开发者最后两次修改BeanDefinition的机会
     * <p>
     * 1. AbstractApplicationContext.refresh.invokeBeanFactoryPostProcessors(beanFactory);
     * |
     * |->1.1 PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors
     * <p>
     * 初始化前再给开发者两次机会修改BeanDefinition的机会
     * 1.1.1 invokeBeanFactoryPostProcessors中调用
     * PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors()中在调用下面两个
     * 第一次: 1.1.1.1 BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()
     * 第二次: 1.1.1.2 BeanFactoryPostProcessor.postProcessBeanFactory()
     */
    public static void main(String[] args) {
        beanDefinitionRegistryPostProcessor();
        beanFactoryPostProcessor();
        beanPostProcessor();
    }

    /**
     * BeanDefinitionRegistryPostProcessor
     * 在里面第一次通过切面的形式修改beanName为checkCustomerClosed
     * 的销毁方法
     */
    private static void beanDefinitionRegistryPostProcessor() {
        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("CheckCustomerClosed.xml",
                "CheckBeanDefinitionRegistryImpl.xml");
        CheckCustomerClosed bean = xml.getBean(CheckCustomerClosed.class);
        Console.log(bean.getTest());
        xml.close();
    }

    /**
     * BeanFactoryPostProcessor
     * 在里面第二次通过切面的形式修改beanName为checkCustomerClosed
     * 的销毁方法
     */
    private static void beanFactoryPostProcessor() {
        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("CheckCustomerClosed.xml", "CheckBeanDefinitionRegistryImpl.xml");
        CheckCustomerClosed bean = xml.getBean(CheckCustomerClosed.class);
        Console.log(bean.getTest());
        xml.close();
    }

    /**
     * 1. AbstractApplication.finishBeanFactoryInitialization.preInstantiateSingletons
     * 开始实例化Bean
     * 1.1 beanFactory.preInstantiateSingletons();
     * 最终调用getBean方法最终调用AbstractAutowireCapableBeanFactory.doCreateBean方法
     * 1.1.1 AbstractAutowireCapableBeanFactory.doCreateBean.initializeBean()
     * 调用初始化方法
     * - 1.1.1.1 调用BeanPostProcessor.postProcessBeforeInitialization
     * - 1.1.1.2 invokeInitMethods调用InitializingBean.afterPropertiesSet()初始化
     * - 1.1.1.3 调用BeanPostProcessor.postProcessAfterInitialization
     */
    private static void beanPostProcessor() {
        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("person.xml", "checkpostprocessor.xml");
        Person bean = xml.getBean(Person.class);
        bean.say();
    }
}
